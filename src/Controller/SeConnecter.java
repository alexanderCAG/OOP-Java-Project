/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classe.Candidat;
import Classe.Employer;
import Classe.Recruiter;
import static FonctionSQL.Connexion.Connexion1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import oop.java.project.GUI.Employeur;
import oop.java.project.GUI.Job;
import oop.java.project.GUI.Login;
import oop.java.project.GUI.Recruteur;

/**
 *
 * @author Geoffroy
 */
public class SeConnecter implements ActionListener{
    private String user;
    private String pass;
    private Login l;
    public void actionPerformed(ActionEvent ae) {
        this.user=this.l.UserName.getText();
        this.pass=this.l.jPasswordField1.getText();
        try {
                Verificationcandidat();
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Verificationemployer();
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Verificationrecruiter();
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public SeConnecter(Login l) {
        this.l=l;
    }
    public void Verificationcandidat() throws SQLException{
        Connection conn = Connexion1();
        try{
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("Select * from candidat;");
        String email;
        String motdepasse;
        while(rs.next()){
            email=rs.getString(4);
            motdepasse=rs.getString(5);
            if(user.equals(email) && pass.equals(motdepasse)){
                System.out.println("Correct new candidat");
                Candidat c= new Candidat(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), rs.getBoolean(7));
                Job job = new Job(c);
                job.setVisible(true);
                job.pack();
                job.setLocationRelativeTo(null);
                job.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                l.dispose();
            }
        }
        String sqlStatement = "";

        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Mot de passe INCORECT", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void Verificationemployer() throws SQLException{
        Connection conn = Connexion1();
        try{
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("Select * from employer;");
        String email;
        String motdepasse;
        while(rs.next()){
            email=rs.getString(4);
            motdepasse=rs.getString(5);
            if(user.equals(email) && pass.equals(motdepasse)){
                System.out.println("Correct employer");
                IncrementationCompteur(rs.getInt(1),rs.getInt(9)+1);
                Employer e= new Employer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9)+1);
                //int id, String lastname, String firstname, String email, String motdepasse, int phone, String job, String sizecompany, int compteur
                Employeur employeur = new Employeur(e);
                employeur.setVisible(true);
                employeur.pack();
                employeur.setLocationRelativeTo(null);
                employeur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                l.dispose();
            }
        }
        String sqlStatement = "";

        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Mot de passe INCORECT", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void Verificationrecruiter() throws SQLException{
        Connection conn = Connexion1();
        try{
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("Select * from recruiter;");
        String email;
        String motdepasse;
        while(rs.next()){
            email=rs.getString(4);
            motdepasse=rs.getString(5);
            if(user.equals(email) && pass.equals(motdepasse)){
                System.out.println("Correct recruteur");
                Recruiter r= new Recruiter(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), rs.getString(7));
                //int id, String lastname, String firstname, String email, String motdepasse, int phone, String job
                System.out.println("Correct recruteur");
                Recruteur recruteur = new Recruteur(r);
                recruteur.setVisible(true);
                recruteur.pack();
                recruteur.setLocationRelativeTo(null);
                recruteur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                l.dispose();
            }
        }
        String sqlStatement = "";

        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Mot de passe INCORECT", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void IncrementationCompteur(int idemp, int compteur) throws SQLException{
        Connection conn = Connexion1();
        try{
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("UPDATE `Company`.employer SET `compteur`=" + compteur + " WHERE `idemp`=" + idemp + ";");
        
        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
}
