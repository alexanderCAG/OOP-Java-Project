/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import oop.java.project.GUI.Register;

/**
 *
 * @author Geoffroy
 */
public class OptionEmployeur implements ActionListener{
    private Register r;

    public OptionEmployeur(Register r) {
        this.r = r;
    }
    public void actionPerformed(ActionEvent ae){
        optionemployeur();
    }
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
