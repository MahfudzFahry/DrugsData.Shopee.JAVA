
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class InputItem extends javax.swing.JFrame {

    Connection connect;
    Statement stmt;
    ResultSet rs;
    String s;

    public InputItem() {

        initComponents();
        this.setSize(1057, 650);
        this.setLocationRelativeTo(null);

    }

    private void input() {

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://192.168.100.27/product", "root", "12345");
            PreparedStatement ps = con.prepareStatement("insert into search_data(code,category,sub_category,L3,product_name,gambar) values(?,?,?,?,?,?)");
            InputStream is = new FileInputStream(new File(s));
            ps.setString(1, txtCODE.getText());
            ps.setString(2, txtCategory.getText());
            ps.setString(3, txtSbCategory.getText());
            ps.setString(4, txtL3.getText());
            ps.setString(5, txtProductNM1.getText());
            ps.setBlob(6, is);

            int data = ps.executeUpdate();
            if (data == 1) {
                JOptionPane.showMessageDialog(this, "Data Inserted....");
                txtCODE.setText("");
                txtCategory.setText("");
                txtSbCategory.setText("");
                txtL3.setText("");
                txtProductNM1.setText("");
                jlabeloutputgmbar.setIcon(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to insert data!!!");
        }
    }
    /*  if (txtProduct.equals("")) {
     JOptionPane.showMessageDialog(this, "Please fill Product Name text box!!!");
     } else if (jlabeloutputgmbar == (null)) {
     JOptionPane.showMessageDialog(this, "Please choose image product!!!");
     } else {
            
     }*/

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
        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("No Data");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCODE = new javax.swing.JTextField();
        txtSbCategory = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        choosefile = new javax.swing.JButton();
        jlabeloutputgmbar = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtL3 = new javax.swing.JTextField();
        txtCategory = new javax.swing.JTextField();
        txtProductNM1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        layout = new javax.swing.JLabel();
        jlabeloutputgmbar1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        txtCODE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCODEActionPerformed(evt);
            }
        });
        getContentPane().add(txtCODE);
        txtCODE.setBounds(40, 190, 440, 40);

        txtSbCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSbCategoryActionPerformed(evt);
            }
        });
        getContentPane().add(txtSbCategory);
        txtSbCategory.setBounds(40, 340, 440, 40);

        btnBack.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconfinder_ic_home_48px_352427 (1).png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(450, 540, 40, 40);

        btnSave.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave);
        btnSave.setBounds(90, 540, 310, 40);

        choosefile.setText("Choose Image");
        choosefile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choosefileActionPerformed(evt);
            }
        });
        getContentPane().add(choosefile);
        choosefile.setBounds(730, 160, 130, 40);

        jlabeloutputgmbar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/square-frame (6).png"))); // NOI18N
        getContentPane().add(jlabeloutputgmbar);
        jlabeloutputgmbar.setBounds(670, 210, 280, 270);

        jLabel5.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconfinder_32_171485.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(780, 320, 40, 30);

        jLabel4.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        jLabel4.setText("SUB CATEGORY");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 320, 140, 20);

        jLabel2.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        jLabel2.setText("CATEGORY");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 240, 140, 20);

        jLabel1.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        jLabel1.setText("CODE");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 160, 140, 20);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconfinder_document_text_add_103511.png"))); // NOI18N
        jLabel3.setText(" ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(990, 0, 50, 60);

        jLabel6.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        jLabel6.setText("L3");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(40, 390, 140, 20);
        getContentPane().add(txtL3);
        txtL3.setBounds(40, 410, 440, 40);

        txtCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCategoryActionPerformed(evt);
            }
        });
        getContentPane().add(txtCategory);
        txtCategory.setBounds(40, 270, 440, 40);
        getContentPane().add(txtProductNM1);
        txtProductNM1.setBounds(40, 480, 440, 40);

        jLabel7.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        jLabel7.setText("PRODUCT NAME");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(40, 460, 140, 20);

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logoshopee.png"))); // NOI18N
        getContentPane().add(logo);
        logo.setBounds(320, 20, 320, 80);

        layout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/wallpapershopee.jpg"))); // NOI18N
        getContentPane().add(layout);
        layout.setBounds(0, 0, 1040, 600);

        jlabeloutputgmbar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/square-frame (6).png"))); // NOI18N
        getContentPane().add(jlabeloutputgmbar1);
        jlabeloutputgmbar1.setBounds(670, 210, 280, 270);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCODEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCODEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCODEActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
input();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void choosefileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choosefileActionPerformed
        choose();
    }//GEN-LAST:event_choosefileActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new ProductList().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoryActionPerformed

    private void txtSbCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSbCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSbCategoryActionPerformed
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InputItem().setVisible(true);
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
    private javax.swing.JLabel jlabeloutputgmbar;
    private javax.swing.JLabel jlabeloutputgmbar1;
    private javax.swing.JLabel layout;
    private javax.swing.JLabel logo;
    private javax.swing.JTextField txtCODE;
    private javax.swing.JTextField txtCategory;
    private javax.swing.JTextField txtL3;
    private javax.swing.JTextField txtProductNM1;
    private javax.swing.JTextField txtSbCategory;
    // End of variables declaration//GEN-END:variables
 public ImageIcon ResizeImage(String imgPath) {
        ImageIcon MyImage = new ImageIcon(imgPath);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(jlabeloutputgmbar.getWidth(), jlabeloutputgmbar.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }
}
