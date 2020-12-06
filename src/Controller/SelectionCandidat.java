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
import oop.java.project.GUI.Employeur;
import oop.java.project.GUI.Job;

/**
 *
 * @author Geoffroy
 */
public class SelectionCandidat implements ActionListener{
    private Employeur e;
    public SelectionCandidat(Employeur e) {
        this.e = e;
    }
    public void actionPerformed(ActionEvent ae){
        if(e.jTable1.getSelectedRowCount() == 1){
            try {
                selection();
                
            } catch (SQLException ex) {
                Logger.getLogger(SelectionCandidat.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(e.jTable1.getRowCount() == 0){
            //Le calcul ne s'effectue pas car l'utilisateur n'a pas fait de selection
            JOptionPane.showMessageDialog(null, "Tableau vide");
        }else {
            //Le calcul ne s'effectue pas car l'utilisateur a fait plus d'une selection
            JOptionPane.showMessageDialog(null, "Ne selectionner qu'un seul candidat");
        }
        
    }
    public void selection() throws SQLException{
        try{
            
            int ligne = e.jTable1.getSelectedRow();
            if(ligne<0)
            {
                JOptionPane.showMessageDialog(e, "Selectionne une ligne à supprimer");
                return;
            }
            String lastname = e.jTable1.getModel().getValueAt(ligne, 0).toString();//cela permet de connaitre le metier de la ligne selectionne
            String firstname = e.jTable1.getModel().getValueAt(ligne, 1).toString();//cela permet de connaitre le statut de la ligne selectionne
            String Date = e.jTable1.getModel().getValueAt(ligne, 2).toString();//cela permet de connaitre la date de la ligne selectionne
            Connection conn=Connexion1();
            try{
                //la ligne est supprime dans la base de donnee
                Statement stmt = conn.createStatement();
                stmt.executeUpdate("UPDATE `Company`.employer SET `selection`=" + false + " WHERE `firstname`='" + firstname + "'and lastname='" + lastname + "';");
                
                //int rows = stmt.executeUpdate(sqlStatement);
                conn.close();
            }catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            ((DefaultTableModel)e.jTable1.getModel()).removeRow(ligne);//la ligne est supprime dans le tableau
            
           }catch (SQLException ex) {
            Logger.getLogger(Job.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void calcul(){
        e.jPanel5.setVisible(true);
        e.jPanel6.setVisible(true);
        e.jPanel7.setVisible(false);
        double valeurcandidat = 5;
        valeurcandidat = valeurcandidat-valeurcandidat*e.discount ;
        e.jTextField4.setText(Double.toString(valeurcandidat));
    }
}
