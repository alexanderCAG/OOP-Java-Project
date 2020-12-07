/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static FonctionSQL.Connexion.*;
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
public class AffichageDemandeEmploiJob implements ActionListener{
    private Employeur e;
    public void actionPerformed(ActionEvent ae){
        try {
            candidatjob();        // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(Employeur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public AffichageDemandeEmploiJob(Employeur e){
        this.e=e;
    }
    public void candidatjob() throws SQLException{
        Connection conn=Connexion1();//Cette methode permet d'afficher toutes les demandes d'emploies
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
            JOptionPane.showMessageDialog(null, "Mot de passe INCORECT", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
