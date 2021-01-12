import javax.swing.*;

public class borrowBookGUI {
    private JPanel northPanel;
    private JPanel middlePanel;
    private JPanel southPanel;
    private JPanel borrowBookPanel;
    private JTextField bookNameField;
    private JButton insertButton;

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

    public JPanel getBorrowBookPanel() {
        return borrowBookPanel;
    }

    public void setBorrowBookPanel(JPanel borrowBookPanel) {
        this.borrowBookPanel = borrowBookPanel;
    }

    public JTextField getBookNameField() {
        return bookNameField;
    }

    public void setBookNameField(JTextField bookNameField) {
        this.bookNameField = bookNameField;
    }

    public JButton getInsertButton() {
        return insertButton;
    }

    public void setInsertButton(JButton insertButton) {
        this.insertButton = insertButton;
    }
}
