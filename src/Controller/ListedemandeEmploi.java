/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classe.*;
import static FonctionSQL.Connexion.Connexion1;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.*;
import oop.java.project.GUI.*;

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
        //cette methode rajoute la demande d'emploi effectue par le candidat sur son tableau
        String data[] = {Metier,Statut,Date};
        DefaultTableModel tab = (DefaultTableModel) j.jTable2.getModel();
        //tab.getDataVector().removeAllElements();
        tab.addRow(data);
    }
    public void BasededonneeDemandeEmploi() throws SQLException{
        //Cette methode rajoute dans la base de donne sa demande d'emploi
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
