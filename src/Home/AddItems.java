package Home;

import DAO.Item;
import Login.UserLogin;
import javax.swing.JOptionPane;

public class AddItems extends javax.swing.JFrame {

    private final Item item;

    public AddItems() {
        item = new Item();
        initComponents();
    }

    private void initComponents() {
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        quantityfield = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADD ITEMS");
        setResizable(false);
        getContentPane().setLayout(null);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Dress", "Books", "Shoes", "Stationery", "Bag"}));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(357, 102, 272, 50);

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 18));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Select Item");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(210, 100, 120, 50);

        getContentPane().add(quantityfield);
        quantityfield.setBounds(357, 204, 136, 41);

        jLabel2.setFont(new java.awt.Font("Segoe Print", 1, 18));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Quantity");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(230, 210, 100, 22);

        jButton1.setBackground(new java.awt.Color(255, 212, 49));
        jButton1.setFont(new java.awt.Font("Segoe Print", 1, 14));
        jButton1.setText("Save");
        jButton1.addActionListener(evt -> saveButtonActionPerformed());
        getContentPane().add(jButton1);
        jButton1.setBounds(380, 350, 96, 41);

        jButton2.setBackground(new java.awt.Color(255, 212, 49));
        jButton2.setFont(new java.awt.Font("Segoe Print", 1, 14));
        jButton2.setText("Back");
        jButton2.addActionListener(evt -> backButtonActionPerformed());
        getContentPane().add(jButton2);
        jButton2.setBounds(640, 500, 72, 34);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Image16.jpg")));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 0, 800, 655);

        setSize(new java.awt.Dimension(810, 661));
        setLocationRelativeTo(null);
    }

    private void saveButtonActionPerformed() {
        String quantityText = quantityfield.getText().trim();

        if (quantityText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Quantity cannot be empty", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!quantityText.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Invalid Quantity Entered", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirmation = JOptionPane.showConfirmDialog(this, "Do you really want to update this information?", "Are you sure?", JOptionPane.YES_NO_OPTION);
        if (confirmation == JOptionPane.YES_OPTION) {
            try {
                int number = Integer.parseInt(quantityText);
                int result = item.updateQuantity(jComboBox1.getSelectedItem().toString(), number);

                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Information updated successfully", "Success!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Sorry, unable to save!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Unexpected error while processing quantity", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void backButtonActionPerformed() {
        UserDashboard.main(new String[]{});
        dispose();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new AddItems().setVisible(true));
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField quantityfield;
}
