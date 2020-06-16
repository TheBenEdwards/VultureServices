/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vultureservices;

import java.util.Random;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Dad
 */
public class ManageTask extends javax.swing.JFrame {

    /**
     * Creates new form ManageTask
     */
    public ManageTask() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jtbUnassigned = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jbAssignedTask = new javax.swing.JButton();
        jlbUser = new javax.swing.JLabel();
        jlbWelcome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtbUnassigned.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Task ID", "Task", "Notes", "Time (Hours)", "Assigned To", "Date Assigned", "Completed", "Date Completed", "Time Used"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbUnassigned.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jtbUnassigned);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("All tasks unassigned are below");

        jbAssignedTask.setText("Randomly assign tasks");
        jbAssignedTask.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbAssignedTaskMouseClicked(evt);
            }
        });
        jbAssignedTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAssignedTaskActionPerformed(evt);
            }
        });

        jlbUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbUser.setText("jLabel1");
        jlbUser.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jlbWelcome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbWelcome.setText("Welcome");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbAssignedTask)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbWelcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbUser)
                .addGap(278, 278, 278)
                .addComponent(jLabel4)
                .addContainerGap(392, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlbUser)
                        .addComponent(jlbWelcome))
                    .addComponent(jLabel4))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(jButton1))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbAssignedTask)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbAssignedTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAssignedTaskActionPerformed
        
        
        String pattern =  "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        //System.out.println(date);
        
        
        
        int row = jtbUnassigned.getSelectedRow();
        String selection = jtbUnassigned.getModel().getValueAt(row, 0).toString();

        String names[] = {"Anita", "Mike", "Dave", "Luke"};
        Random nms = new Random();

        PreparedStatement ps;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vulture", "root", "24652066")) {
                String query = "UPDATE task SET assignedTo=?, date_assigned=? WHERE assignedTo IS NULL OR assignedTo ='Not assigned' AND task_id=" + selection;
                ps = con.prepareStatement(query);
                for (int i = names.length; i > 0; i--) {
                    int randomName = nms.nextInt(4);
                    ps.setString(1, names[randomName]);
                    ps.setString(2,date.toString());
                    ps.execute();

                }
                updateTable();
            }
            //updateTable();
            //setSize(800, 600);
        } catch (SQLException ex) {
            Logger.getLogger(ManageTask.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageTask.class.getName()).log(Level.SEVERE, null, ex);

        }


    }//GEN-LAST:event_jbAssignedTaskActionPerformed

    private void updateTable() {
        DefaultTableModel model = (DefaultTableModel) jtbUnassigned.getModel();
        model.setRowCount(0);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vulture", "root", "24652066")) {

                String query = "SELECT * FROM unassigned_tasks";
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    String task_id = rs.getString("task_id");
                    String task = rs.getString("task");
                    String notes = rs.getString("notes");
                    String time_needed = rs.getString("time_needed");
                    String assigned = rs.getString("assignedTo");
                    String dateAssigned =rs.getString("date_assigned");
                    String completed = rs.getString("completed");
                    model.addRow(new Object[]{task_id, task, notes, time_needed, assigned, dateAssigned, completed});
                    jtbUnassigned.setModel(model);
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagerHome.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jbAssignedTaskMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbAssignedTaskMouseClicked


    }//GEN-LAST:event_jbAssignedTaskMouseClicked

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
            java.util.logging.Logger.getLogger(ManageTask.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageTask.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageTask.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageTask.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageTask().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbAssignedTask;
    public javax.swing.JLabel jlbUser;
    public javax.swing.JLabel jlbWelcome;
    public javax.swing.JTable jtbUnassigned;
    // End of variables declaration//GEN-END:variables
}