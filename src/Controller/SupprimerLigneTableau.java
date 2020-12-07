
package Controller;

/*Nos imports*/
import Vue.Job;
import static DAO.Connexion.Connexion1;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.*;


public class SupprimerLigneTableau implements ActionListener{
    private Job j;
    
    /*Constructeur*/
    public SupprimerLigneTableau(Job j) {
        this.j = j;
    }
    
    /*Defini l'action que nous voulons faire*/
    public void actionPerformed(ActionEvent ae){
        supprimerligne();//la methode supprimerligne est appele
    }
    
    /*Cette methode permet de supprimet une ligne du tableau*/
    public void supprimerligne(){
        try{
            
            int ligne = j.jTable2.getSelectedRow();
            if(ligne<0)
            {
                JOptionPane.showMessageDialog(j, "Selectionne une ligne à supprimer");
                return;
            }
            String Metier = j.jTable2.getModel().getValueAt(ligne, 0).toString();//cela permet de connaitre le metier de la ligne selectionne
            String statut = j.jTable2.getModel().getValueAt(ligne, 1).toString();//cela permet de connaitre le statut de la ligne selectionne
            String Date = j.jTable2.getModel().getValueAt(ligne, 2).toString();//cela permet de connaitre la date de la ligne selectionne
            Connection conn=Connexion1();
            try{
                //la ligne est supprime dans la base de donnee
                Statement stmt = conn.createStatement();
                stmt.executeUpdate("Delete from demandeemploi where idcan=" + j.c.getId() + " and metier='" + Metier + "' and statut='" + statut + "' and datedebut='" + Date + "';");
                
                conn.close();
            }catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            ((DefaultTableModel)j.jTable2.getModel()).removeRow(ligne);//la ligne est supprime dans le tableau
            
           }catch (SQLException ex) {
            Logger.getLogger(Job.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
