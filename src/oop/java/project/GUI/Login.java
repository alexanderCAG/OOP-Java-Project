/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.java.project.GUI;

import Classe.Candidat;
import Classe.Employer;
import Classe.JobSeeker;
import static FonctionSQL.Connexion.Connexion1;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


/**
 *
 * @author alexa
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        setVisible(true);
        this.setLocationRelativeTo(null); // center of the screen
        clock();
        setVisible(true);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        UserName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lblClock = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("RECRUTEMENT AGENCY PROJECT");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("-");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oop/java/project/GUI/Image/alimentation.png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 332, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(26, 26, 26)
                .addComponent(jLabel6)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(20, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jPasswordField1.setBackground(new java.awt.Color(108, 122, 137));
        jPasswordField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
        });
        jPanel2.add(jPasswordField1);
        jPasswordField1.setBounds(630, 210, 370, 70);

        jButton1.setText("RESET");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(620, 320, 178, 48);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oop/java/project/GUI/Image/user.png"))); // NOI18N
        jPanel2.add(jLabel3);
        jLabel3.setBounds(460, 130, 24, 20);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oop/java/project/GUI/Image/lock.png"))); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(460, 230, 30, 32);

        UserName.setBackground(new java.awt.Color(108, 122, 137));
        UserName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        UserName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(UserName);
        UserName.setBounds(630, 110, 370, 70);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Password :");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(500, 230, 99, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText(" Username :");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(490, 120, 110, 40);

        jButton2.setText("CONNEXION");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(830, 320, 178, 48);

        lblClock.setFont(new java.awt.Font("Verdana Pro Cond Black", 1, 13)); // NOI18N
        lblClock.setText("Hello");
        jPanel2.add(lblClock);
        lblClock.setBounds(830, 30, 250, 50);

        jPanel3.setBackground(new java.awt.Color(102, 153, 255));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("click here to create a new account");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(jPanel3);
        jPanel3.setBounds(646, 420, 330, 40);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oop/java/project/GUI/Image/login.jpg"))); // NOI18N
        jLabel10.setText("Hello");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(0, 0, 1100, 540);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        
        Register reg = new Register();
        reg.setVisible(true);
        reg.pack();
        reg.setLocationRelativeTo(null);
        reg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
        
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        UserName.setText(null);
        jPasswordField1.setText(null);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
                Verificationcandidat();
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Verificationemployer();
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Verificationjobseeker();
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        /*String user = UserName.getText();
        String password = jPasswordField1.getText();
        
        if(user.contains("job") && password.contains("root"))
        {
            UserName.setText(null);
            jPasswordField1.setText(null);
            
            
            Job job = new Job();
            job.setVisible(true);
            job.pack();
            job.setLocationRelativeTo(null);
            job.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        }
        else if(user.contains("employeur") && password.contains("root"))
        {
            UserName.setText(null);
            jPasswordField1.setText(null);
            
            
            Employeur empl = new Employeur();
            empl.setVisible(true);
            empl.pack();
            empl.setLocationRelativeTo(null);
            empl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        }
        else if(user.contains("recruteur") && password.contains("root"))
        {
            UserName.setText(null);
            jPasswordField1.setText(null);
            
            
            Recruteur recru = new Recruteur();
            recru.setVisible(true);
            recru.pack();
            recru.setLocationRelativeTo(null);
            recru.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Mot de passe INCORECT", "Login Error", JOptionPane.ERROR_MESSAGE);
            UserName.setText(null);
            jPasswordField1.setText(null);
        }*/
        
  
       
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyPressed
        try {
            // TODO add your handling code here:
            Verificationcandidat();
            /*if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            {
            
            String user = UserName.getText();
            String password = jPasswordField1.getText();

            if(user.contains("job") && password.contains("root"))
            {
            String user = UserName.getText();
            String password = jPasswordField1.getText();
            
            if(user.equals("job") && password.equals("root"))
            {
            UserName.setText(null);
            jPasswordField1.setText(null);
            
            
            Job job = new Job();
            job.setVisible(true);
            job.pack();
            job.setLocationRelativeTo(null);
            job.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
            }
            else if(user.contains("employeur") && password.contains("root"))
            {
            }
            else if(user.equals("employeur") && password.equals("root"))
            {
            UserName.setText(null);
            jPasswordField1.setText(null);
            
            
            Employeur empl = new Employeur();
            empl.setVisible(true);
            empl.pack();
            empl.setLocationRelativeTo(null);
            empl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
            }
            else if(user.contains("recruteur") && password.contains("root"))
            {
            }
            else if(user.equals("recruteur") && password.equals("root"))
            {
            UserName.setText(null);
            jPasswordField1.setText(null);
            

            Recruteur recru = new Recruteur();
            recru.setVisible(true);
            recru.pack();
            recru.setLocationRelativeTo(null);
            recru.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
            }
            else
            {
            JOptionPane.showMessageDialog(null, "Mot de passe INCORECT", "Login Error", JOptionPane.ERROR_MESSAGE);
            UserName.setText(null);
            jPasswordField1.setText(null);
            }
            
            }*/
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jPasswordField1KeyPressed
    public void Verificationcandidat() throws SQLException{
        String user = UserName.getText();
        String password = jPasswordField1.getText();
        Connection conn = Connexion1();
        try{
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("Select * from candidat;");
        String email;
        String motdepasse;
        while(rs.next()){
            email=rs.getString(4);
            motdepasse=rs.getString(5);
            if(user.equals(email) && password.equals(motdepasse)){
                System.out.println("Correct new candidat");
                Candidat c= new Candidat(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6), rs.getString(7));
                Job job = new Job(c);
                job.setVisible(true);
                job.pack();
                job.setLocationRelativeTo(null);
                job.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.dispose();
            }
        }
        String sqlStatement = "";

        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Mot de passe INCORECT", "Login Error", JOptionPane.ERROR_MESSAGE);
            UserName.setText(null);
            jPasswordField1.setText(null);
        }
    }
    
    public void Verificationemployer() throws SQLException{
        String user = UserName.getText();
        String password = jPasswordField1.getText();
        Connection conn = Connexion1();
        try{
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("Select * from employer;");
        String email;
        String motdepasse;
        while(rs.next()){
            email=rs.getString(4);
            motdepasse=rs.getString(5);
            if(user.equals(email) && password.equals(motdepasse)){
                System.out.println("Correct employer");
                Employer e= new Employer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6), rs.getString(7), rs.getString(8));
                Employeur employeur = new Employeur(e);
                employeur.setVisible(true);
                employeur.pack();
                employeur.setLocationRelativeTo(null);
                employeur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.dispose();
            }
        }
        String sqlStatement = "";

        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Mot de passe INCORECT", "Login Error", JOptionPane.ERROR_MESSAGE);
            UserName.setText(null);
            jPasswordField1.setText(null);
        }
    }
    public void Verificationjobseeker() throws SQLException{
        String user = UserName.getText();
        String password = jPasswordField1.getText();
        Connection conn = Connexion1();
        try{
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("Select * from jobseeker;");
        String email;
        String motdepasse;
        while(rs.next()){
            email=rs.getString(4);
            motdepasse=rs.getString(5);
            if(user.equals(email) && password.equals(motdepasse)){
                System.out.println("Correct jobseeker");
                JobSeeker j= new JobSeeker(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6), rs.getString(7));
                System.out.println("Correct jobseeker");
                Recruteur recruteur = new Recruteur(j);
                recruteur.setVisible(true);
                recruteur.pack();
                recruteur.setLocationRelativeTo(null);
                recruteur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.dispose();
            }
        }
        String sqlStatement = "";

        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Mot de passe INCORECT", "Login Error", JOptionPane.ERROR_MESSAGE);
            UserName.setText(null);
            jPasswordField1.setText(null);
        }
    }
    public void clock(){
        Thread clock=new Thread(){
            @Override
            public void run(){
                try{
                    for(;;){
                    Calendar cal=new GregorianCalendar();
                    int day=cal.get(Calendar.DAY_OF_MONTH);
                    int month=cal.get(Calendar.MONTH);
                    int year=cal.get(Calendar.YEAR);
                    int second=cal.get(Calendar.SECOND);
                    int minute=cal.get(Calendar.MINUTE);
                    int hour=cal.get(Calendar.HOUR);
                    if(minute<10){
                        if(second<10){
                            lblClock.setText("Hour: " + hour + ":0" + minute + ":0" + second + "  " + "Date: " + day + "/" + (month+1) + "/" + year);
                        }
                        else{
                            lblClock.setText("Hour: " + hour + ":0" + minute + ":" + second + "  " + "Date: " + day + "/" + (month+1) + "/" + year);
                        }
                    }
                    else{
                        if(second<10){
                            lblClock.setText("Hour: " + hour + ":" + minute + ":0" + second + "  " + "Date: " + day + "/" + (month+1) + "/" + year);
                        }
                        else{
                            lblClock.setText("Hour: " + hour + ":" + minute + ":" + second + "  " + "Date: " + day + "/" + (month+1) + "/" + year);
                        }
                    }
                    sleep(1000);
                    }
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        clock.start();
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField UserName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JLabel lblClock;
    // End of variables declaration//GEN-END:variables
}
