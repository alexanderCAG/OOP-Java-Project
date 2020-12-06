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
        //Cette methode permet de calculer la remise d'un candidat
        if(e.jTable1.getSelectedRowCount() == 1)
        {
            //si une seule ligne du tableau est selectionne alors le calcul s'effectue
            double valeurcandidat = 5;
            valeurcandidat = valeurcandidat-valeurcandidat*e.discount ;
            
            e.jPanel5.setVisible(true);
            e.jPanel6.setVisible(true);
            e.jPanel7.setVisible(false);
            
            e.jTextField4.setText(Double.toString(valeurcandidat) + " euros");
            
        }else if(e.jTable1.getRowCount() == 0)
        {
            //Le calcul ne s'effectue pas car l'utilisateur n'a pas fait de selection
            JOptionPane.showMessageDialog(null, "Tableau vide");
        }else {
            //Le calcul ne s'effectue pas car l'utilisateur a fait plus d'une selection
            JOptionPane.showMessageDialog(null, "Ne selectionner qu'un seul candidat");
        }
        
    }
}
