
package Vue;


/*Nos imports*/
import Model.Candidat;
import Controller.*;
import static DAO.Connexion.*;
import java.sql.*;
import java.util.*;
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
    }
    
    /*Deuxieme Constructeur*/
    public Job(Candidat c) throws SQLException {
        this.c=c;
        ArrayList listdemande =new ArrayList();
        initComponents();
        Affichagejob();
        LireBasededonneeDemandeEmploi();
        this.setLocationRelativeTo(null); // center of the screen
        
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
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable(){
            public boolean isCellEditable(int d, int c){
                return false;
            }
        };
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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Secrétaire", "Informaticien", "Medecin" }));
        jPanel3.add(jComboBox1);
        jComboBox1.setBounds(60, 210, 180, 60);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Etudiant", "BAC +3", "BAC +5" }));
        jPanel3.add(jComboBox3);
        jComboBox3.setBounds(290, 210, 190, 60);

        jButton1.setText("Supprimer");
        jPanel3.add(jButton1);
        jButton1.setBounds(840, 460, 170, 50);

        jButton2.setText("VALIDER");
        jPanel3.add(jButton2);
        jButton2.setBounds(290, 310, 190, 50);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Sélectionnez une ligne pour supprimer");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(800, 410, 240, 30);
        jPanel3.add(jDateChooser1);
        jDateChooser1.setBounds(520, 210, 210, 60);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Métier", "Statut", "Date de début"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(60, 380, 670, 250);

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
            JOptionPane.showMessageDialog(null, "Mot de passe INCORECT", "Login Error", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "Mot de passe INCORECT", "Login Error", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "Mot de passe INCORECT", "Login Error", JOptionPane.ERROR_MESSAGE);
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
    public javax.swing.JComboBox jComboBox1;
    public javax.swing.JComboBox jComboBox3;
    public com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
