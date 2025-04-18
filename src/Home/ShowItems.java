package Home;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Controller.DB;
import net.proteanit.sql.DbUtils;

public class ShowItems extends javax.swing.JFrame {

    public ShowItems() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        ItemsTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SHOW ITEMS LIST");
        setResizable(false);
        getContentPane().setLayout(null);

        ItemsTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null}
                },
                new String [] {
                        "ID", "Name", "Quantity"
                }
        ));
        jScrollPane1.setViewportView(ItemsTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(198, 40, 610, 600);

        jButton1.setBackground(new java.awt.Color(228, 228, 228));
        jButton1.setFont(new java.awt.Font("Segoe Print", 1, 14));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(60, 542, 80, 30);

        jButton2.setBackground(new java.awt.Color(228, 228, 228));
        jButton2.setFont(new java.awt.Font("Segoe Print", 1, 14));
        jButton2.setText("Show");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(60, 140, 80, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Image30.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 200, 650);

        jLabel2.setFont(new java.awt.Font("Tibetan Machine Uni", 1, 15));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ITEM DETAILS");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(200, 8, 610, 30);

        setSize(new java.awt.Dimension(819, 655));
        setLocationRelativeTo(null);
    }

    public void fetch() throws SQLException {
        Connection con = DB.getConnection();
        PreparedStatement pst1;

        // Fixed SQL query: Removed 'rate' column as it doesn't exist in the database
        pst1 = con.prepareStatement("SELECT id AS 'ID', name AS 'Name', quantity AS 'Quantity' FROM item");

        ResultSet rs1 = pst1.executeQuery();
        ItemsTable.setModel(DbUtils.resultSetToTableModel(rs1));
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        AdminDashboard.main(new String[]{});
        dispose();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            fetch();
        } catch (SQLException ex) {
            Logger.getLogger(ShowItems.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowItems().setVisible(true);
            }
        });
    }

    private javax.swing.JTable ItemsTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
}
