/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static FonctionSQL.Connexion.Connexion1;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import oop.java.project.GUI.Recruteur;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

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
        DefaultPieDataset graphe = new DefaultPieDataset();
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
        
        int[] nombrepersonnejob=new int[listJob.length];
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
        int nombrejob=Nombrejob();
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
            JOptionPane.showMessageDialog(null, "Mot de passe INCORECT", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public int Nombrejob() throws SQLException{
        
        Connection conn=Connexion1();
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
