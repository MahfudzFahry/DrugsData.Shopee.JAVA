


import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class editData extends javax.swing.JFrame {

    Connection connect;
    Statement stmt;
    ResultSet rs;
    String s;
    String idUpdate;
    int flag;

    public editData() {
        initComponents();
        this.setSize(1065, 650);

        this.setLocationRelativeTo(null);

        idUpdate = txtid.getText();
        txtid.setEditable(false);
    }

    public void choose() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "gif", "png");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            jlabeloutputgmbar.setIcon(ResizeImage(path));
            s = path;
            flag = 1;
        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("No Data");
        }
    }

    private void update() {
        String id = txtid.getText();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://192.168.100.27/product", "root", "12345");
            String query = "UPDATE search_data SET code=?, category=?, sub_category=?, L3=?, product_name=? WHERE no ='" + id + "'";
            PreparedStatement ps = con.prepareStatement(query);

//            InputStream is = new FileInputStream(new File(s));
            ps.setString(1, txtCODE.getText());
            ps.setString(2, txtCategory.getText());
            ps.setString(3, txtSBCategory.getText());
            ps.setString(4, txtL3.getText());
            ps.setString(5, txtProductNM.getText());
            int data = ps.executeUpdate();
            if (data != 0) {
                JOptionPane.showMessageDialog(this, "Data Updated....");
                txtCODE.setText("");
                txtCategory.setText("");
                txtSBCategory.setText("");
                txtProductNM.setText("");
                txtL3.setText("");
                jlabeloutputgmbar.setIcon(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    private void update2() {
        String id = txtid.getText();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://192.168.100.27/product", "root", "12345");
            String query = "UPDATE search_data SET code=?, category=?, sub_category=?, L3=?, product_name=?, gambar=? WHERE no ='" + id + "'";
            PreparedStatement ps = con.prepareStatement(query);

            InputStream is = new FileInputStream(new File(s));
            ps.setString(1, txtCODE.getText());
            ps.setString(2, txtCategory.getText());
            ps.setString(3, txtSBCategory.getText());
            ps.setString(4, txtL3.getText());
            ps.setString(5, txtProductNM.getText());
            ps.setBlob(6, is);
            int data = ps.executeUpdate();
            if (data != 0) {
                JOptionPane.showMessageDialog(this, "Data Updated....");
                txtCODE.setText("");
                txtCategory.setText("");
                txtSBCategory.setText("");
                txtL3.setText("");
                txtProductNM.setText("");
                txtL3.setText("");
                
                jlabeloutputgmbar.setIcon(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCODE = new javax.swing.JTextField();
        txtCategory = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        choosefile = new javax.swing.JButton();
        jlabeloutputgmbar = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtSBCategory = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtProductNM = new javax.swing.JTextField();
        txtL3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        txtCODE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCODEActionPerformed(evt);
            }
        });
        getContentPane().add(txtCODE);
        txtCODE.setBounds(50, 160, 440, 40);

        txtCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCategoryActionPerformed(evt);
            }
        });
        getContentPane().add(txtCategory);
        txtCategory.setBounds(50, 240, 440, 40);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave);
        btnSave.setBounds(60, 550, 310, 40);

        choosefile.setText("Choose file");
        choosefile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choosefileActionPerformed(evt);
            }
        });
        getContentPane().add(choosefile);
        choosefile.setBounds(680, 150, 130, 40);

        jlabeloutputgmbar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/square-frame (6).png"))); // NOI18N
        getContentPane().add(jlabeloutputgmbar);
        jlabeloutputgmbar.setBounds(620, 200, 290, 280);

        jLabel6.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconfinder_32_171485.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(730, 320, 40, 30);

        jLabel2.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        jLabel2.setText("CATEGORY");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 210, 140, 20);

        jLabel5.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        jLabel5.setText("CODE");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(50, 130, 140, 20);

        btnBack.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconfinder_ic_home_48px_352427 (1).png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(450, 550, 40, 40);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconfinder_pencil_216350.png"))); // NOI18N
        jLabel7.setText(" ");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(1000, 0, 50, 60);

        txtSBCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSBCategoryActionPerformed(evt);
            }
        });
        getContentPane().add(txtSBCategory);
        txtSBCategory.setBounds(50, 320, 440, 40);

        jLabel3.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        jLabel3.setText("SUB CATEGORY");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 290, 140, 20);
        getContentPane().add(txtProductNM);
        txtProductNM.setBounds(50, 480, 440, 40);
        getContentPane().add(txtL3);
        txtL3.setBounds(50, 400, 440, 40);

        jLabel4.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        jLabel4.setText("L3");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 370, 140, 20);

        jLabel8.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        jLabel8.setText("PRODUCT NAME");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(50, 450, 140, 20);

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logoshopee.png"))); // NOI18N
        getContentPane().add(logo);
        logo.setBounds(320, 20, 320, 80);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/wallpapershopee.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1060, 640);

        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });
        getContentPane().add(txtid);
        txtid.setBounds(400, 250, 10, 10);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCODEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCODEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCODEActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (flag == 1) {
            update2();
        } else {
            update();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void choosefileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choosefileActionPerformed
        choose();
    }//GEN-LAST:event_choosefileActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new ProductList().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void txtCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoryActionPerformed

    private void txtSBCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSBCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSBCategoryActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(editData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton choosefile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jlabeloutputgmbar;
    private javax.swing.JLabel logo;
    public javax.swing.JTextField txtCODE;
    public javax.swing.JTextField txtCategory;
    public javax.swing.JTextField txtL3;
    public javax.swing.JTextField txtProductNM;
    public javax.swing.JTextField txtSBCategory;
    public javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
public ImageIcon ResizeImage(String imgPath) {
        ImageIcon MyImage = new ImageIcon(imgPath);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(jlabeloutputgmbar.getWidth(), jlabeloutputgmbar.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }
}
