/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import oop.java.project.GUI.Employeur;

/**
 *
 * @author Geoffroy
 */
public class Discount implements ActionListener{
    private Employeur e;
    public Discount(Employeur e) {
        this.e = e;
    }
    public void actionPerformed(ActionEvent ae){
        if(e.jTable1.getSelectedRowCount() == 1)
        {
            double valeurcandidat = 5;
            valeurcandidat = valeurcandidat-valeurcandidat*e.discount ;
            
            e.jPanel5.setVisible(true);
            e.jPanel6.setVisible(true);
            e.jPanel7.setVisible(false);
            
            e.jTextField4.setText(Double.toString(valeurcandidat) + " euros");
            
        }else if(e.jTable1.getRowCount() == 0)
        {
            JOptionPane.showMessageDialog(null, "Tableau vide");
        }else {
            JOptionPane.showMessageDialog(null, "Ne selectionner qu'un seul candidat");
        }
        
    }
}
