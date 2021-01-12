import DB.DatabaseConnection;
import DB.DatabaseController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ReadBookGUI {
    private JPanel readBookPanel;
    private JPanel northPanel;
    private JPanel middlePanel;
    private JPanel southPanel;
    private JLabel readBookLabel;
    private JTextField bookNameTextField;
    private JButton readButton;
    private JComboBox ratingComboBox;
    private JTextField reviewField;
    private JLabel ratingLabel;
    private JPanel ratingPanel;

    public ReadBookGUI() {
        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(DatabaseController.readBook(LoginGUI.getReaderUsername(), bookNameTextField.getText(), ratingComboBox.getSelectedIndex()+1, reviewField.getText())) {
                        JOptionPane.showMessageDialog(null, "Ai citit cartea!");
                        DatabaseConnection.commit();
                        InitGUI.getReadBookFrame().setVisible(false);
                        bookNameTextField.setText("Book Name");
                        reviewField.setText("Review");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Din pacate ai adormit in timp ce incercai sa o citesti..");
                        bookNameTextField.setText("Book Name");
                        reviewField.setText("Review");
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public JPanel getReadBookPanel() {
        return readBookPanel;
    }

    public void setReadBookPanel(JPanel readBookPanel) {
        this.readBookPanel = readBookPanel;
    }

    public JPanel getNorthPanel() {
        return northPanel;
    }

    public void setNorthPanel(JPanel northPanel) {
        this.northPanel = northPanel;
    }

    public JPanel getMiddlePanel() {
        return middlePanel;
    }

    public void setMiddlePanel(JPanel middlePanel) {
        this.middlePanel = middlePanel;
    }

    public JPanel getSouthPanel() {
        return southPanel;
    }

    public void setSouthPanel(JPanel southPanel) {
        this.southPanel = southPanel;
    }

    public JLabel getReadBookLabel() {
        return readBookLabel;
    }

    public void setReadBookLabel(JLabel readBookLabel) {
        this.readBookLabel = readBookLabel;
    }

    public JTextField getBookNameTextField() {
        return bookNameTextField;
    }

    public void setBookNameTextField(JTextField bookNameTextField) {
        this.bookNameTextField = bookNameTextField;
    }

    public JButton getReadButton() {
        return readButton;
    }

    public void setReadButton(JButton readButton) {
        this.readButton = readButton;
    }

    public JComboBox getRatingComboBox() {
        return ratingComboBox;
    }

    public void setRatingComboBox(JComboBox ratingComboBox) {
        this.ratingComboBox = ratingComboBox;
    }

    public JTextField getReviewField() {
        return reviewField;
    }

    public void setReviewField(JTextField reviewField) {
        this.reviewField = reviewField;
    }

    public JLabel getRatingLabel() {
        return ratingLabel;
    }

    public void setRatingLabel(JLabel ratingLabel) {
        this.ratingLabel = ratingLabel;
    }

    public JPanel getRatingPanel() {
        return ratingPanel;
    }

    public void setRatingPanel(JPanel ratingPanel) {
        this.ratingPanel = ratingPanel;
    }
}
