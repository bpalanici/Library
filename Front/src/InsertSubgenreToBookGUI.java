import DB.DatabaseConnection;
import DB.DatabaseController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class InsertSubgenreToBookGUI {
    private JPanel northPanel;
    private JLabel titleLabel;
    private JPanel insertPanel;
    private JTextField insertBookNameField;
    private JTextField subgenreTextField;
    private JPanel southPanel;
    private JButton insertButton;
    private JPanel insertSubgenrePanel;

    public InsertSubgenreToBookGUI() {
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int result = DatabaseController.updateSubgenre(insertBookNameField.getText(), subgenreTextField.getText());
                    if(result == 1)
                    {
                        JOptionPane.showMessageDialog(null, "Subgenul a fost adaugat cu succes");
                        DatabaseConnection.commit();
                        InitGUI.getInsertSubgenreFrame().setVisible(false);
                        insertBookNameField.setText("Bookname");
                        subgenreTextField.setText("Subgenre");
                    }
                    else
                        if(result == 0)
                        {
                            JOptionPane.showMessageDialog(null, "Cartea nu are subgen(imposibil...)");
                            InitGUI.getInsertSubgenreFrame().setVisible(false);
                            insertBookNameField.setText("Bookname");
                            subgenreTextField.setText("Subgenre");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Cartea " + insertBookNameField.getText() + " nu exista in baza de date!");
                            InitGUI.getInsertSubgenreFrame().setVisible(false);
                            insertBookNameField.setText("Bookname");
                            subgenreTextField.setText("Subgenre");
                        }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public JPanel getNorthPanel() {
            return northPanel;
        }

        public void setNorthPanel(JPanel northPanel) {
            this.northPanel = northPanel;
        }

        public JLabel getTitleLabel() {
            return titleLabel;
        }

        public void setTitleLabel(JLabel titleLabel) {
            this.titleLabel = titleLabel;
        }

        public JPanel getInsertPanel() {
            return insertPanel;
        }

        public void setInsertPanel(JPanel insertPanel) {
            this.insertPanel = insertPanel;
        }

        public JTextField getInsertBookNameField() {
            return insertBookNameField;
        }

        public void setInsertBookNameField(JTextField insertBookNameField) {
            this.insertBookNameField = insertBookNameField;
        }

        public JTextField getSubgenreTextField() {
            return subgenreTextField;
        }

        public void setSubgenreTextField(JTextField subgenreTextField) {
            this.subgenreTextField = subgenreTextField;
        }

        public JPanel getSouthPanel() {
            return southPanel;
        }

        public void setSouthPanel(JPanel southPanel) {
            this.southPanel = southPanel;
        }

        public JButton getInsertButton() {
            return insertButton;
        }

        public void setInsertButton(JButton insertButton) {
            this.insertButton = insertButton;
        }

        public JPanel getInsertSubgenrePanel() {
            return insertSubgenrePanel;
        }

        public void setInsertSubgenrePanel(JPanel insertSubgenrePanel) {
            this.insertSubgenrePanel = insertSubgenrePanel;
        }
    }
