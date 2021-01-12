import DB.DatabaseController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

public class RecommendationsGUI {
    private JPanel recPanel;
    private JTable topBooksTable;
    private JButton topAfterRatingButton;
    private JButton topAfterBorrowsButton;
    private JButton topRiddenGenresButton;
    private JButton topRiddenGandSGButton;
    private JScrollPane topTableScrollPane;
    private JPanel southPanel;
    private JButton exitButton;
    private JPanel titlePanel;
    private JLabel titleLabel;
    private DefaultTableModel model = (DefaultTableModel)topBooksTable.getModel();

    public RecommendationsGUI() {
        topRiddenGandSGButton.setVisible(false);
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("ISBN");
        model.addColumn("NrPages");
        model.addColumn("Price");
        model.addColumn("Rating");
        model.addColumn("Genre");
        model.addColumn("SubGenre");

        topAfterRatingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    model.setRowCount(0);
                    Vector<Vector> rows;
                    rows = DatabaseController.selectTopBooksRating(LoginGUI.getReaderUsername());
                    for(Vector i : rows) {
                        model.addRow(i);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Top 50 carti dupa rating");
            }
        });
        topRiddenGenresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    model.setRowCount(0);
                    Vector<Vector> rows;
                    rows = DatabaseController.selectTopBooksRatingCommon(LoginGUI.getReaderUsername(), "or");
                    for(Vector i : rows) {
                        model.addRow(i);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Top 50 carti din genuri sau subgenuri citite");
            }
        });
        topRiddenGandSGButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    model.setRowCount(0);
                    Vector<Vector> rows;
                    rows = DatabaseController.selectTopBooksRatingCommon(LoginGUI.getReaderUsername(), "and");
                    for(Vector i : rows) {
                        model.addRow(i);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Top 50 carti dupa genuri si subgenuri citite");
            }
        });
        topAfterBorrowsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    model.setRowCount(0);
                    Vector<Vector> rows;
                    rows = DatabaseController.selectTopBooksNrBorrows(LoginGUI.getReaderUsername());
                    for(Vector i : rows) {
                        model.addRow(i);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Top 50 carti care au fost cele mai imprumutate");
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InitGUI.getRecommendationsFrame().setVisible(false);
            }
        });
    }

    public JPanel getRecPanel() {
        return recPanel;
    }

    public void setRecPanel(JPanel recPanel) {
        this.recPanel = recPanel;
    }

    public JTable getTopBooksTable() {
        return topBooksTable;
    }

    public void setTopBooksTable(JTable topBooksTable) {
        this.topBooksTable = topBooksTable;
    }

    public JButton getTopAfterRatingButton() {
        return topAfterRatingButton;
    }

    public void setTopAfterRatingButton(JButton topAfterRatingButton) {
        this.topAfterRatingButton = topAfterRatingButton;
    }

    public JButton getTopAfterBorrowsButton() {
        return topAfterBorrowsButton;
    }

    public void setTopAfterBorrowsButton(JButton topAfterBorrowsButton) {
        this.topAfterBorrowsButton = topAfterBorrowsButton;
    }

    public JButton getTopRiddenGenresButton() {
        return topRiddenGenresButton;
    }

    public void setTopRiddenGenresButton(JButton topRiddenGenresButton) {
        this.topRiddenGenresButton = topRiddenGenresButton;
    }

    public JButton getTopRiddenGandSGButton() {
        return topRiddenGandSGButton;
    }

    public void setTopRiddenGandSGButton(JButton topRiddenGandSGButton) {
        this.topRiddenGandSGButton = topRiddenGandSGButton;
    }

    public JScrollPane getTopTableScrollPane() {
        return topTableScrollPane;
    }

    public void setTopTableScrollPane(JScrollPane topTableScrollPane) {
        this.topTableScrollPane = topTableScrollPane;
    }

    public JPanel getSouthPanel() {
        return southPanel;
    }

    public void setSouthPanel(JPanel southPanel) {
        this.southPanel = southPanel;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public void setExitButton(JButton exitButton) {
        this.exitButton = exitButton;
    }

    public JPanel getTitlePanel() {
        return titlePanel;
    }

    public void setTitlePanel(JPanel titlePanel) {
        this.titlePanel = titlePanel;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public void setTitleLabel(JLabel titleLabel) {
        this.titleLabel = titleLabel;
    }
}
