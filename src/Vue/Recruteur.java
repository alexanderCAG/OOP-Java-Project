
package Vue;

/*Nos imports*/
import Model.Recruiter;
import Controller.*;
import static DAO.Connexion.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class Recruteur extends javax.swing.JFrame {

    
    public Recruiter r;
    public String[] listJob;
    
    /*Premier Constructeur*/
    public Recruteur() {
        initComponents();
        this.setLocationRelativeTo(null); // center of the screen
        
        //Defini la transparence
        jLabel7.setBackground(new Color(0,0,0,0));
        jTextField1.setBackground(new Color(0,102,51,120));
        jComboBox1.setBackground(new Color(0,102,70,120));
        jPanel4.setBackground(new Color(0,102,51,0));
     
        //Cache un Panel
        jPanel8.setVisible(false);
        
        //Defini les ActionListenner
        jTextField1.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent hidden)
            {
                jLabel9.setText("");
            }
        });
        
        
    }
    
    /*Deuxieme Constructeur*/
    public Recruteur(Recruiter r) throws SQLException{
        this.r=r;
        initComponents();
        Affichagejob();
        this.setLocationRelativeTo(null); // center of the screen
        
        //Defini la transparence
        jLabel7.setBackground(new Color(0,0,0,0));
        jTextField1.setBackground(new Color(0,102,51,120));
        jComboBox1.setBackground(new Color(0,102,70,120));
        jPanel4.setBackground(new Color(0,102,51,0));
        
        //Cache un Panel
        jPanel8.setVisible(false);
        
        //Defini les ActionListenner
        jButton1.addActionListener(new AjoutJob(this));
        jButton2.addActionListener(new EnleverJob(this));
        jButton3.addActionListener(new AffichageCamembert(this));
        jTextField1.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent hidden)
            {
                jLabel9.setText("");
            }
        });
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(0, 102, 51));
        jPanel3.setLayout(null);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/deconnection.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel5);
        jLabel5.setBounds(1020, 40, 60, 60);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Déconnexion");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(870, 50, 140, 40);
        jPanel3.add(jSeparator1);
        jSeparator1.setBounds(870, 82, 140, 20);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText(r.getLastname() + " " + r.getFirstname());
        jPanel3.add(jLabel8);
        jLabel8.setBounds(360, 30, 490, 90);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 51));
        jLabel4.setText("RECRUTEUR");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(80, 30, 240, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cercle2.png"))); // NOI18N
        jPanel3.add(jLabel1);
        jLabel1.setBounds(60, 0, 250, 150);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/modifblack.png"))); // NOI18N
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel10);
        jLabel10.setBounds(20, 10, 30, 40);

        jTextField6.setForeground(new java.awt.Color(0, 102, 51));

        jButton7.setText("ok");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jTextField7.setForeground(new java.awt.Color(0, 102, 51));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel8);
        jPanel8.setBounds(60, 10, 250, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/recruteur.jpg"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 1099, 499);

        jPanel3.add(jPanel1);
        jPanel1.setBounds(0, 150, 1100, 500);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(0, 0, 1100, 197);

        jTextField1.setBackground(new java.awt.Color(0, 102, 51));
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jTextField1);
        jTextField1.setBounds(120, 220, 260, 70);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 51));
        jLabel9.setText("             Ajouter un emplois");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(100, 220, 270, 70);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 51));
        jLabel7.setText("             Liste d'emplois");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(60, 380, 270, 70);

        jComboBox1.setBackground(new java.awt.Color(0, 102, 51));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(120, 430, 260, 70);

        jButton1.setBackground(new java.awt.Color(0, 102, 51));
        jButton1.setText("AJOUTER");
        jPanel2.add(jButton1);
        jButton1.setBounds(150, 310, 190, 60);

        jButton2.setBackground(new java.awt.Color(0, 102, 51));
        jButton2.setText("SUPPRIMER");
        jPanel2.add(jButton2);
        jButton2.setBounds(150, 530, 190, 60);

        jButton3.setBackground(new java.awt.Color(0, 102, 51));
        jButton3.setText("ANALYSER");
        jPanel2.add(jButton3);
        jButton3.setBounds(690, 250, 190, 60);

        jPanel4.setBackground(new java.awt.Color(0, 102, 51));
        jPanel4.setLayout(new java.awt.BorderLayout());
        jPanel2.add(jPanel4);
        jPanel4.setBounds(530, 330, 500, 300);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/recruteur.jpg"))); // NOI18N
        jPanel2.add(jLabel3);
        jLabel3.setBounds(0, 146, 1100, 510);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1098, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*Permet de repartir sur la page Login*/
    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked

        Login log = new Login();//Creation d'une jframe login
        log.setVisible(true);//affichage de la jframe login
        log.pack();
        log.setLocationRelativeTo(null);
        log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();//la jframe recruteur se ferme
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        jPanel8.setBackground(new Color(0,0,0,0));
        jPanel8.setVisible(true);
        
        jTextField6.setText(r.getLastname());
        jTextField7.setText(r.getFirstname());
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        
        try{                                         
            
            Connection conn = Connexion1();
            try{
                Statement stmt = conn.createStatement();
                stmt.executeUpdate("UPDATE `Company`.candidat SET `lastnamecan`='" + jTextField6.getText() + "' , `firstnamecan`='" + jTextField7.getText() + "' WHERE `idcan`=" + r.getId() + ";");
                
                conn.close();
            }catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            
            r.setLastname(jTextField6.getText());
            r.setFirstname(jTextField7.getText());
            
            jPanel8.setVisible(false);
            
        }catch (SQLException ex) {
            Logger.getLogger(Job.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton7ActionPerformed
   
    /*Cette methode permet d'afficher tous les job*/
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
            listJob[i]=namejob;//on obtient la liste de job final
            i+=1;
        }
        String sqlStatement = "";
        listJob=listJob;
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(listJob));

        conn.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "L'affichage des jobs ne fonctionne pas", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
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
            java.util.logging.Logger.getLogger(Recruteur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recruteur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recruteur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recruteur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Recruteur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    public javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    public javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
