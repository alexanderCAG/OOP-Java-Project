
package Controller;

/*Nos imports*/
import Vue.Employeur;
import static DAO.Connexion.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;


public class AjoutJobEmpl implements ActionListener {
    
   private Employeur e;
    private String namejob;
    
    /*Constructeur*/
    public AjoutJobEmpl(Employeur e){
        this.e=e;
    }
    
    /*Defini l'action que nous voulons*/
    public void actionPerformed(ActionEvent ae){
        this.namejob=this.e.jTextField1.getText();
        if(!"".equals(namejob))
        {
            try {
            Ajouterjob();
            e.jTextField1.setText(null);
            e.jPanel5.setVisible(true);
            e.jPanel6.setVisible(false);
            e.jPanel7.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(AjoutJob.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
    /*Permet d'ajouter un job dans la base de donnée*/
    public void Ajouterjob() throws SQLException{
        Connection conn=Connexion1();
        try{
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO `Company`.Job ( namejob ) VALUES ('" + namejob + "');");
        
        conn.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        Affichagejob();
    }
    
    /*Cette methode permet d'afficher la liste des jobs dans un jcomboBox*/
    public void Affichagejob() throws SQLException{
        
        int nombrejob=Nombrejob();
        String[] listJob=new String[nombrejob];
        Connection conn=Connexion1();
        try{
        Statement stmt = conn.createStatement();
        int i=0;
        ResultSet rs = stmt.executeQuery("Select namejob from job;");
        while(rs.next()){
            String namejob=rs.getString(1);
            listJob[i]=namejob;
            i+=1;
        }
        e.listJob=listJob;
        e.jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(listJob));

        conn.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "L'affichage des jobs ne fonctionne pas", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /*Cette methode compte le nombre de job et renvoie cette information a Affichagejob*/
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
        return nombrejob;
    }
    
}
