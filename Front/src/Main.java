import DB.DatabaseConnection;
import DB.DatabaseController;

import javax.swing.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        InitGUI init = new InitGUI();
        init.init();
        //DatabaseController.test();
    }
}