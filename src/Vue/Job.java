
package Vue;


/*Nos imports*/
import Model.Candidat;
import Controller.*;
import static DAO.Connexion.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;



public class Job extends javax.swing.JFrame {

    
    public Candidat c;
    private String[] listJob;
    private ArrayList listdemande;
    
    /*Premier Constructeur*/
    public Job() {
        initComponents();
        this.setLocationRelativeTo(null); // center of the screen
        
        //Cache un Panel
        jPanel4.setVisible(false);
        jPanel6.setVisible(false);
    }
    
    /*Deuxieme Constructeur*/
    public Job(Candidat c) throws SQLException {
        this.c=c;
        ArrayList listdemande =new ArrayList();
        initComponents();
        Affichagejob();
        LireBasededonneeDemandeEmploi();
        this.setLocationRelativeTo(null); // center of the screen
        
        //Cache un Panel
        jPanel4.setVisible(false);
        jPanel6.setVisible(false);
        
        //Definir la transparence
        jPanel5.setBackground(new Color(0,0,0,0));
        
        //Defini les ActionListenner
        jButton2.addActionListener(new ListedemandeEmploi(this, c));
        jButton1.addActionListener(new SupprimerLigneTableau(this));
    }

    
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
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable(){
            public boolean isCellEditable(int d, int c){
                return false;
            }
        };
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

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

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/deconnection.png"))); // NOI18N
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cercle2.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(60, 0, 250, 150);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/job.jpg"))); // NOI18N
        jPanel2.add(jLabel8);
        jLabel8.setBounds(0, 0, 1100, 500);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 150, 1100, 500);

        jPanel3.add(jPanel1);
        jPanel1.setBounds(0, 0, 1100, 169);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/modif.png"))); // NOI18N
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel10);
        jLabel10.setBounds(10, 170, 32, 40);

        jTextField2.setForeground(new java.awt.Color(0, 102, 153));

        jButton3.setText("ok");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField3.setForeground(new java.awt.Color(0, 102, 153));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.add(jPanel4);
        jPanel4.setBounds(50, 170, 250, 40);

        jPanel5.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Sélectionnez une ligne pour supprimer");
        jPanel5.add(jLabel9);
        jLabel9.setBounds(790, 210, 240, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Secrétaire", "Informaticien", "Medecin" }));
        jPanel5.add(jComboBox1);
        jComboBox1.setBounds(60, 10, 180, 60);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Etudiant", "BAC +3", "BAC +5" }));
        jPanel5.add(jComboBox3);
        jComboBox3.setBounds(290, 10, 190, 60);
        jPanel5.add(jDateChooser1);
        jDateChooser1.setBounds(510, 10, 210, 60);

        jButton2.setText("VALIDER");
        jPanel5.add(jButton2);
        jButton2.setBounds(290, 90, 190, 50);

        jButton1.setText("Supprimer");
        jPanel5.add(jButton1);
        jButton1.setBounds(830, 270, 170, 50);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Métier", "Statut", "Date de début"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel5.add(jScrollPane2);
        jScrollPane2.setBounds(60, 160, 670, 250);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1060, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel6);
        jPanel6.setBounds(0, 0, 1060, 420);
        jPanel5.add(jLabel11);
        jLabel11.setBounds(260, 180, 460, 30);

        jPanel3.add(jPanel5);
        jPanel5.setBounds(20, 220, 1060, 420);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/job.jpg"))); // NOI18N
        jPanel3.add(jLabel7);
        jLabel7.setBounds(0, 150, 1100, 500);

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

    
    /*Permet de repartir sur la page Login*/
    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        
        Login log = new Login();
        log.setVisible(true);
        log.pack();
        log.setLocationRelativeTo(null);
        log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
        
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        jPanel4.setBackground(new Color(0,0,0,0));
        jPanel4.setVisible(true);
        
        jTextField3.setText(c.getLastname());
        jTextField2.setText(c.getFirstname());
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        try{                                         
            
            Connection conn = Connexion1();
            try{
                Statement stmt = conn.createStatement();
                stmt.executeUpdate("UPDATE `Company`.candidat SET `lastnamecan`='" + jTextField3.getText() + "' , `firstnamecan`='" + jTextField2.getText() + "' WHERE `idcan`=" + c.getId() + ";");
                
                conn.close();
            }catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            
            c.setLastname(jTextField3.getText());
            c.setFirstname(jTextField2.getText());
            jLabel4.setText(c.getLastname() + " " + c.getFirstname());
            jPanel4.setVisible(false);
            
        }catch (SQLException ex) {
            Logger.getLogger(Job.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    
    /*Cette methode permet de compter le nombre de job dans la base de donnee company*/
    public int Nombrejob() throws SQLException{
        
        Connection conn=Connexion1();
        int nombrejob = 0;
        try{
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("Select count(namejob) from job;");
        while(rs.next()){
            nombrejob=rs.getInt(1);
        }
        conn.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "La liste des nombres de jobs ne fonctionne pas", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
        return nombrejob;//Ce nombre est envoye a la methode affichagejob qui va cree un tableau
    }
    
    /*Cette methode permet d'afficher les la liste des jobs*/
    public void Affichagejob() throws SQLException{
        int nombrejob=Nombrejob();
        String[] listJob=new String[nombrejob];//le tableau aura le nombre de colonnes necessaires
        Connection conn=Connexion1();
        try{
        Statement stmt = conn.createStatement();
        int i=0;
        ResultSet rs = stmt.executeQuery("Select * from job;");
        while(rs.next()){
            String namejob=rs.getString(1);
            listJob[i]=namejob;
            i+=1;
        }
        String sqlStatement = "";
        this.listJob=listJob;//on obtient la liste de job final
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(listJob));

        conn.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "L'affichage des jobs ne fonctionne pas", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /*Cette methode permet d'afficher sur un jComboBox la liste de toutes les demandes qu'a fait l' utilisateur connecte(le candidat)*/
    public void LireBasededonneeDemandeEmploi() throws SQLException{
        Connection conn=Connexion1();
        DefaultTableModel tab = (DefaultTableModel) jTable2.getModel();
        try{
        Statement stmt = conn.createStatement();
        int i=0;
        ResultSet rs = stmt.executeQuery("Select * from DemandeEmploi where idcan='" + c.getId() + "';");
        while(rs.next()){
            String Metier=rs.getString(3);
            String Statut=rs.getString(4);
            String Date=rs.getString(5);
            String data[] = {Metier,Statut,Date};
            tab.addRow(data);
        }
        String sqlStatement = "";
        this.listJob=listJob;
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(listJob));//affichage de la liste dans le jcomboBox

        conn.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "La lecture des demandes d'emploie ne fonctionne pas", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void Acceptation(){
        Connection conn=Connexion1();
        try{
        Statement stmt = conn.createStatement();
        int i=0;
        ResultSet rs = stmt.executeQuery("Select firstname, lastname, metier, datedebut from demandeemploi natural join employeur where selectionne!='' and idcan='" + c.getId() + "';");
        while(rs.next()){
            String firstname=rs.getString(0);
            String lastname=rs.getString(1);
            String metier=rs.getString(2);
            String datedebut=rs.getString(3);
            
        }
        String sqlStatement = "";
        this.listJob=listJob;//on obtient la liste de job final
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(listJob));

        conn.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "L'affichage des jobs ne fonctionne pas", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    public javax.swing.JComboBox jComboBox1;
    public javax.swing.JComboBox jComboBox3;
    public com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
