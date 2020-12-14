
package Controller;

/*Nos imports*/
import Vue.Job;
import Vue.Employeur;
import static DAO.Connexion.Connexion1;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author Geoffroy
 */
/* Cette classe implemente un action listener. Elle se lance quand le bouton CHOIXDUCANDIDAT de la jframe EMPLOYEUR est selectionne. Cette acttion performed permet à l'employeur d'accepter une demande emploi en selectionnant au prealable une ligne du tableau*/
public class SelectionCandidat implements ActionListener{
    private Employeur e;
    
    /*Constructeur*/
    public SelectionCandidat(Employeur e) {
        this.e = e;
    }
    
    /*Defini l'action que nous voulons effectuer*/
    public void actionPerformed(ActionEvent ae){
        if(e.jTable1.getSelectedRowCount() == 1){
            try {
                selection();
                calcul();
            } catch (SQLException ex) {
                Logger.getLogger(SelectionCandidat.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(e.jTable1.getSelectedRowCount() != 1){
            //Le calcul ne s'effectue pas car l'utilisateur n'a pas fait de selection
            JOptionPane.showMessageDialog(null, "Selectionnez un candidat");
        }
        /*else {
            //Le calcul ne s'effectue pas car l'utilisateur a fait plus d'une selection
            JOptionPane.showMessageDialog(null, "Ne selectionner qu'un seul candidat");
        }*/
        
    }
    
    /*Permet de supprimer toutes les autres demandes d'emploi qu'a fait un candidat*/
    public void selection() throws SQLException{
        try{
            
            int ligne = e.jTable1.getSelectedRow();
            if(ligne<0)
            {
                JOptionPane.showMessageDialog(e, "Selectionne une ligne à supprimer");
                return;
            }
            String id = e.jTable1.getModel().getValueAt(ligne, 0).toString();
            String idcan = e.jTable1.getModel().getValueAt(ligne, 1).toString();
            String lastname = e.jTable1.getModel().getValueAt(ligne, 2).toString();//cela permet de connaitre le metier de la ligne selectionne
            String firstname = e.jTable1.getModel().getValueAt(ligne, 3).toString();//cela permet de connaitre le statut de la ligne selectionne
            String Date = e.jTable1.getModel().getValueAt(ligne, 4).toString();//cela permet de connaitre la date de la ligne selectionne
            Connection conn=Connexion1();
            try{
                //la ligne est supprime dans la base de donnee
                Statement stmt = conn.createStatement();
                stmt.executeUpdate("DELETE from demandeemploi where `idcan`=" + idcan + " and `id`!=" + id + ";");
                confirmationdemandeemploi();
                conn.close();
            }catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            ((DefaultTableModel)e.jTable1.getModel()).removeRow(ligne);//la ligne est supprime dans le tableau
            
           }catch (SQLException ex) {
            Logger.getLogger(Job.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*Cette methode permet d'inserer à la demande d'emploi selectionne l'id de l'employeur qui l'a selectionné*/
    public void confirmationdemandeemploi() throws SQLException{
        int ligne = e.jTable1.getSelectedRow();
        String id = e.jTable1.getModel().getValueAt(ligne, 0).toString();
        String idcan = e.jTable1.getModel().getValueAt(ligne, 1).toString();
        Connection conn=Connexion1();
            try{
                //la ligne est supprime dans la base de donnee
                Statement stmt = conn.createStatement();
                stmt.executeUpdate("UPDATE `Company`.demandeemploi SET `selectionne`=" + e.e.getId() + " WHERE `id`=" + id + ";");//
                
                conn.close();
            }catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
    }
    
    /*Calcul avec remise de son choix de candidat*/
    public void calcul(){
        e.jPanel5.setVisible(true);
        e.jPanel6.setVisible(true);
        e.jPanel7.setVisible(false);
        double valeurcandidat = 5;
        valeurcandidat = valeurcandidat-valeurcandidat*e.discount ;
        e.jTextField4.setText(Double.toString(valeurcandidat) + " euros");
    }
    /*public void Selectionne() throws SQLException{
        Connection conn=Connexion1();
        int ligne = e.jTable1.getSelectedRow();
            String lastname = e.jTable1.getModel().getValueAt(ligne, 0).toString();//cela permet de connaitre le metier de la ligne selectionne
            String firstname = e.jTable1.getModel().getValueAt(ligne, 1).toString();//cela permet de connaitre le statut de la ligne selectionne
            String Date = e.jTable1.getModel().getValueAt(ligne, 2).toString();//cela permet de connaitre la date de la ligne selectionne
            try{
                //la ligne est supprime dans la base de donnee
                Statement stmt = conn.createStatement();
                stmt.executeUpdate("UPDATE `Company`.demandeemploi SET `selectionne`=" + e. + " WHERE `firstnamecan`='" + firstname + "'and lastnamecan='" + lastname + "';");
                
                conn.close();
            }catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
    }*/
    
}
