import DB.DatabaseConnection;
import DB.DatabaseController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class InsertAuthorGUI {
    private JButton insertButton;
    private JPanel insertAuthorPanel;
    private JPanel northPanel;
    private JLabel insertAuthorLabel;
    private JPanel southPanel;
    private JPanel middlePanel;
    private JTextField fNameField;
    private JTextField lNameField;

    public InsertAuthorGUI() {
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(DatabaseController.insertAuthor(fNameField.getText(), lNameField.getText()))
                    {
                        JOptionPane.showMessageDialog(null, "Autorul a fost adaugat cu succes");
                        DatabaseConnection.commit();
                        InitGUI.getInsertAuthorframe().setVisible(false);
                        fNameField.setText("First Name");
                        lNameField.setText("Last Name");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Autorul exista deja in baza de date");
                        InitGUI.getInsertAuthorframe().setVisible(false);
                        fNameField.setText("First Name");
                        lNameField.setText("Last Name");
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public JButton getInsertButton() {
        return insertButton;
    }

    public void setInsertButton(JButton insertButton) {
        this.insertButton = insertButton;
    }

    public JPanel getInsertAuthorPanel() {
        return insertAuthorPanel;
    }

    public void setInsertAuthorPanel(JPanel insertAuthorPanel) {
        this.insertAuthorPanel = insertAuthorPanel;
    }

    public JPanel getNorthPanel() {
        return northPanel;
    }

    public void setNorthPanel(JPanel northPanel) {
        this.northPanel = northPanel;
    }

    public JLabel getInsertAuthorLabel() {
        return insertAuthorLabel;
    }

    public void setInsertAuthorLabel(JLabel insertAuthorLabel) {
        this.insertAuthorLabel = insertAuthorLabel;
    }

    public JPanel getSouthPanel() {
        return southPanel;
    }

    public void setSouthPanel(JPanel southPanel) {
        this.southPanel = southPanel;
    }

    public JPanel getMiddlePanel() {
        return middlePanel;
    }

    public void setMiddlePanel(JPanel middlePanel) {
        this.middlePanel = middlePanel;
    }

    public JTextField getfNameField() {
        return fNameField;
    }

    public void setfNameField(JTextField fNameField) {
        this.fNameField = fNameField;
    }

    public JTextField getlNameField() {
        return lNameField;
    }

    public void setlNameField(JTextField lNameField) {
        this.lNameField = lNameField;
    }
}
