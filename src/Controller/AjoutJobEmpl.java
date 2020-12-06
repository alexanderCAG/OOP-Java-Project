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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oop.java.project.GUI.Employeur;

/**
 *
 * @author alexa
 */
public class AjoutJobEmpl implements ActionListener {
    
   private Employeur e;
    private String namejob;
    public AjoutJobEmpl(Employeur e){
        this.e=e;
    }
    
    
    public void actionPerformed(ActionEvent ae){
        this.namejob=this.e.jTextField1.getText();
        if(!"".equals(namejob))
        {
            try {
            Ajouterjob();
            discount();
            } catch (SQLException ex) {
                Logger.getLogger(AjoutJob.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    public void discount(){
        //si une seule ligne du tableau est selectionne alors le calcul s'effectue
        e.jPanel5.setVisible(true);
        e.jPanel6.setVisible(false);
        e.jPanel7.setVisible(true);
        double prix = 0;
            double prixT = 0;

            prix = Double.parseDouble(e.jTextField2.getText());
            prixT = prix - prix*e.discount;

            e.jTextField3.setText(Double.toString(prixT) + " euros");
        
            
    }
    
    public void Ajouterjob() throws SQLException{
        Connection conn=Connexion1();
        try{
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO `Company`.Job ( namejob ) VALUES ('" + namejob + "');");
        
        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        Affichagejob();
    }
    
    public void Affichagejob() throws SQLException{
        //Cette methode permet d'afficher la liste des jobs dans un jcomboBox
        int nombrejob=Nombrejob();
        String[] listJob=new String[nombrejob];
        Connection conn=Connexion1();
        try{
        Statement stmt = conn.createStatement();
        int i=0;
        ResultSet rs = stmt.executeQuery("Select namejob from job;");
        while(rs.next()){
            String namejob=rs.getString(1);
            listJob[i]=namejob;
            i+=1;
        }
        String sqlStatement = "";
        e.listJob=listJob;
        e.jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(listJob));

        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Mot de passe INCORECT", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public int Nombrejob() throws SQLException{
        
        Connection conn=Connexion1();//Cette methode compte le nombre de job et renvoie cette information a Affichagejob
        int nombrejob = 0;
        try{
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("Select count(namejob) from job;");
        while(rs.next()){
            nombrejob=rs.getInt(1);
        }
        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Mot de passe INCORECT", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
        return nombrejob;
    }
    
}
