
package Controller;

/*Nos imports*/
import Vue.Recruteur;
import static DAO.Connexion.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;


public class EnleverJob implements ActionListener{
    private Recruteur r;
    
    /*Constructeur*/
    public EnleverJob(Recruteur r) {
        this.r = r;
    }
    
    /*Defini l'action que nous voulons*/
    public void actionPerformed(ActionEvent ae){
        try {
            Supprimerjob();
        } catch (SQLException ex) {
            Logger.getLogger(EnleverJob.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*Cette methode permet de supprimer un job dans la base de donnee*/
    public void Supprimerjob() throws SQLException{
        Connection conn=Connexion1();
        try{
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("Delete from job where namejob='" + r.jTextField1.getText() + "';");
        
        conn.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        Affichagejob();
    }
    
    /*Cette methode permet d'afficher la liste des jobs dans un jcomboBox*/
    public void Affichagejob() throws SQLException{
        
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
        r.listJob=listJob;
        r.jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(listJob));

        conn.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Mot de passe INCORECT", "Login Error", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "Mot de passe INCORECT", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
        return nombrejob;
    }
    
}

