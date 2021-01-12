import javax.swing.*;
import java.awt.*;

public class InitGUI {
    private final static JFrame loginFrame = new JFrame("Login");
    private final static JFrame registerFrame = new JFrame("Register");
    private final static JFrame appFrame = new JFrame("AppGUI");
    private final static JFrame adminFrame = new JFrame("AdminGUI");
    private final static JFrame readBookFrame = new JFrame("ReadBookGUI");
    private final static JFrame borrowBookFrame = new JFrame("borrowBookGUI");
    private final static JFrame insertAuthorframe = new JFrame("InsertAuthorGUI");
    private final static JFrame insertBookFrame = new JFrame("InsertBookGUI");
    private final static JFrame insertGenreFrame = new JFrame("InsertGenreToBookGUI");
    private final static JFrame insertSubgenreFrame = new JFrame("InsertSubgenreToBookGUI");
    private final static JFrame borrowedBooksFrame = new JFrame("BorrowedBooks");
    private final static JFrame reviewsFrame = new JFrame("ReviewsGUI");
    private final static JFrame recommendationsFrame = new JFrame("RecommendationsGUI");
    private final static JFrame exportFrame = new JFrame("ExportGUI");
public void init()
{
    loginFrame.setContentPane(new LoginGUI().getLogin());
    //loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    loginFrame.pack();
    loginFrame.setLocationRelativeTo(null);
    loginFrame.setVisible(true);

    registerFrame.setLocationRelativeTo(null);
    registerFrame.setContentPane(new RegisterGUI().getRegister());
    //registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    registerFrame.pack();
    registerFrame.setLocationRelativeTo(null);

    appFrame.setContentPane(new AppGUI().getAppPanel());
    appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    appFrame.pack();
    appFrame.setLocationRelativeTo(null);

    adminFrame.setContentPane(new AdminGUI().getAdminPanel());
    adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    adminFrame.pack();
    adminFrame.setLocationRelativeTo(null);

    readBookFrame.setContentPane(new ReadBookGUI().getReadBookPanel());
    //readBookFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    readBookFrame.pack();
    readBookFrame.setLocationRelativeTo(null);

    borrowBookFrame.setContentPane(new borrowBookGUI().getBorrowBookPanel());
    //borrowBookFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    borrowBookFrame.pack();
    borrowBookFrame.setLocationRelativeTo(null);

    insertAuthorframe.setContentPane(new InsertAuthorGUI().getInsertAuthorPanel());
    //insertAuthorframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    insertAuthorframe.pack();
    insertAuthorframe.setLocationRelativeTo(null);

    insertBookFrame.setContentPane(new InsertBookGUI().getInsertABookPanel());
    //insertBookFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    insertBookFrame.pack();
    insertBookFrame.setLocationRelativeTo(null);

    insertGenreFrame.setContentPane(new InsertGenreToBookGUI().getInsertGenrePanel());
    //insertGenreFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    insertGenreFrame.pack();
    insertGenreFrame.setLocationRelativeTo(null);

    insertSubgenreFrame.setContentPane(new InsertSubgenreToBookGUI().getInsertSubgenrePanel());
    //insertSubgenreFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    insertSubgenreFrame.pack();
    insertSubgenreFrame.setLocationRelativeTo(null);

    borrowedBooksFrame.setContentPane(new BorrowedBooks().getBorrowedBooks());
    borrowedBooksFrame.pack();
    borrowedBooksFrame.setLocationRelativeTo(null);

    recommendationsFrame.setContentPane(new RecommendationsGUI().getRecPanel());
    recommendationsFrame.pack();
    recommendationsFrame.setLocationRelativeTo(null);


    exportFrame.setContentPane(new ExportGUI().getExportPanel());
    exportFrame.pack();
    exportFrame.setLocationRelativeTo(null);
}

    public static JFrame getLoginFrame() {
        return loginFrame;
    }

    public static JFrame getRegisterFrame() {
        return registerFrame;
    }

    public static JFrame getAppFrame() {
        return appFrame;
    }

    public static JFrame getAdminFrame() {
        return adminFrame;
    }

    public static JFrame getReadBookFrame() {
        return readBookFrame;
    }

    public static JFrame getBorrowBookFrame() {
        return borrowBookFrame;
    }

    public static JFrame getInsertAuthorframe() {
        return insertAuthorframe;
    }

    public static JFrame getInsertBookFrame() {
        return insertBookFrame;
    }

    public static JFrame getInsertGenreFrame() {
        return insertGenreFrame;
    }

    public static JFrame getInsertSubgenreFrame() {
        return insertSubgenreFrame;
    }

    public static JFrame getBorrowedBooksFrame() {
        return borrowedBooksFrame;
    }

    public static JFrame getReviewsFrame() {
        return reviewsFrame;
    }

    public static JFrame getRecommendationsFrame() {
        return recommendationsFrame;
    }

    public static JFrame getExportFrame() {
        return exportFrame;
    }
}
