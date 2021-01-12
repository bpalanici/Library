package DB;

import java.sql.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Vector;

@SuppressWarnings("ALL")
public class DatabaseController {

    public DatabaseController() {
    }

    //login
    public static boolean loginUserSafe(String username, String password) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        CallableStatement cstmt = con.prepareCall("{? = call login_pass(?, ?)}");
        cstmt.registerOutParameter(1, Types.INTEGER);
        cstmt.setString(2, username);
        cstmt.setString(3, password);
        cstmt.execute();
        return (cstmt.getInt(1) == 1);
    }

    public static boolean loginUserUnSafe(String username, String password) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        String querry = "select count(*) as \"COUNT\" from readers " +
                "where username = \'" + username + "\' and password = Encrypt_string(\'" + password + "\')";
        try (Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(querry)) {
            while (rs.next()) {
                if (rs.getInt("COUNT") == 1) {
                    try (CallableStatement cstmt = con.prepareCall("{call update_total_fine(?)}");) {
                        cstmt.setString(1, username);
                        cstmt.execute();
                    }
                    return true;
                }
                else
                    return false;
            }
        }
        return false;
    }

    public static boolean registerUser(String fName, String lName, String username, String password, Integer year, int month, int day) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        CallableStatement cstmt = con.prepareCall("{? = call insert_reader(?, ?, ?, ?, ?)}");
        cstmt.registerOutParameter(1, Types.INTEGER);
        cstmt.setString(2, fName);
        cstmt.setString(3, lName);
        cstmt.setString(4, username);
        cstmt.setString(5, password);
        java.sql.Date sqlDate = java.sql.Date.valueOf(LocalDate.of(year, month, day));
        cstmt.setDate(6, sqlDate);
        cstmt.execute();
        int result = cstmt.getInt(1);
        cstmt.close();

        if (result == 1)
            return true;

        return false;
    }

    public static boolean readBook(String username, String bookName, int rating, String review) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        CallableStatement cstmt = con.prepareCall("{? = call insert_read_book(?, ?, ?, ?)}");
        cstmt.registerOutParameter(1, Types.INTEGER);

        int bookId = -1;
        try (Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select id from books where name = \'" + bookName + "\'")) {
            while (rs.next()) {
                bookId = rs.getInt("ID");
            }
        }
        cstmt.setString(2, username);
        cstmt.setInt(3, bookId);
        cstmt.setInt(4, rating);
        cstmt.setString(5, review);
        cstmt.execute();
        int result = cstmt.getInt(1);
        cstmt.close();
        if (result == 1)
            return true;
        return false;
    }
    public static boolean insertAuthor(String fName, String lName) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        CallableStatement cstmt = con.prepareCall("{? = call insert_author(?, ?)}");
        cstmt.registerOutParameter(1, Types.INTEGER);
        cstmt.setString(2, fName);
        cstmt.setString(3, lName);
        cstmt.execute();
        int result = cstmt.getInt(1);
        cstmt.close();
        if(result == 1)
            return true;
        return false;
    }

    public static int updateGenre(String bookName, String genre) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        CallableStatement cstmt = con.prepareCall("{? = call update_genre_of_book(?, ?)}");
        cstmt.registerOutParameter(1, Types.INTEGER);
        cstmt.setString(2, bookName);
        cstmt.setString(3, genre);
        cstmt.execute();
        int result = cstmt.getInt(1);
        cstmt.close();
        if(result == 1)
            return 1;
        if(result == 0)
            return 0;

        return -1; //nu exista
    }

    public static int updateSubgenre(String bookName, String subgenre) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        CallableStatement cstmt = con.prepareCall("{? = call update_sub_genre_of_book(?, ?)}");
        cstmt.registerOutParameter(1, Types.INTEGER);
        cstmt.setString(2, bookName);
        cstmt.setString(3, subgenre);
        cstmt.execute();
        int result = cstmt.getInt(1);
        cstmt.close();
        if(result == 1)
            return 1;
        if(result == 0)
            return 0;

        return -1; //nu exista
    }
    /*public static void test()
    {
        Connection con = DatabaseConnection.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from table(get_type_dummy())")) {
            while (rs.next()) {
                System.out.println(rs.getInt("ID") + rs.getString("NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    public static boolean insertBook(String bookName, int idAuthor, String isbn, int nrPages, int price) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        CallableStatement cstmt = con.prepareCall("{? = call insert_book(?, ?, ?, ?, ?)}");
        cstmt.registerOutParameter(1, Types.INTEGER);

        cstmt.setString(2, bookName);
        cstmt.setInt(3, idAuthor);
        cstmt.setString(4, isbn);
        cstmt.setInt(5, nrPages);
        cstmt.setInt(6, price);

        cstmt.execute();

        int result = cstmt.getInt(1);
        cstmt.close();
        if(result == 1)
            return true;

        return false;
    }

    public static Vector<Vector> selectTopBooks(int begin, int end, String searchString, String type, String orderType, String ascDescSort) throws SQLException {
        String[] column;
        Vector<Vector> bookTable = new Vector<>();
        Vector<String> columnVector;
        Connection con = DatabaseConnection.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from table(Select_top_books_a_to_b(" + begin + ", " + end + ", \'" + searchString + "\', \'" + type + "\', \'" + orderType + "\', \'" + ascDescSort + "\'))")) {
            while (rs.next()) {
                column = new String[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)};

                bookTable.add(columnVector = new Vector<String>(Arrays.asList(column)));
            }
        }
        return bookTable;
    }

    public static Vector<Vector> selectTopBooksRating(String username) throws SQLException {
        String[] column;
        Vector<Vector> bookTable = new Vector<>();
        Vector<String> columnVector;
        Connection con = DatabaseConnection.getConnection();
        int userid = 1;
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select id from readers where username = \'" + username + "\'")) {
            while (rs.next()) {
                userid = rs.getInt("ID");
            }
        }
        try (Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from (\n" +
                    "  select b.*, g.gname, sg.sgname from books b \n" +
                    "    join genres g on g.booksid = b.id\n" +
                    "    join subgenres sg on sg.booksid = b.id \n" +
                    "    where b.id not in (\n" +
                    "      select distinct booksid from readbooks r where readersid = " + userid +
                    "    )\n" +
                    "    order by b.rating desc\n" +
                    ")\n" +
                    "where rownum <= 50")) {
            while (rs.next()) {
                column = new String[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8)};

                bookTable.add(columnVector = new Vector<String>(Arrays.asList(column)));
            }
        }
        return bookTable;
    }

    public static Vector<Vector> selectTopBooksNrBorrows(String username) throws SQLException {
        String[] column;
        Vector<Vector> bookTable = new Vector<>();
        Vector<String> columnVector;
        Connection con = DatabaseConnection.getConnection();
        int userid = 1;
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select id from readers where username = \'" + username + "\'")) {
            while (rs.next()) {
                userid = rs.getInt("ID");
            }
        }
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from (\n" +
                     "  select b.id, b.name, b.isbn, b.nrpages, b.price, b.rating, g.gname, sg.sgname from books b \n" +
                     "    join genres g on g.booksid = b.id\n" +
                     "    join subgenres sg on sg.booksid = b.id \n" +
                     "    where b.id in (\n" +
                     "      select booksid from (\n" +
                     "        select count('a'), booksid from booksborrowed group by booksid order by 1 desc) where rownum <= 50\n" +
                     "    ) and b.id not in (\n" +
                     "      select distinct booksid from readbooks r where readersid = " + userid + " \n" +
                     "    )\n" +
                     "    order by b.rating desc\n" +
                     ")\n" +
                     "where rownum <= 50")) {
            while (rs.next()) {
                column = new String[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8)};

                bookTable.add(columnVector = new Vector<String>(Arrays.asList(column)));
            }
        }
        return bookTable;
    }

    public static Vector<Vector> selectTopBooksRatingCommon(String username, String option) throws SQLException {
        String[] column;
        Vector<Vector> bookTable = new Vector<>();
        Vector<String> columnVector;
        Connection con = DatabaseConnection.getConnection();
        int userid = 1;
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select id from readers where username = \'" + username + "\'")) {
            while (rs.next()) {
                userid = rs.getInt("ID");
            }
        }
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from (\n" +
                     "  select b.id, b.name, b.isbn, b.nrpages, b.price, b.rating, g.gname, sg.sgname from books b \n" +
                     "    join genres g on g.booksid = b.id\n" +
                     "    join subgenres sg on sg.booksid = b.id \n" +
                     "    where b.id not in (\n" +
                     "      select distinct booksid from readbooks r where r.readersid = " + userid + " \n" +
                     "    ) and ( g.gname in (\n" +
                     "      select distinct g.gname from genres g join readbooks rb on rb.booksid = g.BOOKSID \n" +
                     "        where rb.readersid = " + userid + " \n" +
                     "      ) " + option + " sg.sgname in (\n" +
                     "      select distinct sg.sgname from subgenres sg join readbooks rb on rb.booksid = sg.BOOKSID \n" +
                     "        where rb.readersid = " + userid + " \n" +
                     "      )\n" +
                     "    )\n" +
                     "    order by b.rating desc\n" +
                     ")\n" +
                     "where rownum <= 50")) {
            while (rs.next()) {
                column = new String[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8)};

                bookTable.add(columnVector = new Vector<String>(Arrays.asList(column)));
            }
        }
        return bookTable;
    }

    public static Vector<Vector> borrowedBooks(String readerUsername) throws SQLException {
        String[] column;
        int readerId = 0;
        Vector<Vector> booksBorrowed = new Vector<>();
        Vector<String> columnVector;
        Connection con = DatabaseConnection.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs2 = stmt.executeQuery("select id from readers where username = \'" + readerUsername + "\'")){

            while (rs2.next()) {
                readerId = rs2.getInt(1);
            }
        }
        try (Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select name, loandate, returndate, price from books b join booksborrowed bb on b.id = bb.booksid where bb.readerid = " + readerId + " and isreturned = 0")) {
            while (rs.next()) {
                //System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " +  rs.getString(4));
                column = new String[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
                booksBorrowed.add(columnVector = new Vector<String>(Arrays.asList(column)));
            }
        }
        return booksBorrowed;
    }

    public static int borrowBook(String userName, int bookId) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        CallableStatement cstmt = con.prepareCall("{? = call borrow_book(?, ?)}");
        cstmt.registerOutParameter(1, Types.INTEGER);
        cstmt.setString(2, userName);
        cstmt.setInt(3, bookId);
        cstmt.execute();
        return cstmt.getInt(1);
    }

    public static int returnBook(String userName, String bookName) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        int result = 0;
        try (CallableStatement cstmt = con.prepareCall("{? = call return_book(?, ?)}")) {

            cstmt.registerOutParameter(1, Types.INTEGER);


            cstmt.setString(2, userName);
            cstmt.setString(3, bookName);
            cstmt.execute();
            result = cstmt.getInt(1);
        }
        if (result == 1)
            return 1;
        return 0;
    }

    public static int getTotalFine(String userName) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        int totalFine = -1;
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select totalfine from readers where username = \'" + userName + "\'")) {
            while (rs.next()) {
                totalFine = rs.getInt("TOTALFINE");
            }
        }
        return totalFine;
    }

    public static String[] getBookAndAuthorName(int bookId) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        String[] bookAndAuthorName = null;
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select b.name, a.afname || ' ' || a.alname as \"AUTHOR\" from books b join authors a on b.authorid = a.id where b.id = " + bookId)) {
            while (rs.next())
            {
                bookAndAuthorName = new String[]{rs.getString("NAME"), rs.getString("AUTHOR")};
            }
        }
        return bookAndAuthorName;
    }

    public static Vector<Vector> reviewBooks(int bookId) throws SQLException {
        String[] column;
        Vector<Vector> booksReviews = new Vector<>();
        Vector<String> columnVector;
        Connection con = DatabaseConnection.getConnection();

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select r.username, rb.review, rb.rating from readbooks rb join readers r on r.id = rb.readersid where rb.booksid = " + bookId)) {
            while (rs.next()) {
                //System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " +  rs.getString(4));
                column = new String[]{rs.getString(1), rs.getString(2), rs.getString(3)};
                booksReviews.add(columnVector = new Vector<String>(Arrays.asList(column)));
            }
        }
        return booksReviews;
    }

    public static void exportTable(String tableName) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        try (CallableStatement cstmt = con.prepareCall("{call export_table(?)}")) {
            cstmt.setString(1, tableName);
            cstmt.execute();
        }
    }

    public static int getMaxIDAuthors() {
        int res = 75000;
        Connection con = DatabaseConnection.getConnection();
        try (Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select max(id) from authors")) {
            while (rs.next()) {
                res = rs.getInt(1);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }
}




