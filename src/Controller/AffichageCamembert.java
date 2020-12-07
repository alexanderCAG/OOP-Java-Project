/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static FonctionSQL.Connexion.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import oop.java.project.GUI.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.general.*;

/**
 *
 * @author Geoffroy
 */
public class AffichageCamembert implements ActionListener{
    private Recruteur r;
    private String[] listJob;
    private int[] nombrepersonnejob;
    private JPanel jPanel4;
    public AffichageCamembert(Recruteur r){
        this.r=r;
    }
    public void actionPerformed(ActionEvent ae){
        try {
            Affichagejob();
        } catch (SQLException ex) {
            Logger.getLogger(AffichageCamembert.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Graphique();
        } catch (SQLException ex) {
            Logger.getLogger(AffichageCamembert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Graphique() throws SQLException{
        DefaultPieDataset graphe = new DefaultPieDataset();//Cette methode permet de visualiser sous forme de graphique le nombre de candidat 
        Cammenbert();
        for(int i=0; i<listJob.length;i++){
            graphe.setValue(listJob[i], new Integer(nombrepersonnejob[i]));
        }
        
        JFreeChart chart = ChartFactory.createPieChart("Nombre d'employé par Metier", graphe, true, true, true);
        PiePlot plot = (PiePlot)chart.getPlot();
        ChartPanel barPanel = new ChartPanel(chart);
        r.jPanel4.removeAll();
        r.jPanel4.add(barPanel, BorderLayout.CENTER);
        r.jPanel4.validate();
    }
    public void Cammenbert() throws SQLException{
        
        int[] nombrepersonnejob=new int[listJob.length];// Cette methode permet de connaitre le nombre de candidat qui a postule pour chaque job
        for(int i=0; i<listJob.length; i++){
            Connection conn=Connexion1();
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select count(lastnameemp) from employer where job='" + listJob[i] + "';");
            while(rs.next()){
            nombrepersonnejob[i]=rs.getInt(1);
        }
        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Le camembert ne marche pas", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
        }
        this.nombrepersonnejob=nombrepersonnejob;
        
    }
    public void Affichagejob() throws SQLException{
        int nombrejob=Nombrejob();//Cette methode permet d'afficher la liste des jobs dans un jcomboBox
        String[] listJob=new String[nombrejob];
        Connection conn=Connexion1();
        try{
        Statement stmt = conn.createStatement();
        int i=0;
        ResultSet rs = stmt.executeQuery("Select * from job;");
        while(rs.next()){
            String namejob=rs.getString(1);
            listJob[i]=namejob;
            i+=1;
        }
        String sqlStatement = "";
        r.listJob=listJob;
        this.listJob=listJob;
        r.jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(listJob));

        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "La liste des jobs ne fonctionne pas", "Login Error", JOptionPane.ERROR_MESSAGE);
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
