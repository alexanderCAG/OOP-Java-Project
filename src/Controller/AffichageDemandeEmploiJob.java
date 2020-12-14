
package Controller;

/*Nos imports*/
import Vue.Employeur;
import static DAO.Connexion.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.*;
/* Cette classe implemente un action listener. Elle se lance quand le bouton jButton3 de la jframe EMPLOYER est selectionne. Elle permet d'afficher les demandes d'emploi d'un 
job*/

public class AffichageDemandeEmploiJob implements ActionListener{
    private Employeur e;
    
    /*Constructeur*/
    public AffichageDemandeEmploiJob(Employeur e){
        this.e=e;
    }
    
    /*Defini l'action que nous voulons*/
    public void actionPerformed(ActionEvent ae){
        try {
            candidatjob();
        } catch (SQLException ex) {
            Logger.getLogger(Employeur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*Cette methode permet d'afficher toutes les demandes d'emploies*/
    public void candidatjob() throws SQLException{
        Connection conn=Connexion1();
        try{
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select id, idcan, lastnamecan, firstnamecan, datedebut from demandeemploi natural join candidat where selectionne='' and metier='" + e.jComboBox2.getSelectedItem().toString() + "';");
        DefaultTableModel tab = (DefaultTableModel) e.jTable1.getModel();
        tab.getDataVector().removeAllElements();
        
        while(rs.next())
        {
            String id=rs.getString(1);
            String idcan=rs.getString(2);
            String user= rs.getString(3);
            String pass= rs.getString(4);
            String date= rs.getString(5);
            
            String data[] = {id,idcan, user,pass,date};
            
            tab.addRow(data);
        }
        
        conn.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "La liste des candidats ne fonctionne pas", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
