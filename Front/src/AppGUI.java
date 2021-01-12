import DB.DatabaseConnection;
import DB.DatabaseController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Vector;

public class AppGUI {
    private JScrollPane tableScrollPane;
    private JPanel AppPanel;
    private JPanel searchPanel;
    private JTextField searchField;
    private JComboBox searchTypeComboBox;
    private JButton searchButton;
    private JComboBox orderComboBox;
    private JComboBox sortByComboBox;
    private JButton borrowedBooksButton;
    private JPanel southPanel;
    private JButton logOutButton;

    private JTable tableSearch;
    private JButton borrowBookButton;
    private JButton seeBookReviewsButton;
    private JButton next50Button;
    private JButton prev50Button;
    private JButton recommendationsButton;
    private JLabel totalFineLabel;

    private DefaultTableModel model = (DefaultTableModel)tableSearch.getModel();
    private int pageIndex = -1;

    private static int bookReviewId = -1;

    public AppGUI() {
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InitGUI.getAppFrame().setVisible(false);
                InitGUI.getLoginFrame().setVisible(true);
                LoginGUI.setReaderUsername(null);
            }
        });
        model.addColumn("ID");
        model.addColumn("AuthorID");
        model.addColumn("Name");
        model.addColumn("ISBN");
        model.addColumn("NrPages");
        model.addColumn("Price");
        model.addColumn("Rating");
        model.addColumn("AuthorName");
        model.addColumn("Genre");
        model.addColumn("SubGenre");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    model.setRowCount(0);
                    totalFineLabel.setText("Total fine: " + ((Integer) LoginGUI.getTotalFine()).toString());
                    pageIndex = 0;
                    Vector<Vector> rows;
                    rows = DatabaseController.selectTopBooks(1, 50, searchField.getText(), searchTypeComboBox.getSelectedItem().toString(),
                            sortByComboBox.getSelectedItem().toString(), orderComboBox.getSelectedItem().toString());
                    for(Vector i : rows) {
                        model.addRow(i);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        seeBookReviewsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tableSearch.getSelectedRow() != -1) {
                    setBookReviewId(Integer.valueOf((String) model.getValueAt(tableSearch.getSelectedRow(), 0)));
                    try {
                        InitGUI.getReviewsFrame().setContentPane(new ReviewsGUI().getReviewsPanel());
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    InitGUI.getReviewsFrame().pack();
                    InitGUI.getReviewsFrame().setLocationRelativeTo(null);
                    InitGUI.getReviewsFrame().setVisible(true);
                }
                else
                    JOptionPane.showMessageDialog(null, "Trebuie sa selectezi cartea din tabela", "Warning!", JOptionPane.PLAIN_MESSAGE);
            }
        });
        borrowedBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InitGUI.getBorrowedBooksFrame().setVisible(true);
            }
        });
        borrowBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tableSearch.getSelectedRow() != -1) {
                    try {
                        int bookId = Integer.valueOf((String)model.getValueAt(tableSearch.getSelectedRow(), 0));
                        int result = DatabaseController.borrowBook(LoginGUI.getReaderUsername(), bookId);
                        if (result == 1) {
                            JOptionPane.showMessageDialog(null, "Cartea a fost imprumutata cu succes");
                            DatabaseConnection.commit();
                        }
                        else if (result == -3){
                            JOptionPane.showMessageDialog(null, "Cartea e deja imprumutata de altcineva.");
                        }
                        else if (result == -2){
                            JOptionPane.showMessageDialog(null, "Cartea e deja imprumutata de userul curent");
                        }
                        else if (result == -1){
                            JOptionPane.showMessageDialog(null, "Nu poti imprumuta cartea pana nu platesti amenda.");
                        }
                        else if (result == 0){
                            JOptionPane.showMessageDialog(null, "Amenda utilizatorului e prea mare. Pentru a imprumuta, amenda trebuie sa fie maxim de ori valoarea cartii");
                        }

                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, "Pentru a putea imprumuta, trebuie sa selectezi o carte!", "Warning!", JOptionPane.PLAIN_MESSAGE);
            }
        });
        recommendationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InitGUI.getRecommendationsFrame().setVisible(true);
            }
        });
        prev50Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(pageIndex != 0 && pageIndex != -1)
                {
                    pageIndex = pageIndex - 50;
                    try {
                        model.setRowCount(0);
                        Vector<Vector> rows;
                        rows = DatabaseController.selectTopBooks(pageIndex + 1, pageIndex + 50, searchField.getText(), searchTypeComboBox.getSelectedItem().toString(),
                                sortByComboBox.getSelectedItem().toString(), orderComboBox.getSelectedItem().toString());
                        for(Vector i : rows) {
                            model.addRow(i);
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        next50Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pageIndex != -1) {
                    pageIndex = pageIndex + 50;
                    try {
                        model.setRowCount(0);
                        Vector<Vector> rows;
                        rows = DatabaseController.selectTopBooks(pageIndex + 1, pageIndex + 50, searchField.getText(), searchTypeComboBox.getSelectedItem().toString(),
                                sortByComboBox.getSelectedItem().toString(), orderComboBox.getSelectedItem().toString());
                        for (Vector i : rows) {
                            model.addRow(i);
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }

    public JScrollPane getTableScrollPane() {
        return tableScrollPane;
    }

    public void setTableScrollPane(JScrollPane tableScrollPane) {
        this.tableScrollPane = tableScrollPane;
    }

    public JPanel getAppPanel() {
        return AppPanel;
    }

    public void setAppPanel(JPanel appPanel) {
        AppPanel = appPanel;
    }

    public JPanel getSearchPanel() {
        return searchPanel;
    }

    public void setSearchPanel(JPanel searchPanel) {
        this.searchPanel = searchPanel;
    }

    public JTextField getSearchField() {
        return searchField;
    }

    public void setSearchField(JTextField searchField) {
        this.searchField = searchField;
    }

    public JComboBox getSearchTypeComboBox() {
        return searchTypeComboBox;
    }

    public void setSearchTypeComboBox(JComboBox searchTypeComboBox) {
        this.searchTypeComboBox = searchTypeComboBox;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(JButton searchButton) {
        this.searchButton = searchButton;
    }

    public JComboBox getOrderComboBox() {
        return orderComboBox;
    }

    public void setOrderComboBox(JComboBox orderComboBox) {
        this.orderComboBox = orderComboBox;
    }

    public JComboBox getSortByComboBox() {
        return sortByComboBox;
    }

    public void setSortByComboBox(JComboBox sortByComboBox) {
        this.sortByComboBox = sortByComboBox;
    }

    public JButton getBorrowedBooksButton() {
        return borrowedBooksButton;
    }

    public void setBorrowedBooksButton(JButton borrowedBooksButton) {
        this.borrowedBooksButton = borrowedBooksButton;
    }

    public JPanel getSouthPanel() {
        return southPanel;
    }

    public void setSouthPanel(JPanel southPanel) {
        this.southPanel = southPanel;
    }

    public JButton getLogOutButton() {
        return logOutButton;
    }

    public void setLogOutButton(JButton logOutButton) {
        this.logOutButton = logOutButton;
    }

    public JTable getTableSearch() {
        return tableSearch;
    }

    public void setTableSearch(JTable tableSearch) {
        this.tableSearch = tableSearch;
    }

    public static int getBookReviewId() {
        return bookReviewId;
    }

    public static void setBookReviewId(int bookId) {
        AppGUI.bookReviewId = bookId;
    }

}

