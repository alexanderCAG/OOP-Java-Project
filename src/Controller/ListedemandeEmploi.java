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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    private String Metier;
    private String Statut;
    private String Date;
    public ListedemandeEmploi(Job j){
        this.j=j;
    }
    public void actionPerformed(ActionEvent ae){
        this.Metier=j.jComboBox1.getSelectedItem().toString();
        this.Statut=j.jComboBox3.getSelectedItem().toString();
        this.Date=((JTextField)j.jDateChooser1.getDateEditor().getUiComponent()).getText();
    }
    public void AffichageDemandeEmploi() throws SQLException{
        String data[] = {Metier,Statut,Date};
        DefaultTableModel tab = (DefaultTableModel) j.jTable2.getModel();
        //tab.getDataVector().removeAllElements();
        tab.addRow(data);
    }
    public void LireBasededonneeDemandeEmploi() throws SQLException{
        Connection conn=Connexion1();
        DefaultTableModel tab = (DefaultTableModel) j.jTable2.getModel();
        try{
        Statement stmt = conn.createStatement();
        int i=0;
        ResultSet rs = stmt.executeQuery("Select * from DemandeurEmploi where id='" + c.getId() + "';");
        while(rs.next()){
            String Metier=rs.getString(2);
            String Statut=rs.getString(3);
            String Date=rs.getString(4);
            if(Metier!=null && Statut!=null && Date!=null){
                String data[] = {Metier,Statut,Date};
                //DefaultTableModel tab = (DefaultTableModel) jTable2.getModel();
                tab.addRow(data);
            }
        }
        String sqlStatement = "";
        this.listJob=listJob;
        j.jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(listJob));

        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Mot de passe INCORECT", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
