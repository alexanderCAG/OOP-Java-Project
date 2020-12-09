
package Vue;

/*nos imports*/
import Model.Employer;
import Controller.*;
import static DAO.Connexion.*;
import com.itextpdf.text.pdf.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class Employeur extends javax.swing.JFrame {

    
    public Employer e;
    private PdfPTable table;
    public String[] listJob;
    private String[] data;
    public double discount;
    
    public int tour = 0;
    
    /*Premier Constructeur*/
    public Employeur() {
        initComponents();
        this.setLocationRelativeTo(null); // center of the screen 
        //Cache un Panel
        jPanel5.setVisible(false);
        jPanel8.setVisible(false);
        
        //Definir la transparence
        jPanel4.setBackground(new Color(204,102,0,120));
        jTextField1.setBackground(new Color(204,102,0,120));
        jComboBox2.setBackground(new Color(150,102,0,120));
        jButton3.setBackground(new Color(150,102,0,120));
        jButton4.setBackground(new Color(150,102,0,120));
        
        //Defini les ActionListener
        jTextField1.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent hidden)
            {
                jLabel11.setText("");
            }
        });
    }
    
    /*Deuxieme Constructeur*/
    public Employeur(Employer e) throws SQLException {
        this.e=e;//Permet de connaitre la personne qui s'est connecte
        initComponents();
        if(e.getCompteur()==5){//Nous avons defini qu'a partir de 5 connexions l'employer est defini comme membre.
            jLabel9.setText("Vous etes desormais un nouveau membre.");
            if(e.getSizecompany()=="micro"){
                jLabel10.setText("-15% de discount");//Si le compteur est egale à 5 et que l'utilisateur fait parti d'une micro entreprise alors sa remise est de 1000 euros
                discount = 0.15;
            }
            else{
                jLabel10.setText("-10% de discount");//Si le compteur est egale à 5 et que l'utilisateur fait parti d'une grande entreprise alors sa remise est de 2000 euros
                discount = 0.10;
            }
        }
        if(e.getCompteur()<5){
            jLabel9.setText("Vous etes un nouvelle employer.");
            discount = 0;
        }
        if(e.getCompteur()>5){
            jLabel9.setText("Vous etes un membre.");
            if(e.getSizecompany()=="micro"){
                jLabel10.setText("-15% de discount");//Si le compteur est supérieur à 5 et que l'utilisateur fait parti d'une micro entreprise alors sa remise est de 1000 euros
                discount = 0.15;
            }
            else{
                jLabel10.setText("-10% de discount");//Si le compteur est supérieur à 5 et que l'utilisateur fait parti d'une grande entreprise alors sa remise est de 2000 euros
                discount = 0.10;
            }
        }
        Affichagejob();//Cette methode permet d'afficher la liste des job dans le jcombobox
        allcandidatjob();//Cette methode affiche toutes les demandes emplois effectuées par les candidats
        this.setLocationRelativeTo(null); // center of the screen 
        
        //Cache un Panel
        jPanel5.setVisible(false);
        jPanel8.setVisible(false);
        
        //Definir la transparence
        jPanel4.setBackground(new Color(204,102,0,120));
        jTextField1.setBackground(new Color(204,102,0,120));
        jComboBox2.setBackground(new Color(150,102,0,120));
        jButton3.setBackground(new Color(150,102,0,120));
        jButton4.setBackground(new Color(150,102,0,120));
        
        //Defini les ActionListener
        jButton4.addActionListener(new AffichageDemandeEmploiJob(this));
        jButton5.addActionListener(new AjoutJobEmpl(this));
        jButton3.addActionListener(new PDF(this));
        jButton6.addActionListener(new SelectionCandidat(this));
        jTextField1.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent hidden)
            {
                jLabel11.setText("");
            }
        });
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable(){
            public boolean isCellEditable(int d, int c){
                return false;
            }
        };
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(153, 102, 0));
        jPanel2.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText(e.getLastname() + " " + e.getFirstname());
        jPanel2.add(jLabel8);
        jLabel8.setBounds(330, 30, 530, 90);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/deconnection.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel5);
        jLabel5.setBounds(1020, 40, 60, 60);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 102, 0));
        jLabel4.setText("EMPLOYEUR");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(80, 30, 240, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cercle2.png"))); // NOI18N
        jPanel2.add(jLabel1);
        jLabel1.setBounds(60, 0, 250, 150);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setForeground(new java.awt.Color(255, 255, 0));
        jLabel9.setText("jLabel9");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(330, 20, 440, 14);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/employeur.jpg"))); // NOI18N
        jPanel3.add(jLabel2);
        jLabel2.setBounds(0, 0, 1100, 500);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(0, 150, 1100, 500);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Déconnexion");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(870, 50, 140, 40);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(870, 82, 140, 20);

        jLabel10.setForeground(new java.awt.Color(255, 255, 0));
        jPanel2.add(jLabel10);
        jLabel10.setBounds(490, 100, 170, 50);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1100, 180);

        jComboBox2.setBackground(new java.awt.Color(150, 102, 0));
        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(380, 240, 247, 70);

        jPanel4.setBackground(new java.awt.Color(153, 102, 0));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom", "Prenom", "Date de début"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 102, 0));
        jLabel7.setText("Candidats");

        jButton3.setBackground(new java.awt.Color(150, 102, 0));
        jButton3.setText("Enregistrer la liste");

        jButton6.setBackground(new java.awt.Color(150, 102, 0));
        jButton6.setText("Choix du candidat");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(78, 78, 78)
                            .addComponent(jLabel7))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton6))
                .addContainerGap())
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(720, 180, 340, 440);

        jButton4.setBackground(new java.awt.Color(150, 102, 0));
        jButton4.setText("VALIDER");
        jPanel1.add(jButton4);
        jButton4.setBounds(410, 340, 190, 50);

        jButton5.setBackground(new java.awt.Color(150, 102, 0));
        jButton5.setText("VALIDER");
        jPanel1.add(jButton5);
        jButton5.setBounds(80, 340, 190, 50);

        jPanel5.setBackground(new java.awt.Color(153, 102, 0));
        jPanel5.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(153, 102, 0));

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Grâce à vos remise, ce candidat vous revient à :");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel14)
                .addGap(39, 39, 39)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel6);
        jPanel6.setBounds(0, 30, 520, 120);

        jPanel7.setBackground(new java.awt.Color(153, 102, 0));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Combien voulez-vous mettre pour voir votre job en tête de liste ?");

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Grâce à vos remises le total est de :");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(31, 31, 31)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        jPanel5.add(jPanel7);
        jPanel7.setBounds(0, 0, 520, 180);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(80, 440, 520, 180);

        jTextField1.setBackground(new java.awt.Color(153, 102, 0));
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jTextField1);
        jTextField1.setBounds(60, 240, 230, 70);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(230, 160, 0));
        jLabel11.setText("Ajouter un emplois");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(80, 260, 190, 30);

        jTextField6.setForeground(new java.awt.Color(153, 102, 0));

        jButton7.setText("ok");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jTextField7.setForeground(new java.awt.Color(153, 102, 0));

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
        jPanel8.setBounds(60, 180, 250, 40);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/modif.png"))); // NOI18N
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel15);
        jLabel15.setBounds(10, 180, 30, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/employeur.jpg"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 146, 1100, 510);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1099, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*Permet de repartir sur la Frame de Login*/
    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked

        Login log = new Login();//Creation d'une jframe login
        log.setVisible(true);//affichage de la jframe login
        log.pack();
        log.setLocationRelativeTo(null);
        log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();//la jframe employeur se ferme

    }//GEN-LAST:event_jLabel5MouseClicked

    /*Permet de calculer avec les remises le prix que l'emploeyeur met pour sa nouvelle Offre d'emploie (referencement)*/
    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        jPanel5.setVisible(true);      //affiche Panel principal
        jPanel6.setVisible(false);
        jPanel7.setVisible(true);       //affiche le bon Panel
        double prix = 0;
        double prixT = 0;

        prix = Double.parseDouble(jTextField2.getText());
        prixT = prix - prix*discount;

        jTextField3.setText(Double.toString(prixT) + " euros");
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    jTextField2.setText(null);
                    jTextField3.setText(null);
                }
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        jPanel8.setBackground(new Color(0,0,0,0));
        jPanel8.setVisible(true);
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jPanel8.setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed
 
    /*Cette methode permet d'obtenir la liste des job*/
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
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(listJob));

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
    
    /*Cette methode affiche tous les candidats qui ont fait une demande emploi qui n'ont jamais ete selectionne par les employer*/
    public void allcandidatjob() throws SQLException{
        Connection conn=Connexion1();
        
        try{
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select lastnamecan, firstnamecan, datedebut from demandeemploi natural join candidat where selection=true;");
        //DefaultTableModel tab = new DefaultTableModel(data, 0);
        //jTable1.setModel(new DefaultTableModel(null, new String[]{"Nom", "Prenom", "Date de début"}));
        DefaultTableModel tab = (DefaultTableModel) jTable1.getModel();
        
        
//        tab.setRowCount(0);
//        jTable1.setModel(tab);
//        jTable1.repaint();
        
//        int rows = jTable1.getRowCount();
//        for(int i=0;i<rows;i++)
//            ((DefaultTableModel)jTable1.getModel()).removeRow(i);
        
        //tab.getDataVector().removeAllElements();
        
        String text= "Lastname Firstname Start Date";
        while(rs.next())
        {
            String lastname= rs.getString(1);
            String firstname= rs.getString(2);
            String date= rs.getString(3);
            text=text + "\n" + lastname + " " + firstname + " " + date;
            
            tab.addRow(data);
        }
        conn.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "L'affichage de la liste des candidats ne fonctionne pas", "Login Error", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(Employeur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employeur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employeur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employeur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employeur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    public javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    public javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    public javax.swing.JPanel jPanel5;
    public javax.swing.JPanel jPanel6;
    public javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTable jTable1;
    public javax.swing.JTextField jTextField1;
    public javax.swing.JTextField jTextField2;
    public javax.swing.JTextField jTextField3;
    public javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
