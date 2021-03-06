/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vultureservices;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matty
 */
public class ManagerAlert extends javax.swing.JFrame {

    /**
     * Creates new form ManagerSuspendAlert
     */
    public ManagerAlert() {
        initComponents();
        updateTaskTable();

    }

    private void updateTaskTable() {
        DefaultTableModel model = (DefaultTableModel) jtbWarningTask.getModel();
        model.setRowCount(0);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vulture", "root", "24652066")) {
                String query = "SELECT * FROM task WHERE date_assigned IS NOT NULL";
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                Date dateToday = new Date(System.currentTimeMillis());
                while (rs.next()) {
                    String taskID = rs.getString("task_id");
                    String taskName = rs.getString("task");
                    String jobID = rs.getString("job_id");
                    String notes = rs.getString("notes");
                    String assignedTo = rs.getString("assignedTo");
                    Date dateAssigned = rs.getDate("date_assigned");
                    String timeNeeded = rs.getString("emp_id");
                    String completed = rs.getString("completed");
                        if(dateToday.after(dateAssigned) && !completed.equals("Yes")) {
                            model.addRow(new Object[]{completed, taskID, taskName, notes, timeNeeded, assignedTo, dateAssigned, jobID,});
                            jtbWarningTask.setModel(model);
                        }
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(ManageUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageUser.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtSignout = new javax.swing.JButton();
        jlbWelcome = new javax.swing.JLabel();
        jlbUser = new javax.swing.JLabel();
        jbtMenu1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbWarningTask = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbtSignout.setText("Signout");
        jbtSignout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSignoutActionPerformed(evt);
            }
        });

        jlbWelcome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbWelcome.setText("Welcome");

        jlbUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbUser.setText("jLabel1");
        jlbUser.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jbtMenu1.setText("Menu");
        jbtMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtMenu1ActionPerformed(evt);
            }
        });

        jtbWarningTask.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Completed", "Task ID", "Task Name", "Notes", "Time Needed (Hours)", "Assigned To", "Date Assigned", "Job ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbWarningTask.setRequestFocusEnabled(false);
        jtbWarningTask.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbWarningTaskMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtbWarningTask);
        if (jtbWarningTask.getColumnModel().getColumnCount() > 0) {
            jtbWarningTask.getColumnModel().getColumn(1).setMinWidth(80);
            jtbWarningTask.getColumnModel().getColumn(1).setPreferredWidth(80);
            jtbWarningTask.getColumnModel().getColumn(1).setMaxWidth(80);
            jtbWarningTask.getColumnModel().getColumn(2).setMinWidth(160);
            jtbWarningTask.getColumnModel().getColumn(2).setPreferredWidth(160);
            jtbWarningTask.getColumnModel().getColumn(2).setMaxWidth(160);
            jtbWarningTask.getColumnModel().getColumn(4).setMinWidth(130);
            jtbWarningTask.getColumnModel().getColumn(4).setPreferredWidth(130);
            jtbWarningTask.getColumnModel().getColumn(4).setMaxWidth(130);
            jtbWarningTask.getColumnModel().getColumn(5).setMinWidth(100);
            jtbWarningTask.getColumnModel().getColumn(5).setPreferredWidth(100);
            jtbWarningTask.getColumnModel().getColumn(5).setMaxWidth(100);
            jtbWarningTask.getColumnModel().getColumn(6).setMinWidth(140);
            jtbWarningTask.getColumnModel().getColumn(6).setPreferredWidth(140);
            jtbWarningTask.getColumnModel().getColumn(6).setMaxWidth(140);
            jtbWarningTask.getColumnModel().getColumn(7).setMinWidth(80);
            jtbWarningTask.getColumnModel().getColumn(7).setPreferredWidth(80);
            jtbWarningTask.getColumnModel().getColumn(7).setMaxWidth(80);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlbWelcome)
                                .addGap(6, 6, 6)
                                .addComponent(jlbUser))
                            .addComponent(jbtSignout))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtMenu1))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1088, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbWelcome)
                            .addComponent(jlbUser))
                        .addGap(14, 14, 14)
                        .addComponent(jbtSignout))
                    .addComponent(jbtMenu1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtSignoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSignoutActionPerformed
        dispose();
        Login lf = new Login();
        lf.setVisible(true);
        lf.pack();
        lf.setSize(800, 600);
        lf.setLocationRelativeTo(null);
    }//GEN-LAST:event_jbtSignoutActionPerformed

    private void jbtMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtMenu1ActionPerformed

        String user = jlbUser.getText();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vulture", "root", "24652066")) {
                String query = "SELECT * FROM employees WHERE emp_name =?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, user);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    String role = rs.getString("emp_role");
                    dispose();

                    if (role.equals("Technician")) {
                        TechnicianHome tf = new TechnicianHome();
                        tf.setVisible(true);
                        tf.setSize(800, 600);
                        tf.setLocationRelativeTo(null);
                        tf.jlbUser.setText(user);
                    }

                    if (role.equals("Customer Services")) {
                        CSHome cf = new CSHome();
                        cf.setVisible(true);
                        cf.setSize(800, 600);
                        cf.setLocationRelativeTo(null);
                        cf.jlbUser.setText(user);
                    }

                    if (role.equals("Finance")) {
                        FinanceHome ff = new FinanceHome();
                        ff.setVisible(true);
                        ff.setSize(800, 600);
                        ff.setLocationRelativeTo(null);
                        ff.jlbUser.setText(user);
                    }

                    if (role.equals("Human Resources")) {
                        CSHome hf = new CSHome();
                        hf.setVisible(true);
                        hf.setSize(800, 600);
                        hf.setLocationRelativeTo(null);
                        hf.jlbUser.setText(user);
                    }
                    if (role.equals("Manager") || role.equals("IT Services")) {
                        ManagerHome mf = new ManagerHome();
                        mf.setVisible(true);
                        mf.setSize(800, 600);
                        mf.setLocationRelativeTo(null);
                        mf.jlbUser.setText(user);
                    }

                }
            } catch (SQLException ex) {
                Logger.getLogger(ManageUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtMenu1ActionPerformed

    private void jtbWarningTaskMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbWarningTaskMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbWarningTaskMouseClicked

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
            java.util.logging.Logger.getLogger(ManagerAlert.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerAlert.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerAlert.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerAlert.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerAlert().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbtMenu1;
    private javax.swing.JButton jbtSignout;
    public javax.swing.JLabel jlbUser;
    public javax.swing.JLabel jlbWelcome;
    private javax.swing.JTable jtbWarningTask;
    // End of variables declaration//GEN-END:variables

}
