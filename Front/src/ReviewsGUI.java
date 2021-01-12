import DB.DatabaseController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.SQLException;
import java.util.Vector;

public class ReviewsGUI {
    private JPanel reviewsPanel;
    private JScrollPane reviewsTableScrollPane;
    private JTable reviewsTable;
    private JButton backButton;
    private JPanel southPanel;
    private JPanel bookNamePanel;
    private JPanel authorNamePanel;
    private JLabel authorNameLabel;
    private JLabel bookNameLabel;
    private DefaultTableModel model = (DefaultTableModel)reviewsTable.getModel();

    public ReviewsGUI() throws SQLException {
        String[] bookAuthorNames = DatabaseController.getBookAndAuthorName(AppGUI.getBookReviewId());
        bookNameLabel.setText(bookAuthorNames[0]);
        authorNameLabel.setText(bookAuthorNames[1]);
        model.addColumn("User");
        model.addColumn("Review");
        model.addColumn("Rating");
        model.setRowCount(0);
        Vector<Vector> rows;
        rows = DatabaseController.reviewBooks(AppGUI.getBookReviewId());
            for(Vector i : rows) {
                model.addRow(i);
            }
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InitGUI.getReviewsFrame().setVisible(false);
            }
        });

    }

    public JPanel getReviewsPanel() {
        return reviewsPanel;
    }

    public void setReviewsPanel(JPanel reviewsPanel) {
        this.reviewsPanel = reviewsPanel;
    }

    public JScrollPane getReviewsTableScrollPane() {
        return reviewsTableScrollPane;
    }

    public void setReviewsTableScrollPane(JScrollPane reviewsTableScrollPane) {
        this.reviewsTableScrollPane = reviewsTableScrollPane;
    }

    public JTable getReviewsTable() {
        return reviewsTable;
    }

    public void setReviewsTable(JTable reviewsTable) {
        this.reviewsTable = reviewsTable;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public JPanel getSouthPanel() {
        return southPanel;
    }

    public void setSouthPanel(JPanel southPanel) {
        this.southPanel = southPanel;
    }

    public JPanel getBookNamePanel() {
        return bookNamePanel;
    }

    public void setBookNamePanel(JPanel bookNamePanel) {
        this.bookNamePanel = bookNamePanel;
    }

    public JPanel getAuthorNamePanel() {
        return authorNamePanel;
    }

    public void setAuthorNamePanel(JPanel authorNamePanel) {
        this.authorNamePanel = authorNamePanel;
    }

    public JLabel getAuthorNameLabel() {
        return authorNameLabel;
    }

    public void setAuthorNameLabel(JLabel authorNameLabel) {
        this.authorNameLabel = authorNameLabel;
    }

    public JLabel getBookNameLabel() {
        return bookNameLabel;
    }

    public void setBookNameLabel(JLabel bookNameLabel) {
        this.bookNameLabel = bookNameLabel;
    }
}
