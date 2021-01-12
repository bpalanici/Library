package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
        /**
         * The URL of the DataBase
         */
        private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

        /**
         * The USER of the DataBase
         */
        private static final String USER = "localuser";

        /**
         * The PASSWORD of the DataBase
         */
        private static final String PASSWORD = "LOCALUSER";

        /**
         * The connection of the DataBase that needs to be established
         * Initialised with null
         */
        private static Connection connection = null;

        /**
         * An empty constructor
         */
        private DatabaseConnection() { }

        /**
         * This method gets the connection of the DataBase
         * If it's not connected yet, then it's called the createConnection() method
         * @return the connection of the DataBase
         */
        public static Connection getConnection() {
            if (connection == null) {
                createConnection();
            }
            return connection;
        }

        /**
         * This method creates a connection for the DataBase using the URL, USER and the PASSWORD,
         * Using a JDBC driver
         */
        private static void createConnection() {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                connection.setAutoCommit(false);
            } catch(ClassNotFoundException e) {
                System.err.print("ClassNotFoundException: " + e) ;
            } catch(SQLException e) {
                System.err.println("SQLException: " + e);
            }

        }

        /**
         * This method transfers data to the DataBase
         */
        public static void commit() {
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        /**
         * This method closes the connection of the DataBase
         */
        public static void closeConnection() {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        /**
         * This method brings the DataBase to a previous state
         */
        public static void rollback() {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

