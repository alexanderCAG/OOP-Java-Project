
package Controller;

/*Nos imports*/
import java.awt.*;
import java.awt.event.*;
import oop.java.project.GUI.*;


public class OptionEmployeur implements ActionListener{
    private Register r;

    /*Constructeur*/
    public OptionEmployeur(Register r) {
        this.r = r;
    }
    
    /*Defini l'action que noous souhaitons*/
    public void actionPerformed(ActionEvent ae){
        optionemployeur();
    }
    
    /*Cette methode affiche la jcombobox (liste de job) et la jcombobox liste des statuts si l'employer est selectionne*/
    public void optionemployeur(){
        
        if("Employeur".equals(r.jComboBox1.getSelectedItem().toString()))
        {
            r.jPanel5.setBackground(new Color(204,102,0,0));
            r.jPanel5.setVisible(true);
        }else{
            r.jPanel5.setVisible(false);
        }
    }
}
