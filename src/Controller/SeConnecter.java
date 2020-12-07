/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classe.*;
import static FonctionSQL.Connexion.Connexion1;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import oop.java.project.GUI.*;

/**
 *
 * @author Geoffroy
 */
public class SeConnecter implements ActionListener{
    private String user;
    private String pass;
    private Login l;
    public void actionPerformed(ActionEvent ae) {
        this.user=this.l.UserName.getText();//Cet actionPerformed permet de separer les candidats, les employers et les recruteurs et de les envoyer sur leur page d'accueil
        this.pass=this.l.jPasswordField1.getText();
        try {
                Verificationcandidat();
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Mot de passe INCORECT", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
            try {
                Verificationemployer();
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Mot de passe INCORECT", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
            try {
                Verificationrecruiter();
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Mot de passe INCORECT", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
    }
    public SeConnecter(Login l) {
        this.l=l;
    }
    public void Verificationcandidat() throws SQLException{
        Connection conn = Connexion1();//Cette methode verifie si c'est un candidat
        try{
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("Select * from candidat;");
        String email;
        String motdepasse;
        while(rs.next()){
            email=rs.getString(4);
            motdepasse=rs.getString(5);
            if(user.equals(email) && pass.equals(motdepasse)){
                //si oui le candidat sera redirige vers la page Candidat
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
        //Cette methode verifie si c'est un employer
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
                //si oui l'employer sera redirige vers la page employeur
                IncrementationCompteur(rs.getInt(1),rs.getInt(9)+1);//Une incrementation aura lieu pour redefinir son nombre de connexion
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
        //Cette methode verifie si c'est un recruiter
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
                //si oui le recruteur sera redirige vers la page recruiter
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
        Connection conn = Connexion1();//Cette methode permet d'incrementer le nombre de connexion de l'employer
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
