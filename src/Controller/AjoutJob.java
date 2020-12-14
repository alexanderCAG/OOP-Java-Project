
package Controller;

/*Nos imports*/
import Vue.Recruteur;
import static DAO.Connexion.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
/* Cette classe implemente un action listener. Elle se lance quand le bouton AJOUTER de la jframe RECRUTEUR est selectionne. Elle permet d'ajouter un job*/

public class AjoutJob implements ActionListener {
    private Recruteur r;
    private String namejob;
    
    /*Constructeur*/
    public AjoutJob(Recruteur r){
        this.r=r;
    }
    
    /*Defini l'action que nous voulons*/
    public void actionPerformed(ActionEvent ae){
        this.namejob=this.r.jTextField1.getText();
        if(!"".equals(namejob)){
             try {
            Ajouterjob();
            r.jTextField1.setText(null);
            } catch (SQLException ex) {
                Logger.getLogger(AjoutJob.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    /*Cette methode ajoute un job dans la base de donnée*/
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
        r.listJob=listJob;
        r.jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(listJob));

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
