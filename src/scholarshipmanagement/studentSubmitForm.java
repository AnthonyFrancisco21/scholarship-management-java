/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package scholarshipmanagement;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.Statement;


/**
 *
 * @author User
 */
public class studentSubmitForm extends javax.swing.JFrame {
    int studentId;
    Connection conn;
    
    File f1 = null;
    File f2 = null;
    File f3 = null;
    File f4 = null;
    File f5 = null;
    String path = null;
    private ImageIcon format = null;
    int s = 0;
    
    /**
     * Creates new form studentSubmitForm
     * 
     * 
     * @param studentId
     */
    public studentSubmitForm(int studentId) {
        initComponents();
        this.studentId = studentId;
        System.out.println("pass student" + studentId);
        conn = new DBConnection().connect();
    
        if (conn != null) {
            System.out.println("Connection successful im studentSubmit!");
        } else {
            System.out.println("Connection failed in studentSubmit.");
        }
        
    }

    
    public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/bucot_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (java.sql.SQLException ex) {
            System.out.println("Database connection failed in studentSubmit: " + ex.getMessage());
            return null;
        }
    }
}
 
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        form3_show = new javax.swing.JLabel();
        form1_btn = new javax.swing.JButton();
        form1_show = new javax.swing.JLabel();
        form2_btn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        form2_show = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        form3_btn = new javax.swing.JButton();
        form4_show = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        form4_btn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        form5_show = new javax.swing.JLabel();
        form5_btn = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(15, 85, 150));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REQUIREMENTS SUBMISSION");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Birth Certificate");

        form3_show.setBackground(new java.awt.Color(51, 0, 255));
        form3_show.setForeground(new java.awt.Color(153, 153, 153));
        form3_show.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        form3_show.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        form1_btn.setText("Upload IMG");
        form1_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                form1_btnActionPerformed(evt);
            }
        });

        form1_show.setBackground(new java.awt.Color(51, 0, 255));
        form1_show.setForeground(new java.awt.Color(153, 153, 153));
        form1_show.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        form1_show.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        form2_btn.setText("Upload IMG");
        form2_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                form2_btnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("2x2 Picture");

        form2_show.setBackground(new java.awt.Color(51, 0, 255));
        form2_show.setForeground(new java.awt.Color(153, 153, 153));
        form2_show.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        form2_show.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("COR / ADMISSION SLIP");

        form3_btn.setText("Upload IMG");
        form3_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                form3_btnActionPerformed(evt);
            }
        });

        form4_show.setBackground(new java.awt.Color(51, 0, 255));
        form4_show.setForeground(new java.awt.Color(153, 153, 153));
        form4_show.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        form4_show.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Form 137");

        form4_btn.setText("Upload IMG");
        form4_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                form4_btnActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Letter");

        form5_show.setBackground(new java.awt.Color(51, 0, 255));
        form5_show.setForeground(new java.awt.Color(153, 153, 153));
        form5_show.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        form5_show.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        form5_btn.setText("Upload IMG");
        form5_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                form5_btnActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(15, 85, 150));
        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Save Requirements");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(form2_show, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(form3_show, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(form4_show, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(120, 120, 120)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(form5_show, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(form4_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180)
                        .addComponent(form5_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(form1_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(form2_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)))
                .addComponent(form3_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(68, 68, 68)
                    .addComponent(form1_show, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(606, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(form3_show, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(form2_show, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(form2_btn)
                        .addComponent(form1_btn))
                    .addComponent(form3_btn))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(form4_show, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(form5_show, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(form4_btn)
                    .addComponent(form5_btn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(18, 18, 18))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(108, 108, 108)
                    .addComponent(form1_show, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(377, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 690));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void form4_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_form4_btnActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter fnwf = new FileNameExtensionFilter("PNG JPG AND JPEG", "png", "jpeg", "jpg");
        fileChooser.addChoosableFileFilter(fnwf);
        int load = fileChooser.showOpenDialog(null);
        
        if(load==fileChooser.APPROVE_OPTION){
            f4 = fileChooser.getSelectedFile();
            
            path = f4.getAbsolutePath();
            
            ImageIcon ii = new ImageIcon(path);
            Image img = ii.getImage().getScaledInstance(225,225, Image.SCALE_SMOOTH);
            form4_show.setIcon(new ImageIcon(img));
        }
    }//GEN-LAST:event_form4_btnActionPerformed

    private void form5_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_form5_btnActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter fnwf = new FileNameExtensionFilter("PNG JPG AND JPEG", "png", "jpeg", "jpg");
        fileChooser.addChoosableFileFilter(fnwf);
        int load = fileChooser.showOpenDialog(null);
        
        if(load==fileChooser.APPROVE_OPTION){
            f5 = fileChooser.getSelectedFile();
            
            path = f5.getAbsolutePath();
            
            ImageIcon ii = new ImageIcon(path);
            Image img = ii.getImage().getScaledInstance(225,225, Image.SCALE_SMOOTH);
            form5_show.setIcon(new ImageIcon(img));
        }
    }//GEN-LAST:event_form5_btnActionPerformed

    private void form1_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_form1_btnActionPerformed
        
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter fnwf = new FileNameExtensionFilter("PNG JPG AND JPEG", "png", "jpeg", "jpg");
        fileChooser.addChoosableFileFilter(fnwf);
        int load = fileChooser.showOpenDialog(null);
        
        if(load==fileChooser.APPROVE_OPTION){
            f1 = fileChooser.getSelectedFile();
            
            path = f1.getAbsolutePath();
            
            ImageIcon ii = new ImageIcon(path);
            Image img = ii.getImage().getScaledInstance(225,225, Image.SCALE_SMOOTH);
            form1_show.setIcon(new ImageIcon(img));
        }
        
        
    }//GEN-LAST:event_form1_btnActionPerformed

    private void form2_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_form2_btnActionPerformed
        
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter fnwf = new FileNameExtensionFilter("PNG JPG AND JPEG", "png", "jpeg", "jpg");
        fileChooser.addChoosableFileFilter(fnwf);
        int load = fileChooser.showOpenDialog(null);
        
        if(load==fileChooser.APPROVE_OPTION){
            f2 = fileChooser.getSelectedFile();
            
            path = f2.getAbsolutePath();
            
            ImageIcon ii = new ImageIcon(path);
            Image img = ii.getImage().getScaledInstance(225,225, Image.SCALE_SMOOTH);
            form2_show.setIcon(new ImageIcon(img));
        }
        
        
    }//GEN-LAST:event_form2_btnActionPerformed

    private void form3_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_form3_btnActionPerformed
        
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter fnwf = new FileNameExtensionFilter("PNG JPG AND JPEG", "png", "jpeg", "jpg");
        fileChooser.addChoosableFileFilter(fnwf);
        int load = fileChooser.showOpenDialog(null);
        
        if(load==fileChooser.APPROVE_OPTION){
            f3 = fileChooser.getSelectedFile();
            
            path = f3.getAbsolutePath();
            
            ImageIcon ii = new ImageIcon(path);
            Image img = ii.getImage().getScaledInstance(225,225, Image.SCALE_SMOOTH);
            form3_show.setIcon(new ImageIcon(img));
        }
    }//GEN-LAST:event_form3_btnActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String sql = "INSERT INTO submission (form1, form2, form3, form4, form5) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pst.setBinaryStream(1, new FileInputStream(f1));
            pst.setBinaryStream(2, new FileInputStream(f2));
            pst.setBinaryStream(3, new FileInputStream(f3));
            pst.setBinaryStream(4, new FileInputStream(f4));
            pst.setBinaryStream(5, new FileInputStream(f5));

            int inserted = pst.executeUpdate();

            if (inserted > 0) {
                ResultSet rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    int submissionId = rs.getInt(1);

                    // Now update the student record with the new submission ID
                    String updateStudentSql = "UPDATE student SET sub_id = ? , status_id = ? WHERE student_id = ?";
                    try (PreparedStatement updatePst = conn.prepareStatement(updateStudentSql)) {
                        
                        System.out.println("This is sub_id" + submissionId);
                        System.out.println("This is student" + studentId);
                        
                        updatePst.setInt(1, submissionId);
                        updatePst.setInt(2, 3); //Pending after submission
                        updatePst.setInt(3, studentId); 
                        

                        int updated = updatePst.executeUpdate();
                        if (updated > 0) {
                            JOptionPane.showMessageDialog(this, "Forms uploaded!");
                            this.setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(this, "Forms uploaded, but failed to update student record.");
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Failed to upload forms.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }

        
        
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(studentSubmitForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(studentSubmitForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(studentSubmitForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(studentSubmitForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new studentSubmitForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton form1_btn;
    private javax.swing.JLabel form1_show;
    private javax.swing.JButton form2_btn;
    private javax.swing.JLabel form2_show;
    private javax.swing.JButton form3_btn;
    private javax.swing.JLabel form3_show;
    private javax.swing.JButton form4_btn;
    private javax.swing.JLabel form4_show;
    private javax.swing.JButton form5_btn;
    private javax.swing.JLabel form5_show;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
