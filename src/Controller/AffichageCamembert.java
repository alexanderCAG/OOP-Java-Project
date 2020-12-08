
package Controller;

/*Nos imports*/
import Vue.Recruteur;
import static DAO.Connexion.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.general.*;


public class AffichageCamembert implements ActionListener{
    private Recruteur r;
    private String[] listJob;
    private int[] nombrepersonnejob;
    
    /*Constructeur*/
    public AffichageCamembert(Recruteur r){
        this.r=r;
    }
    
    /*Défini l'action que nous voulons faire*/
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
    
    /*Cette methode permet de visualiser sous forme de camembert le nombre de candidat*/
    public void Graphique() throws SQLException{
        DefaultPieDataset graphe = new DefaultPieDataset();
        Cammenbert();   //Appel de la fonction
        for(int i=0; i<listJob.length;i++){
            graphe.setValue(listJob[i], new Integer(nombrepersonnejob[i]));     //Defini la taille de chaque part du camembert
        }
        
        JFreeChart chart = ChartFactory.createPieChart("Nombres de candidats par emploie", graphe, true, true, true);    //Création du camembert 
        PiePlot plot = (PiePlot)chart.getPlot();
        ChartPanel barPanel = new ChartPanel(chart);        //Affichage
        r.jPanel4.removeAll();
        r.jPanel4.add(barPanel, BorderLayout.CENTER);       //Prend la taille du Panel
        r.jPanel4.validate();
    }
    
    /*Cette methode permet de connaitre le nombre de candidat qui a postule pour chaque job*/
    public void Cammenbert() throws SQLException{
        
        int[] nombrepersonnejob=new int[listJob.length];
        for(int i=0; i<listJob.length; i++){
            Connection conn=Connexion1();
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select count(id) from demandeemploi where metier='" + listJob[i] + "';");    //Compte le nombre de candidat par job
            while(rs.next()){
            nombrepersonnejob[i]=rs.getInt(1);
        }
        
        conn.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Le camembert ne marche pas", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
        }
        this.nombrepersonnejob=nombrepersonnejob;
        
    }
    
    /*Cette methode permet d'afficher la liste des jobs dans un jComboBox*/
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
        r.listJob=listJob;
        this.listJob=listJob;
        r.jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(listJob));

        conn.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "L'affichage des jobs ne fonctionne pas", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /*Cette methode compte le nombre de job et renvoie cette information a Affichagejob*/
    public int Nombrejob() throws SQLException{
        Connection conn=Connexion1();
        int nombrejob = 0;
        try{
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("Select count(namejob) from job;");
        while(rs.next()){
            nombrejob=rs.getInt(1);
        }
        
        conn.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "La liste du nombre de jobs ne fonctionne pas", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
        return nombrejob;
    }
}
