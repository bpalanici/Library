import DB.DatabaseConnection;
import DB.DatabaseController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Vector;
public class AdminGUI {
    private JPanel adminPanel;
    private JPanel searchPanel;
    private JTextField searchField;
    private JComboBox searchTypeComboBox;
    private JButton searchButton;
    private JComboBox orderComboBox;
    private JComboBox sortByComboBox;
    private JButton insertBookButton;
    private JButton insertAuthorButton;
    private JButton insertGenreButton;
    private JButton insertSubgenreButton;
    private JPanel southPanel;
    private JButton logOutButton;
    private JButton rollbackButton;
    private JScrollPane scrollPane;

    private JTable table1;
    private JButton exportButton;
    private DefaultTableModel model = (DefaultTableModel)table1.getModel();

    public AdminGUI() {
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InitGUI.getAdminFrame().setVisible(false);
                InitGUI.getLoginFrame().setVisible(true);
                LoginGUI.setReaderUsername(null);
            }
        });
        insertBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InitGUI.getInsertBookFrame().setVisible(true);
            }
        });
        insertAuthorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InitGUI.getInsertAuthorframe().setVisible(true);
            }
        });
        insertGenreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InitGUI.getInsertGenreFrame().setVisible(true);
            }
        });
        insertSubgenreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InitGUI.getInsertSubgenreFrame().setVisible(true);
            }
        });
        rollbackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DatabaseConnection.rollback();
                DatabaseConnection.commit();
                JOptionPane.showMessageDialog(null, "Rollback efectuat cu succes!");
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
        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InitGUI.getExportFrame().setVisible(true);
            }
        });
    }


    public JPanel getAdminPanel() {
        return adminPanel;
    }

    public void setAdminPanel(JPanel adminPanel) {
        this.adminPanel = adminPanel;
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

    public JTable getTable1() {
        return table1;
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }

    public JButton getInsertBookButton() {
        return insertBookButton;
    }

    public void setInsertBookButton(JButton insertBookButton) {
        this.insertBookButton = insertBookButton;
    }

    public JButton getInsertAuthorButton() {
        return insertAuthorButton;
    }

    public void setInsertAuthorButton(JButton insertAuthorButton) {
        this.insertAuthorButton = insertAuthorButton;
    }

    public JButton getInsertGenreButton() {
        return insertGenreButton;
    }

    public void setInsertGenreButton(JButton insertGenreButton) {
        this.insertGenreButton = insertGenreButton;
    }

    public JButton getInsertSubgenreButton() {
        return insertSubgenreButton;
    }

    public void setInsertSubgenreButton(JButton insertSubgenreButton) {
        this.insertSubgenreButton = insertSubgenreButton;
    }

    public JPanel getSouthPanel() {
        return southPanel;
    }

    public void setSouthPanel(JPanel southPanel) {
        this.southPanel = southPanel;
    }
}
