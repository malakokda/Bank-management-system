/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fproject;

import javax.swing.JOptionPane;

/**
 *
 * @author malak
 */
public class withdraw extends javax.swing.JFrame {

    /**
     * Creates new form withdraw
     */
    public withdraw() {
        initComponents();
     this.setLocationRelativeTo(null);
        
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
        jLabel3 = new javax.swing.JLabel();
        accnumtowd = new javax.swing.JTextField();
        amounttowd = new javax.swing.JTextField();
        withdrawbutton = new javax.swing.JButton();
        backtohome = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("WITHDRAW");

        jLabel2.setText("Account number ");

        jLabel3.setText("Amount");

        accnumtowd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accnumtowdActionPerformed(evt);
            }
        });

        withdrawbutton.setBackground(new java.awt.Color(204, 255, 255));
        withdrawbutton.setText("Withdraw");
        withdrawbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawbuttonActionPerformed(evt);
            }
        });

        backtohome.setText("Back to Home");
        backtohome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backtohomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(withdrawbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(backtohome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(155, 155, 155))
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(accnumtowd, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(amounttowd)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accnumtowd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(amounttowd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(withdrawbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backtohome)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void accnumtowdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accnumtowdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accnumtowdActionPerformed

    private void withdrawbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawbuttonActionPerformed
String a = accnumtowd.getText();
String b = amounttowd.getText();
 if (a.isBlank()) {//is Blanck returns true if the string entered is empty or have space in it 
                JOptionPane.showMessageDialog(null, "Please Enter an account number ","Error",JOptionPane.ERROR_MESSAGE);
            }
            if (b.isBlank()) {//is Blanck returns true if the string entered is empty or have space in it 
                JOptionPane.showMessageDialog(null, "Please Enter the amount to Withdraw","Error",JOptionPane.ERROR_MESSAGE);
            }
            int x= Account.withdraw(a,b);
             if(x==0){JOptionPane.showMessageDialog(null, "Withdraw done sucesfully!"); }
              if(x==10){JOptionPane.showMessageDialog(null, "Withdraw done sucesfully! and a 10 $ fee was applied"); }
            if (x == 1) {
                JOptionPane.showMessageDialog(null, "Wrong Account number!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if(x==2){JOptionPane.showMessageDialog(null, "The amount entered is more than the limit (10,000$)","Error",JOptionPane.ERROR_MESSAGE);}
           if(x==3){JOptionPane.showMessageDialog(null, "The amount value is wrong","Error",JOptionPane.ERROR_MESSAGE);}
            if(x==4){JOptionPane.showMessageDialog(null, "The amount entered is more than your balance!","Error",JOptionPane.ERROR_MESSAGE);}
            if(x==5){JOptionPane.showMessageDialog(null, "Error found Exception","Error",JOptionPane.ERROR_MESSAGE);}
    }//GEN-LAST:event_withdrawbuttonActionPerformed

    private void backtohomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backtohomeActionPerformed
new home().setVisible(true);
                this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_backtohomeActionPerformed

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
            java.util.logging.Logger.getLogger(withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new withdraw().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accnumtowd;
    private javax.swing.JTextField amounttowd;
    private javax.swing.JButton backtohome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton withdrawbutton;
    // End of variables declaration//GEN-END:variables
}
