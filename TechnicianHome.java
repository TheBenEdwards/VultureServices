/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vultureservices;

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
public class TechnicianHome extends javax.swing.JFrame {

    /**
     * Creates new form TechnicianHome
     */
    public TechnicianHome() {
        initComponents();
        setSize(800,600);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlbTitle = new javax.swing.JLabel();
        jbtAddJob = new javax.swing.JButton();
        jbtAllocation = new javax.swing.JButton();
        jlbWelcome = new javax.swing.JLabel();
        jbtViewJob = new javax.swing.JButton();
        jbtSignout = new javax.swing.JButton();
        jlbJobs = new javax.swing.JLabel();
        jlbUser = new javax.swing.JLabel();
        jbtChangePass = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlbTitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbTitle.setText("Menu");

        jbtAddJob.setText("Add Job");
        jbtAddJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAddJobActionPerformed(evt);
            }
        });

        jbtAllocation.setText("Daily Tasks");
        jbtAllocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAllocationActionPerformed(evt);
            }
        });

        jlbWelcome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbWelcome.setText("Welcome");

        jbtViewJob.setText("Edit Job");
        jbtViewJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtViewJobActionPerformed(evt);
            }
        });

        jbtSignout.setText("Signout");
        jbtSignout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSignoutActionPerformed(evt);
            }
        });

        jlbJobs.setText("Jobs");

        jlbUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbUser.setText("jLabel1");
        jlbUser.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jbtChangePass.setText("Change Password");
        jbtChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtChangePassActionPerformed(evt);
            }
        });

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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlbUser)
                                .addGap(273, 273, 273)
                                .addComponent(jlbTitle))
                            .addComponent(jbtSignout))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 243, Short.MAX_VALUE)
                        .addComponent(jbtChangePass))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbJobs)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbtAddJob, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtViewJob, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtAllocation, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbTitle)
                            .addComponent(jlbWelcome)
                            .addComponent(jlbUser))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtSignout))
                    .addComponent(jbtChangePass))
                .addGap(21, 21, 21)
                .addComponent(jlbJobs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtViewJob, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtAddJob, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtAllocation, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(396, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtAddJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAddJobActionPerformed

        dispose();
        AddJob lf = new AddJob();
        lf.setVisible(true);
        lf.pack();
        lf.setLocationRelativeTo(null);
        String user = jlbUser.getText();
        lf.jlbUser.setText(user);
        
    }//GEN-LAST:event_jbtAddJobActionPerformed

    private void jbtAllocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAllocationActionPerformed

        dispose();
        dailyTask dt = new dailyTask();
        dt.setVisible(true);
        String user = jlbUser.getText();
        dt.jlbUser.setText(user);
        dt.pack();
        // dt.setSize(800, 600);
        dt.setLocationRelativeTo(null);

        DefaultTableModel model = (DefaultTableModel) dt.jtbTask.getModel();
        model.setRowCount(0);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vulture", "root", "24652066")) {

                if (user.equals("Anita")) {

                    String query = "SELECT * FROM anita_tasks";
                    String query2 = "SELECT * FROM monthly_hours_anita";

                    PreparedStatement ps = con.prepareStatement(query);
                    PreparedStatement ps2 = con.prepareStatement(query2);

                    // ps2.setString(0, dt.jtMonthlyHours.getText());
                    ResultSet rs = ps.executeQuery();
                    ResultSet rs2 = ps2.executeQuery();

                    while (rs.next()) {
                        String task = rs.getString("task");
                        String notes = rs.getString("notes");
                        String time_needed = rs.getString("time_needed");
                        String assigned = rs.getString("assignedTo");
                        String completed = rs.getString("completed");
                        model.addRow(new Object[]{task, notes, time_needed, assigned, completed});
                        dt.jtbTask.setModel(model);
                    }

                    while (rs2.next()) {

                        dt.jtMonthlyHours.setText(rs2.getString("Total Hours"));

                    }

                }
                if (user.equals("Luke")) {
                    String query = "SELECT * FROM luke_tasks";
                    String query2 = "SELECT * FROM monthly_hours_Luke";

                    PreparedStatement ps = con.prepareStatement(query);
                    PreparedStatement ps2 = con.prepareStatement(query2);

                    ResultSet rs = ps.executeQuery();
                    ResultSet rs2 = ps2.executeQuery();

                    while (rs.next()) {
                        String task = rs.getString("task");
                        String notes = rs.getString("notes");
                        String time_needed = rs.getString("time_needed");
                        String assigned = rs.getString("assignedTo");
                        String completed = rs.getString("completed");
                        model.addRow(new Object[]{task, notes, time_needed, assigned, completed});
                        dt.jtbTask.setModel(model);
                    }

                    while (rs2.next()) {

                        dt.jtMonthlyHours.setText(rs2.getString("Total Hours"));

                    }

                }
                if (user.equals("Dave")) {
                    String query = "SELECT * FROM dave_tasks";
                    String query2 = "SELECT * FROM monthly_hours_Dave";

                    PreparedStatement ps = con.prepareStatement(query);
                    PreparedStatement ps2 = con.prepareStatement(query2);

                    ResultSet rs = ps.executeQuery();
                    ResultSet rs2 = ps2.executeQuery();

                    while (rs.next()) {
                        String task = rs.getString("task");
                        String notes = rs.getString("notes");
                        String time_needed = rs.getString("time_needed");
                        String assigned = rs.getString("assignedTo");
                        String completed = rs.getString("completed");
                        model.addRow(new Object[]{task, notes, time_needed, assigned, completed});
                        dt.jtbTask.setModel(model);
                    }

                    while (rs2.next()) {

                        dt.jtMonthlyHours.setText(rs2.getString("Total Hours"));

                    }

                }
                if (user.equals("Mike")) {
                    String query = "SELECT * FROM Mike_tasks";
                    String query2 = "SELECT * FROM monthly_hours_Mike";

                    PreparedStatement ps = con.prepareStatement(query);
                    PreparedStatement ps2 = con.prepareStatement(query2);

                    ResultSet rs = ps.executeQuery();
                    ResultSet rs2 = ps2.executeQuery();

                    while (rs.next()) {
                        String task = rs.getString("task");
                        String notes = rs.getString("notes");
                        String time_needed = rs.getString("time_needed");
                        String assigned = rs.getString("assignedTo");
                        String completed = rs.getString("completed");
                        model.addRow(new Object[]{task, notes, time_needed, assigned, completed});
                        dt.jtbTask.setModel(model);
                    }

                    while (rs2.next()) {

                        dt.jtMonthlyHours.setText(rs2.getString("Total Hours"));

                    }

                }

            } catch (SQLException ex) {
                Logger.getLogger(dailyTask.class.getName()).log(Level.SEVERE, null, ex);

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(dailyTask.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jbtAllocationActionPerformed

    private void jbtViewJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtViewJobActionPerformed

        dispose();
        EditJob lf = new EditJob();
        lf.setVisible(true);
        lf.pack();
        lf.setLocationRelativeTo(null);
        String user = jlbUser.getText();
        lf.jlbUser.setText(user);
        
    }//GEN-LAST:event_jbtViewJobActionPerformed

    private void jbtSignoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSignoutActionPerformed
        dispose();
        Login lf = new Login();
        lf.setVisible(true);
        lf.pack();
        lf.setSize(800, 600);
        lf.setLocationRelativeTo(null);
    }//GEN-LAST:event_jbtSignoutActionPerformed

    private void jbtChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtChangePassActionPerformed
        dispose();
        ChangePassword cp = new ChangePassword();
        cp.setVisible(true);
        cp.pack();
        cp.setLocationRelativeTo(null);
        cp.setSize(800, 600);
        String user = jlbUser.getText();
        cp.jlbUser.setText(user);
    }//GEN-LAST:event_jbtChangePassActionPerformed

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
            java.util.logging.Logger.getLogger(TechnicianHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TechnicianHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TechnicianHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TechnicianHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TechnicianHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtAddJob;
    private javax.swing.JButton jbtAllocation;
    private javax.swing.JButton jbtChangePass;
    private javax.swing.JButton jbtSignout;
    private javax.swing.JButton jbtViewJob;
    private javax.swing.JLabel jlbJobs;
    private javax.swing.JLabel jlbTitle;
    public javax.swing.JLabel jlbUser;
    public javax.swing.JLabel jlbWelcome;
    // End of variables declaration//GEN-END:variables
}
