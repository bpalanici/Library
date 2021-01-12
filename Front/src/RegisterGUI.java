import DB.DatabaseConnection;
import DB.DatabaseController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RegisterGUI {
    private JPanel register;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPanel northJPanel;
    private JPanel middleJPanel;
    private JPanel spinnerPanel;
    private JButton registerButton;
    private JPanel southPanel;
    private JComboBox yearComboBox;
    private JComboBox monthComboBox;
    private JComboBox dayComboBox;
    private JLabel birthdateLabel;
    private JButton backToLoginButton;

    public RegisterGUI() {
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(DatabaseController.registerUser(firstNameField.getText(), lastNameField.getText(), usernameField.getText(), passwordField.getText(), yearComboBox.getSelectedIndex()+1980, monthComboBox.getSelectedIndex()+1, dayComboBox.getSelectedIndex()+1)
                        && usernameField.getText().toLowerCase().compareTo("admin")!=0 && passwordField.getText().toLowerCase().compareTo("admin")!=0) {
                        JOptionPane.showMessageDialog(null, "Te-ai inregistrat cu succes! Vei fi redirectat la fereastra de logare.");
                        InitGUI.getRegisterFrame().setVisible(false);
                        InitGUI.getLoginFrame().setVisible(true);
                        firstNameField.setText("Firstname");
                        lastNameField.setText("Lastname");
                        usernameField.setText("Username");
                        passwordField.setText("Password");
                        DatabaseConnection.commit();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Inregistrarea nu s-a efectuat cu succes");
                        firstNameField.setText("Firstname");
                        lastNameField.setText("Lastname");
                        usernameField.setText("Username");
                        passwordField.setText("Password");
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }
        });
        backToLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InitGUI.getRegisterFrame().setVisible(false);
                InitGUI.getLoginFrame().setVisible(true);
            }
        });
    }


    public JPanel getRegister() {
        return register;
    }

    public void setRegister(JPanel register) {
        this.register = register;
    }

    public JTextField getFirstNameField() {
        return firstNameField;
    }

    public void setFirstNameField(JTextField firstNameField) {
        this.firstNameField = firstNameField;
    }

    public JTextField getLastNameField() {
        return lastNameField;
    }

    public void setLastNameField(JTextField lastNameField) {
        this.lastNameField = lastNameField;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public void setUsernameField(JTextField usernameField) {
        this.usernameField = usernameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public JPanel getNorthJPanel() {
        return northJPanel;
    }

    public void setNorthJPanel(JPanel northJPanel) {
        this.northJPanel = northJPanel;
    }

    public JPanel getMiddleJPanel() {
        return middleJPanel;
    }

    public void setMiddleJPanel(JPanel middleJPanel) {
        this.middleJPanel = middleJPanel;
    }

    public JPanel getSpinnerPanel() {
        return spinnerPanel;
    }

    public void setSpinnerPanel(JPanel spinnerPanel) {
        this.spinnerPanel = spinnerPanel;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    public void setRegisterButton(JButton registerButton) {
        this.registerButton = registerButton;
    }

    public JPanel getSouthPanel() {
        return southPanel;
    }

    public void setSouthPanel(JPanel southPanel) {
        this.southPanel = southPanel;
    }

    public JComboBox getYearComboBox() {
        return yearComboBox;
    }

    public void setYearComboBox(JComboBox yearComboBox) {
        this.yearComboBox = yearComboBox;
    }

    public JComboBox getMonthComboBox() {
        return monthComboBox;
    }

    public void setMonthComboBox(JComboBox monthComboBox) {
        this.monthComboBox = monthComboBox;
    }

    public JComboBox getDayComboBox() {
        return dayComboBox;
    }

    public void setDayComboBox(JComboBox dayComboBox) {
        this.dayComboBox = dayComboBox;
    }

    public JLabel getBirthdateLabel() {
        return birthdateLabel;
    }

    public void setBirthdateLabel(JLabel birthdateLabel) {
        this.birthdateLabel = birthdateLabel;
    }
}
