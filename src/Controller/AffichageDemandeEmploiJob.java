
package Controller;

/*Nos imports*/
import Vue.Employeur;
import static DAO.Connexion.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.*;


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
        ResultSet rs = stmt.executeQuery("select lastnamecan, firstnamecan, datedebut from demandeemploi natural join candidat where selection=true and metier='" + e.jComboBox2.getSelectedItem().toString() + "';");
        DefaultTableModel tab = (DefaultTableModel) e.jTable1.getModel();
        tab.getDataVector().removeAllElements();
        
        while(rs.next())
        {
            String user= rs.getString(1);
            String pass= rs.getString(2);
            String date= rs.getString(3);
            
            String data[] = {user,pass,date};
            
            tab.addRow(data);
        }
        
        conn.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "La liste des candidats ne fonctionne pas", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
