/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package indexpage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author reena
 */
public class NewCustomer extends javax.swing.JFrame {
int idno;
    /**
     * Creates new form NewCustomer
     */
    public NewCustomer() {
        initComponents();
        setSize(800,500);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        add = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        cty = new javax.swing.JTextField();
        nm = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jbtnSave = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        custid = new javax.swing.JTextField();
        Update = new javax.swing.JButton();

        jTextField1.setText("Customer Name");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        add.setText("Customer Address");
        getContentPane().add(add);
        add.setBounds(90, 110, 182, 46);

        phone.setText("Customer Phone");
        phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneActionPerformed(evt);
            }
        });
        getContentPane().add(phone);
        phone.setBounds(90, 170, 182, 46);

        cty.setText("Customer City");
        getContentPane().add(cty);
        cty.setBounds(90, 230, 182, 46);

        nm.setText("Customer Name");
        nm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nmActionPerformed(evt);
            }
        });
        getContentPane().add(nm);
        nm.setBounds(90, 50, 182, 46);

        jButton1.setText("Home");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(13, 17, 72, 22);

        jbtnSave.setText("Save");
        jbtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnSave);
        jbtnSave.setBounds(190, 290, 72, 22);

        jLabel1.setText("Customer.Id");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(330, 20, 65, 16);

        custid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custidActionPerformed(evt);
            }
        });
        getContentPane().add(custid);
        custid.setBounds(420, 20, 100, 22);

        Update.setText("update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        getContentPane().add(Update);
        Update.setBounds(420, 60, 72, 22);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneActionPerformed
        
    }//GEN-LAST:event_phoneActionPerformed

    private void nmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nmActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    this.setVisible(false);
        Masterpage.main(new String[2]);    // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveActionPerformed
      String name = nm.getText();
      String address = add.getText();
       String mobile = phone.getText();
        String city = cty.getText();
        try{
            Connection con = InitConnection.initConn();
            PreparedStatement ps = con.prepareStatement("update customer set Name=?, Address=?, Mobile_no=?, City=? where Id = "+idno);
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, mobile);
            ps.setString(4,city);
            
            int x= ps.executeUpdate();
            JOptionPane.showMessageDialog(null , "data updated sucessfully");
        }
        catch(Exception e)
        {
            System.out.print(e);
        }

    }//GEN-LAST:event_jbtnSaveActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
         String s =custid.getText();
         idno= Integer.parseInt(s);
         
         try{
             Connection con = InitConnection.initConn();
             Statement stm = con.createStatement();
             ResultSet rs= stm.executeQuery("select *from customer where ID = "+idno);
             if(rs.next())
             {
                 nm.setText(rs.getString(2)+"");
                 add.setText(rs.getString(4)+"");
                 phone.setText(rs.getString(5)+"");
                 cty.setText(rs.getString(3)+"");
                 
             }
         }
         catch(Exception e){
             System.out.print(e);
         }
    }//GEN-LAST:event_UpdateActionPerformed

    private void custidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_custidActionPerformed

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
            java.util.logging.Logger.getLogger(NewCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Update;
    private javax.swing.JTextField add;
    private javax.swing.JTextField cty;
    private javax.swing.JTextField custid;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jbtnSave;
    private javax.swing.JTextField nm;
    private javax.swing.JTextField phone;
    // End of variables declaration//GEN-END:variables
}
