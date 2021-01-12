import DB.DatabaseController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginGUI extends JFrame{
    private JPanel login;
    private JLabel loginLabel;
    private JPanel northPanel;
    private JTextField usernameTextField;
    private JPanel eastPanel;
    private JPanel southPanel;
    private JButton loginButton;
    private JButton signUpButton;
    private JPasswordField passwordField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel signUpLabel;
    private JRadioButton secureRadioButton;

    private static String readerUsername;
    private static int totalFine;

    public LoginGUI()
    {
        this.setLayout(new GridLayout(3, 3));
        this.setSize(800, 800);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (usernameTextField.getText().toLowerCase().compareTo("admin") == 0 && passwordField.getText().compareTo("admin") == 0) {
                        InitGUI.getAdminFrame().setVisible(true);
                        InitGUI.getLoginFrame().setVisible(false);
                    }
                    else {
                        if (secureRadioButton.isSelected()) {
                            if (DatabaseController.loginUserSafe(usernameTextField.getText(), passwordField.getText())) {
                                InitGUI.getAppFrame().setVisible(true);
                                InitGUI.getLoginFrame().setVisible(false);
                                setReaderUsername(usernameTextField.getText());
                            } else {
                                JOptionPane.showMessageDialog(null, "Numele sau parola nu sunt corecte", "Login failed", JOptionPane.PLAIN_MESSAGE);
                            }
                        }
                        else {
                            if (DatabaseController.loginUserUnSafe(usernameTextField.getText(), passwordField.getText())) {
                                InitGUI.getAppFrame().setVisible(true);
                                InitGUI.getLoginFrame().setVisible(false);
                                setReaderUsername(usernameTextField.getText());
                                setTotalFine(DatabaseController.getTotalFine(readerUsername));
                            } else {
                                JOptionPane.showMessageDialog(null, "Numele sau parola nu sunt corecte", "Login failed", JOptionPane.PLAIN_MESSAGE);
                            }
                        }
                    }
                }
                catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, "Acesta este butonul de sign up", "Register", JOptionPane.PLAIN_MESSAGE);
                InitGUI.getRegisterFrame().setVisible(true);
                InitGUI.getLoginFrame().setVisible(false);
            }
        });
    }

    public JPanel getLogin() {
        return login;
    }

    public void setLogin(JPanel login) {
        this.login = login;
    }

    public JLabel getLoginLabel() {
        return loginLabel;
    }

    public void setLoginLabel(JLabel loginLabel) {
        this.loginLabel = loginLabel;
    }

    public JPanel getNorthPanel() {
        return northPanel;
    }

    public void setNorthPanel(JPanel northPanel) {
        this.northPanel = northPanel;
    }

    public JTextField getUsernameTextField() {
        return usernameTextField;
    }

    public void setUsernameTextField(JTextField usernameTextField) {
        this.usernameTextField = usernameTextField;
    }

    public JPanel getEastPanel() {
        return eastPanel;
    }

    public void setEastPanel(JPanel eastPanel) {
        this.eastPanel = eastPanel;
    }

    public JPanel getSouthPanel() {
        return southPanel;
    }

    public void setSouthPanel(JPanel southPanel) {
        this.southPanel = southPanel;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

    public JButton getSignUpButton() {
        return signUpButton;
    }

    public void setSignUpButton(JButton signUpButton) {
        this.signUpButton = signUpButton;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordTextField) {
        this.passwordField = passwordTextField;
    }

    public JLabel getUsernameLabel() {
        return usernameLabel;
    }

    public void setUsernameLabel(JLabel usernameLabel) {
        this.usernameLabel = usernameLabel;
    }

    public JLabel getPasswordLabel() {
        return passwordLabel;
    }

    public void setPasswordLabel(JLabel passwordLabel) {
        this.passwordLabel = passwordLabel;
    }

    public JLabel getSignUpLabel() {
        return signUpLabel;
    }

    public void setSignUpLabel(JLabel signUpLabel) {
        this.signUpLabel = signUpLabel;
    }

    public static String getReaderUsername() {
        return readerUsername;
    }

    public static void setReaderUsername(String readerUsername2) {
        readerUsername = readerUsername2;
    }

    public static void setTotalFine(int totalFine) {
        LoginGUI.totalFine = totalFine;
    }

    public static int getTotalFine() {
        return totalFine;
    }
}

