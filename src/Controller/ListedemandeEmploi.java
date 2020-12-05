/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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
        
    }
    public void AffichageDemandeEmploi() throws SQLException{

        String Metier = j.jComboBox1.getSelectedItem().toString();
        String Statut = jComboBox3.getSelectedItem().toString();
        String Date = ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();;
        

        String data[] = {Metier,Statut,Date};
        DefaultTableModel tab = (DefaultTableModel) jTable2.getModel();
        //tab.getDataVector().removeAllElements();
        tab.addRow(data);

    }
}
