import DB.DatabaseConnection;
import DB.DatabaseController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class InsertGenreToBookGUI {
    private JPanel insertGenrePanel;
    private JTextField insertBookNameField;
    private JTextField genreTextField;
    private JButton insertButton;
    private JPanel northPanel;
    private JPanel insertPanel;
    private JPanel southPanel;
    private JLabel titleLabel;

    public InsertGenreToBookGUI() {
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int result = DatabaseController.updateGenre(insertBookNameField.getText(), genreTextField.getText());
                    if(result == 1)
                    {
                        JOptionPane.showMessageDialog(null, "Genul a fost adaugat cu succes");
                        DatabaseConnection.commit();
                        InitGUI.getInsertGenreFrame().setVisible(false);
                        insertBookNameField.setText("Bookname");
                        genreTextField.setText("Genre");
                    }
                    else
                        if (result == 0) {
                            JOptionPane.showMessageDialog(null, "Cartea nu are gen inregistrat(imposibil...)");
                            InitGUI.getInsertGenreFrame().setVisible(false);
                            insertBookNameField.setText("Bookname");
                            genreTextField.setText("Genre");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Cartea " + insertBookNameField.getText() + " nu exista in baza de date!");
                            InitGUI.getInsertGenreFrame().setVisible(false);
                            insertBookNameField.setText("Bookname");
                            genreTextField.setText("Genre");
                        }

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public JPanel getInsertGenrePanel() {
        return insertGenrePanel;
    }

    public void setInsertGenrePanel(JPanel insertGenrePanel) {
        this.insertGenrePanel = insertGenrePanel;
    }

    public JTextField getInsertBookNameField() {
        return insertBookNameField;
    }

    public void setInsertBookNameField(JTextField insertBookNameField) {
        this.insertBookNameField = insertBookNameField;
    }

    public JTextField getGenreTextField() {
        return genreTextField;
    }

    public void setGenreTextField(JTextField genreTextField) {
        this.genreTextField = genreTextField;
    }

    public JButton getInsertButton() {
        return insertButton;
    }

    public void setInsertButton(JButton insertButton) {
        this.insertButton = insertButton;
    }

    public JPanel getNorthPanel() {
        return northPanel;
    }

    public void setNorthPanel(JPanel northPanel) {
        this.northPanel = northPanel;
    }

    public JPanel getInsertPanel() {
        return insertPanel;
    }

    public void setInsertPanel(JPanel insertPanel) {
        this.insertPanel = insertPanel;
    }

    public JPanel getSouthPanel() {
        return southPanel;
    }

    public void setSouthPanel(JPanel southPanel) {
        this.southPanel = southPanel;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public void setTitleLabel(JLabel titleLabel) {
        this.titleLabel = titleLabel;
    }
}
