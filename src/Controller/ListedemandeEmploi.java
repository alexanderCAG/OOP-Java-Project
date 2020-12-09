
package Controller;

/*Nos imports*/
import Vue.Job;
import Model.Candidat;
import static DAO.Connexion.Connexion1;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.*;


public class ListedemandeEmploi implements ActionListener{
    private Job j;
    private Candidat c;
    private String Metier;
    private String Statut;
    private String Date;
    private String Nom;
    
    /*Constructeur*/
    public ListedemandeEmploi(Job j, Candidat c){
        this.j=j;
        this.c=c;
    }
    
    /*Defini l'action que nous voulons effectuer*/
    public void actionPerformed(ActionEvent ae){
        this.Metier=j.jComboBox1.getSelectedItem().toString();
        this.Statut=j.jComboBox3.getSelectedItem().toString();
        this.Date=((JTextField)j.jDateChooser1.getDateEditor().getUiComponent()).getText();
        try {
            AffichageDemandeEmploi();
        } catch (SQLException ex) {
            Logger.getLogger(ListedemandeEmploi.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            BasededonneeDemandeEmploi();
        } catch (SQLException ex) {
            Logger.getLogger(ListedemandeEmploi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*Cette methode rajoute la demande d'emploi effectue par le candidat sur son tableau*/
    public void AffichageDemandeEmploi() throws SQLException{
        
        String data[] = {Metier,Statut,Date};
        DefaultTableModel tab = (DefaultTableModel) j.jTable2.getModel();
        tab.addRow(data);
    }
    
    /*Cette methode rajoute dans la base de donne sa demande d'emploi*/
    public void BasededonneeDemandeEmploi() throws SQLException{
        
        Connection conn = Connexion1();
        System.out.println("Base donnee");
        try{
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO `Company`.DemandeEmploi ( idcan, metier, statut, datedebut ) VALUES ('" + c.getId() + "', '" + Metier + "', '" + Statut + "', '" + Date +"');");
        
        conn.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
