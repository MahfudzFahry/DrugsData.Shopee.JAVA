
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.*;
import DBconnection.DBconnection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.Query;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class ProductList extends javax.swing.JFrame {

    Connection connect;
    PreparedStatement pst;
    ResultSet rs;
    private DefaultTableModel tableModel;

    public ProductList() {
        initComponents();
        this.setSize(1300, 750);
        connect = new DBconnection().getConnection();
        this.setLocationRelativeTo(null);
    }
    editData edit = new editData();

    public class MyQuery {

        public Connection getConnection() {
            Connection con = null;
            try {
                con = DriverManager.getConnection("jdbc:mysql://192.168.100.27/product", "root", "12345");
            } catch (SQLException ex) {
                Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            }
            return con;
        }

        public ArrayList<Product2> BindTable() {

            ArrayList<Product2> list = new ArrayList<Product2>();
            Connection con = getConnection();
            Statement st;
            ResultSet rs;

            try {
                String cari = txtsearch.getText();
                st = con.createStatement();
                rs = st.executeQuery("Select * from search_data where product_name like '%" + cari + "%' or sub_category like '%" + cari + "%' or category like '%" + cari + "%' or L3 like '%" + cari + "%' order by category asc");

                Product2 p;
                while (rs.next()) {
                    p = new Product2(
                            rs.getString("no"),
                            rs.getString("code"),
                            rs.getString("category"),
                            rs.getString("sub_category"),
                            rs.getString("L3"),
                            rs.getString("product_name"),
                            rs.getBytes("gambar")
                    );
                    list.add(p);
                }

            } catch (SQLException ex) {
                Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            return list;
        }
    }

    public void delete() {
        try {
            int p = JOptionPane.showConfirmDialog(null, "You must get permission from your Team Leader"
                    + "\nAre you sure deleted this ?", "Delete", JOptionPane.YES_NO_OPTION);
            if (p == 0) {
                int row = tableOutput.getSelectedRow();
                Object value = tableOutput.getModel().getValueAt(row, 0);
                String query = "DELETE FROM search_data where no = " + value;
                try {
                    pst = connect.prepareStatement(query);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "delete succesfully");
                    populateJTable();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Delete failed");
                } finally {
                    try {
                        pst.close();
                        rs.close();
                    } catch (Exception e) {
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please select product");

        }
    }

    public void populateJTable() {
        MyQuery mq = new MyQuery();
        ArrayList<Product2> list = mq.BindTable();
        String[] columnName = {"No.", "Code", "(L1)", "(L2)", "(L3)", "Product Name", "Image"};
        Object[][] rows = new Object[list.size()][7];
        for (int i = 0; i < list.size(); i++) {
            rows[i][0] = list.get(i).getNo();
            rows[i][1] = list.get(i).getCode();
            rows[i][2] = list.get(i).getCategory();
            rows[i][3] = list.get(i).getSub_category();
            rows[i][4] = list.get(i).getL3();
            rows[i][5] = list.get(i).getProduct_name();

            if (list.get(i).getGambar() != null) {

                ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getGambar()).getImage()
                        .getScaledInstance(250, 150, Image.SCALE_SMOOTH));

                rows[i][6] = image;
            } else {
                rows[i][6] = null;
            }
        }

        TheModel model = new TheModel(rows, columnName);
        tableOutput.setModel(model);
        tableOutput.setRowHeight(200);
        tableOutput.getColumnModel().getColumn(6).setPreferredWidth(150);
        tableOutput.getColumnModel().getColumn(2).setPreferredWidth(150);
        tableOutput.getColumnModel().getColumn(0).setPreferredWidth(50);
        tableOutput.getColumnModel().getColumn(1).setPreferredWidth(50);
        tableOutput.getColumnModel().getColumn(3).setPreferredWidth(100);
        tableOutput.getColumnModel().getColumn(4).setPreferredWidth(150);
        tableOutput.getColumnModel().getColumn(5).setPreferredWidth(150);
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableOutput = new javax.swing.JTable();
        btnupdate = new javax.swing.JButton();
        btnsearch = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblreason = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        layout = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(880, 180, 320, 260);

        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtsearch);
        txtsearch.setBounds(180, 140, 440, 40);

        jScrollPane1.setForeground(new java.awt.Color(255, 69, 7));

        tableOutput.setFont(new java.awt.Font("STXihei", 1, 12)); // NOI18N
        tableOutput.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No.", "Code", "(L1)", "(L2)", "(L3)", "Product Name", "Image"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableOutput.setSelectionBackground(new java.awt.Color(247, 105, 10));
        tableOutput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableOutputMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableOutput);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 190, 780, 490);

        btnupdate.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        btnupdate.setText("Edit Data");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnupdate);
        btnupdate.setBounds(890, 520, 320, 50);

        btnsearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconfinder_search_322497 (1).png"))); // NOI18N
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnsearch);
        btnsearch.setBounds(630, 140, 50, 40);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconfinder_document_text_add_103511.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd);
        btnAdd.setBounds(950, 590, 60, 60);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconfinder_-_Trash-Can-_3844425.png"))); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete);
        btnDelete.setBounds(1090, 590, 60, 60);

        lblreason.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        getContentPane().add(lblreason);
        lblreason.setBounds(830, 460, 450, 50);

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logoshopee.png"))); // NOI18N
        getContentPane().add(logo);
        logo.setBounds(530, 20, 320, 80);

        layout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/wallpapershopee.jpg"))); // NOI18N
        layout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                layoutMouseClicked(evt);
            }
        });
        getContentPane().add(layout);
        layout.setBounds(0, 0, 1310, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed

    private void tableOutputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableOutputMouseClicked
        int i = tableOutput.getSelectedRow();
        if (tableOutput.getValueAt(i, 6) != null) {
            ImageIcon image1 = (ImageIcon) tableOutput.getValueAt(i, 6);
            Image image2 = image1.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon image3 = new ImageIcon(image2);
            jLabel1.setIcon(image3);
        } else {
            System.out.println("No Image");
        }
//        if (tableOutput.getValueAt(i, 1).toString().equals("NONE")  && tableOutput.getValueAt(i, 3).toString().equals("DELETED")) {
//            lblreason.setText("Tidak mencantumkan nomor izin edar / "
//                    + "\nLegalitas produk");
//        } else if(tableOutput.getValueAt(i, 1).toString() != "NONE" && tableOutput.getValueAt(i, 3).toString().equals("DELETED")) {
//            lblreason.setText("             Melanggar ketentuan produk Shopee");
//        }
//        else {
//            lblreason.setText("");
//            
//        }
//(tableOutput.getValueAt(i, 4).toString().equals("PASS"))

    }//GEN-LAST:event_tableOutputMouseClicked

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed

        try {
            int p = JOptionPane.showConfirmDialog(null, "You will change about data product"
                    + "\nAre you sure edit this data ?", "Edit", JOptionPane.YES_NO_OPTION);
            if (p == 0) {

                int index = tableOutput.getSelectedRow();
                TableModel model = tableOutput.getModel();
                String id = model.getValueAt(index, 0).toString();
                String code = model.getValueAt(index, 1).toString();
                String category = model.getValueAt(index, 2).toString();
                String SBCategory = model.getValueAt(index, 3).toString();
                String L3 = model.getValueAt(index, 4).toString();
                String product = model.getValueAt(index, 5).toString();

                int i = tableOutput.getSelectedRow();
                if (tableOutput.getValueAt(i, 6) != null) {
                    ImageIcon image1 = (ImageIcon) tableOutput.getValueAt(i, 6);
                    Image image2 = image1.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon image3 = new ImageIcon(image2);
                    edit.jlabeloutputgmbar.setIcon(image3);
                } else {
                    System.out.println("No Image");
                }

                edit.setVisible(true);
                this.dispose();
                edit.pack();
                edit.setSize(1065, 650);

                edit.setLocationRelativeTo(null);

                edit.txtid.setText(id);
                edit.txtCODE.setText(code);
                edit.txtCategory.setText(category);
                edit.txtSBCategory.setText(SBCategory);
                edit.txtL3.setText(L3);
                edit.txtProductNM.setText(product);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please select product");
        }

    }//GEN-LAST:event_btnupdateActionPerformed

    private void layoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_layoutMouseClicked

    }//GEN-LAST:event_layoutMouseClicked

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        populateJTable();
    }//GEN-LAST:event_btnsearchActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        new InputItem().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtsearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyPressed
//        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            populateJTable();
//        }
    }//GEN-LAST:event_txtsearchKeyPressed

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        populateJTable();
    }//GEN-LAST:event_txtsearchKeyReleased
    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProductList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnsearch;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel layout;
    private javax.swing.JLabel lblreason;
    private javax.swing.JLabel logo;
    private javax.swing.JTable tableOutput;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
