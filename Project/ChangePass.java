

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ASIF
 */
public class ChangePass extends javax.swing.JFrame {

    /**
     * Creates new form ChangePass
     */
    String username;

    public ChangePass(String username) {
        initComponents();
        ToolTipManager.sharedInstance().setInitialDelay(100);
        this.username = username;
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
        jLabel2 = new javax.swing.JLabel();
        newpass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        conpass = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-reset-password-65.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 6, 73, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("New Password:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 460, 125, -1));

        newpass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newpassMouseEntered(evt);
            }
        });
        newpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newpassActionPerformed(evt);
            }
        });
        getContentPane().add(newpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 490, 370, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Confirm Password:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 570, 140, 20));

        conpass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                conpassMouseEntered(evt);
            }
        });
        conpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conpassActionPerformed(evt);
            }
        });
        getContentPane().add(conpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 590, 370, 40));

        jButton1.setBackground(new java.awt.Color(74, 31, 61));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/exchange.png"))); // NOI18N
        jButton1.setText("Change");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(972, 670, 380, 70));

        jCheckBox5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jCheckBox5.setText("Show Password");
        jCheckBox5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox5MouseClicked(evt);
            }
        });
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 530, -1, -1));

        jCheckBox6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jCheckBox6.setText("Show Password");
        jCheckBox6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox6MouseClicked(evt);
            }
        });
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 640, -1, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setText("Change Password!");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 16, 345, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 102));
        jLabel5.setText("X");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1505, 6, 17, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/back.png"))); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1424, 782, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/change pass.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, -1, 1020));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox5MouseClicked
    
    }//GEN-LAST:event_jCheckBox5MouseClicked

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        // TODO add your handling code here:
         if (jCheckBox5.isSelected()) {
        newpass.setEchoChar((char) 0); // Show characters
    } else {
        newpass.setEchoChar('*'); // Hide characters with '*'
    }

    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox6MouseClicked

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox6.isSelected()) {
        conpass.setEchoChar((char) 0); // Show characters
    } else {
        conpass.setEchoChar('*'); // Hide characters with '*'
    }
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void conpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_conpassActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        String newPassword = newpass.getText();
        String confirmPassword = conpass.getText();

        // Check if new password matches the confirm password
        if (newPassword.equals(confirmPassword)) {
            try {
                java.sql.Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "root");
                
                // Update the password in the database
                String query = "UPDATE StudentRegistration SET password = ? WHERE username = ?";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, newPassword);
                pstmt.setString(2, username);
                
                int updatedRows = pstmt.executeUpdate();
                
                if (updatedRows > 0) {
                    JOptionPane.showMessageDialog(this, "Password updated successfully!");
                    // Close the ChangePass frame after successful password update
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to update password. Please try again.");
                }
                
                // Close the database connection
                con.close();
            } catch (SQLException ex) {
                // Handle database errors
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error connecting to the database.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Passwords do not match. Please try again.");
        }
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void newpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newpassActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ForgotPassSt s= new ForgotPassSt();
        s.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        for (double i = 0.0; i <= 1.0; i = i + 0.1) {
            String val = i + "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try {
                Thread.sleep(50);
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void newpassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newpassMouseEntered
        // TODO add your handling code here:
         newpass.setToolTipText("Enter a new Password");
        UIManager.put("ToolTip.background", new java.awt.Color(140,140,140));
        UIManager.put("ToolTip.foreground", new java.awt.Color(204,204,204));
        UIManager.put("ToolTip.font", new java.awt.Font("Segoe UI",1,12)); 
    }//GEN-LAST:event_newpassMouseEntered

    private void conpassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_conpassMouseEntered
        // TODO add your handling code here:
         conpass.setToolTipText("Confirm the password");
        UIManager.put("ToolTip.background", new java.awt.Color(140,140,140));
        UIManager.put("ToolTip.foreground", new java.awt.Color(204,204,204));
        UIManager.put("ToolTip.font", new java.awt.Font("Segoe UI",1,12)); 
    }//GEN-LAST:event_conpassMouseEntered

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
            java.util.logging.Logger.getLogger(ChangePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       java.awt.EventQueue.invokeLater(() -> {
            // Create an instance of the ChangePass class and pass the username to it
            ChangePass changePass = new ChangePass("username");
            // Set the form visible
            changePass.setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField conpass;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField newpass;
    // End of variables declaration//GEN-END:variables
}
