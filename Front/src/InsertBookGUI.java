import DB.DatabaseConnection;
import DB.DatabaseController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class InsertBookGUI {
    private JPanel insertABookPanel;
    private JPanel insertPanel;
    private JPanel southPanel;
    private JPanel northPanel;
    private JButton insertButton;
    private JSpinner nrPagesSpinner;
    private JSpinner priceSpinner;
    private JSpinner authorIdSpinner;
    private JLabel authorIdLabel;
    private JLabel nrPagesLabel;
    private JLabel priceLabel;
    private JTextField insertISBNField;
    private JTextField insertBookNameField;
    private JPanel spinnerPanel;

    public InsertBookGUI() {
        int nrAuthors = DatabaseController.getMaxIDAuthors();
        authorIdSpinner.setModel(new SpinnerNumberModel(1, 1, nrAuthors, 1));
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(DatabaseController.insertBook(insertBookNameField.getText(), (Integer) authorIdSpinner.getValue(), insertISBNField.getText(), (Integer) nrPagesSpinner.getValue(), (Integer) priceSpinner.getValue()))
                    {
                        JOptionPane.showMessageDialog(null, "Cartea a fost inserata cu succes");
                        InitGUI.getInsertBookFrame().setVisible(false);
                        DatabaseConnection.commit();
                        insertBookNameField.setText("Bookname");
                        insertISBNField.setText("ISBN");
                        authorIdSpinner.setValue(0);
                        priceSpinner.setValue(0);
                        nrPagesSpinner.setValue(0);

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Cartea nu a fost inserata cu succes");
                        InitGUI.getInsertBookFrame().setVisible(false);
                        insertBookNameField.setText("Bookname");
                        insertISBNField.setText("ISBN");
                        authorIdSpinner.setValue(0);
                        priceSpinner.setValue(0);
                        nrPagesSpinner.setValue(0);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public JPanel getInsertABookPanel() {
        return insertABookPanel;
    }

    public void setInsertABookPanel(JPanel insertABookPanel) {
        this.insertABookPanel = insertABookPanel;
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

    public JPanel getNorthPanel() {
        return northPanel;
    }

    public void setNorthPanel(JPanel northPanel) {
        this.northPanel = northPanel;
    }

    public JButton getInsertButton() {
        return insertButton;
    }

    public void setInsertButton(JButton insertButton) {
        this.insertButton = insertButton;
    }

    public JSpinner getNrPagesSpinner() {
        return nrPagesSpinner;
    }

    public void setNrPagesSpinner(JSpinner nrPagesSpinner) {
        this.nrPagesSpinner = nrPagesSpinner;
    }

    public JSpinner getPriceSpinner() {
        return priceSpinner;
    }

    public void setPriceSpinner(JSpinner priceSpinner) {
        this.priceSpinner = priceSpinner;
    }

    public JSpinner getAuthorIdSpinner() {
        return authorIdSpinner;
    }

    public void setAuthorIdSpinner(JSpinner authorIdSpinner) {
        this.authorIdSpinner = authorIdSpinner;
    }

    public JLabel getAuthorIdLabel() {
        return authorIdLabel;
    }

    public void setAuthorIdLabel(JLabel authorIdLabel) {
        this.authorIdLabel = authorIdLabel;
    }

    public JLabel getNrPagesLabel() {
        return nrPagesLabel;
    }

    public void setNrPagesLabel(JLabel nrPagesLabel) {
        this.nrPagesLabel = nrPagesLabel;
    }

    public JLabel getPriceLabel() {
        return priceLabel;
    }

    public void setPriceLabel(JLabel priceLabel) {
        this.priceLabel = priceLabel;
    }

    public JTextField getInsertISBNField() {
        return insertISBNField;
    }

    public void setInsertISBNField(JTextField insertISBNField) {
        this.insertISBNField = insertISBNField;
    }

    public JTextField getInsertBookNameField() {
        return insertBookNameField;
    }

    public void setInsertBookNameField(JTextField insertBookNameField) {
        this.insertBookNameField = insertBookNameField;
    }

    public JPanel getSpinnerPanel() {
        return spinnerPanel;
    }

    public void setSpinnerPanel(JPanel spinnerPanel) {
        this.spinnerPanel = spinnerPanel;
    }
}
