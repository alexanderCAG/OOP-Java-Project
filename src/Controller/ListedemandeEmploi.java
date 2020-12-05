/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classe.Candidat;
import static FonctionSQL.Connexion.Connexion1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import oop.java.project.GUI.Job;

/**
 *
 * @author Geoffroy
 */
public class ListedemandeEmploi implements ActionListener{
    private Job j;
    private Candidat c;
    private String Metier;
    private String Statut;
    private String Date;
    public ListedemandeEmploi(Job j, Candidat c){
        this.j=j;
        this.c=c;
    }
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
    public void AffichageDemandeEmploi() throws SQLException{
        String data[] = {Metier,Statut,Date};
        DefaultTableModel tab = (DefaultTableModel) j.jTable2.getModel();
        //tab.getDataVector().removeAllElements();
        tab.addRow(data);
    }
    public void BasededonneeDemandeEmploi() throws SQLException{
        Connection conn = Connexion1();
        System.out.println("Base donnee");
        try{
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO `Company`.DemandeEmploi ( idcan, metier, statut, datedebut ) VALUES ('" + c.getId() + "', '" + Metier + "', '" + Statut + "', '" + Date +"');");
        
        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
