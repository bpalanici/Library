import DB.DatabaseConnection;
import DB.DatabaseController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

public class BorrowedBooks {
    private JPanel BorrowedBooks;
    private JPanel showPanel;
    private JPanel southPanel;
    private JScrollPane tableScrollPane;
    private JTable borrowedBooksTable;
    private JButton returnBookButton;
    private JButton backButton;
    private JButton showBooksButton;
    private JButton readBookButton;
    private DefaultTableModel booksBorrowedModel = (DefaultTableModel)borrowedBooksTable.getModel();

    public BorrowedBooks() {

        booksBorrowedModel.addColumn("Name");
        booksBorrowedModel.addColumn("LoanDate");
        booksBorrowedModel.addColumn("ReturnDate");
        booksBorrowedModel.addColumn("Price");

        showBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                booksBorrowedModel.setRowCount(0);
                Vector<Vector> rows = new Vector<>();
                try {
                    rows = DatabaseController.borrowedBooks(LoginGUI.getReaderUsername());
                    for(Vector i : rows)
                        booksBorrowedModel.addRow(i);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        readBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InitGUI.getReadBookFrame().setVisible(true);
            }
        });
        returnBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (borrowedBooksTable.getSelectedRow() != -1) {
                    try {
                        String bookName = (String) booksBorrowedModel.getValueAt(borrowedBooksTable.getSelectedRow(), 0);
                        if (DatabaseController.returnBook(LoginGUI.getReaderUsername(), bookName) == 1) {
                            JOptionPane.showMessageDialog(null, "Cartea a fost returnata cu succes");
                            DatabaseConnection.commit();
                        } else {
                            JOptionPane.showMessageDialog(null, "Cartea nu a fost returnata cu succes");
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, "Pentru a putea returna, t" +
                            "rebuie sa selectezi o carte!", "Warning!", JOptionPane.PLAIN_MESSAGE);


            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InitGUI.getBorrowedBooksFrame().setVisible(false);
            }
        });
    }

    public JPanel getBorrowedBooks() {
        return BorrowedBooks;
    }

    public void setBorrowedBooks(JPanel borrowedBooks) {
        BorrowedBooks = borrowedBooks;
    }

    public JPanel getShowPanel() {
        return showPanel;
    }

    public void setShowPanel(JPanel showPanel) {
        this.showPanel = showPanel;
    }

    public JPanel getSouthPanel() {
        return southPanel;
    }

    public void setSouthPanel(JPanel southPanel) {
        this.southPanel = southPanel;
    }

    public JScrollPane getTableScrollPane() {
        return tableScrollPane;
    }

    public void setTableScrollPane(JScrollPane tableScrollPane) {
        this.tableScrollPane = tableScrollPane;
    }

    public JTable getBorrowedBooksTable() {
        return borrowedBooksTable;
    }

    public void setBorrowedBooksTable(JTable borrowedBooksTable) {
        this.borrowedBooksTable = borrowedBooksTable;
    }

    public JButton getReturnBookButton() {
        return returnBookButton;
    }

    public void setReturnBookButton(JButton returnBookButton) {
        this.returnBookButton = returnBookButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public JButton getShowBooksButton() {
        return showBooksButton;
    }

    public void setShowBooksButton(JButton showBooksButton) {
        this.showBooksButton = showBooksButton;
    }

    public JButton getReadBookButton() {
        return readBookButton;
    }

    public void setReadBookButton(JButton readBookButton) {
        this.readBookButton = readBookButton;
    }
}
