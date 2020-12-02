/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.java.project.GUI;

import Classe.Candidat;
import static FonctionSQL.Connexion.Connexion1;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;


/**
 *
 * @author alexa
 */
public class Job extends javax.swing.JFrame {

    /**
     * Creates new form Job
     */
    private Candidat c;
    private String[] listJob;
    public Job() {
        initComponents();
        this.setLocationRelativeTo(null); // center of the screen
        //jTextField1.setBackground(new Color(0,102,153,120));
        
//        jButton2.validate();
//        jComboBox1.validate();
//        jComboBox3.validate();
//        jDateChooser1.validate();
//        jLabel1.validate();
//        jLabel10.validate();
//        jLabel2.validate();
//        jLabel3.validate();
//        jLabel4.validate();
//        jLabel5.validate();
//        jLabel6.validate();
//        jLabel7.validate();
//        jLabel8.validate();
//        jLabel9.validate();
//        jPanel1.validate();
//        jPanel2.validate();
//        jPanel3.validate();
//        jSeparator1.validate();
//        jTextField1.validate();
    }
    public Job(Candidat c) throws SQLException {
        this.c=c;
        initComponents();
        Affichagejob();
        this.setLocationRelativeTo(null); // center of the screen
        //jTextField1.setBackground(new Color(0,102,153,120));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 153));
        jLabel2.setText("DEMANDEUR");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(80, 20, 240, 60);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 153));
        jLabel3.setText(" D'EMPLOIS");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(90, 80, 190, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText(c.getLastname() + " " + c.getFirstname());
        jPanel1.add(jLabel4);
        jLabel4.setBounds(360, 30, 490, 90);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oop/java/project/GUI/Image/deconnection.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5);
        jLabel5.setBounds(1020, 40, 60, 60);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(870, 82, 140, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Déconnexion");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(870, 50, 140, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oop/java/project/GUI/Image/cercle2.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(60, 0, 250, 150);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oop/java/project/GUI/Image/job.jpg"))); // NOI18N
        jPanel2.add(jLabel8);
        jLabel8.setBounds(0, 0, 1100, 500);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 150, 1100, 500);

        jPanel3.add(jPanel1);
        jPanel1.setBounds(0, 0, 1100, 169);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Secrétaire", "Informaticien", "Medecin" }));
        jPanel3.add(jComboBox1);
        jComboBox1.setBounds(60, 210, 247, 70);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Etudiant", "BAC +3", "BAC +5" }));
        jPanel3.add(jComboBox3);
        jComboBox3.setBounds(410, 210, 247, 70);

        jButton2.setText("VALIDER");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);
        jButton2.setBounds(418, 368, 231, 77);
        jPanel3.add(jDateChooser1);
        jDateChooser1.setBounds(770, 210, 250, 70);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Métier", "Statut", "Date de début"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(660, 270, 452, 402);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oop/java/project/GUI/Image/job.jpg"))); // NOI18N
        jPanel3.add(jLabel7);
        jLabel7.setBounds(0, 150, 1100, 500);
        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(630, 350, 2, 2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom", "Prenom"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jPanel3.add(jScrollPane3);
        jScrollPane3.setBounds(130, 460, 460, 120);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1097, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        
        String selectdate = ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
        //jLabel9.setText("");
        //jTextField1.setText(selectdate);      
        
    }//GEN-LAST:event_jButton2MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        
        Login log = new Login();
        log.setVisible(true);
        log.pack();
        log.setLocationRelativeTo(null);
        log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
        
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
    public int Nombrejob() throws SQLException{
        
        Connection conn=Connexion1();
        int nombrejob = 0;
        try{
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("Select count(namejob) from job;");
        while(rs.next()){
            nombrejob=rs.getInt(1);
            System.out.println("Hello " + nombrejob);
        }
        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Mot de passe INCORECT", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
        return nombrejob;
    }
    public void Affichagejob() throws SQLException{
        int nombrejob=Nombrejob();
        String[] listJob=new String[nombrejob];
        Connection conn=Connexion1();
        try{
        Statement stmt = conn.createStatement();
        int i=0;
        ResultSet rs = stmt.executeQuery("Select * from job;");
        while(rs.next()){
            String namejob=rs.getString(1);
            System.out.println("Coucou " + namejob);
            listJob[i]=namejob;
            System.out.println(listJob[i]);
            i+=1;
        }
        String sqlStatement = "";
        this.listJob=listJob;
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(listJob));

        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Mot de passe INCORECT", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }
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
            java.util.logging.Logger.getLogger(Job.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Job.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Job.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Job.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Job().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
