/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static FonctionSQL.Connexion.Connexion1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import oop.java.project.GUI.Job;

/**
 *
 * @author Geoffroy
 */
public class SupprimerLigneTableau implements ActionListener{
    private Job j;

    public SupprimerLigneTableau(Job j) {
        this.j = j;
    }
    public void actionPerformed(ActionEvent ae){
        supprimerligne();//la methode supprimerligne est appele
    }
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
                
                //int rows = stmt.executeUpdate(sqlStatement);
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
