/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FonctionSQL;
import Classe.AJob;
import Classe.Candidat;
import Classe.DemandeEmploi;
import Classe.Employer;
import Classe.Recruiter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import oop.java.project.GUI.Employeur;
import oop.java.project.GUI.Job;
import oop.java.project.GUI.Recruteur;
/**
 *
 * @author Geoffroy
 */
public class Connexion {
    public static Connection Connexion1() throws SQLException{
        String url="jdbc:mysql://localhost:3306/Company?autoReconnect=true&useSSL=false";
        String user="root";
        String pass="Vhpsq47y78&";
        Connection conn=DriverManager.getConnection(url, user, pass);
        return conn;
    }
    public static ArrayList Alljobs() throws SQLException{
        ArrayList listjob= new ArrayList();
        Connection conn = Connexion1();
        try{
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("Select * from job;");

        while(rs.next()){
            AJob j=new AJob(rs.getString(1));
            listjob.add(j);
        }
        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listjob;
    }
    public static ArrayList Allcandidats() throws SQLException{
        ArrayList listcandidat= new ArrayList();
        Connection conn = Connexion1();
        try{
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("Select * from candidat;");

        while(rs.next()){
            Candidat c=new Candidat(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getBoolean(7));
            listcandidat.add(c);
        }
        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listcandidat;
    }
    public static ArrayList Allemployers() throws SQLException{
        ArrayList listemployer= new ArrayList();
        Connection conn = Connexion1();
        try{
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("Select * from employer;");

        while(rs.next()){
            Employer e=new Employer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9));
            listemployer.add(e);
        }
        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listemployer;
    }
    public static ArrayList Allrecruiters() throws SQLException{
        ArrayList listrecruiter= new ArrayList();
        Connection conn = Connexion1();
        try{
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("Select * from recruiter;");

        while(rs.next()){
            Recruiter r=new Recruiter(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));
            listrecruiter.add(r);
        }
        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listrecruiter;
    }
    public static ArrayList Alldemandesemploi() throws SQLException{
        ArrayList listdemandesemploi= new ArrayList();
        Connection conn = Connexion1();
        try{
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("Select * from demandeemploi;");

        while(rs.next()){
            DemandeEmploi d=new DemandeEmploi(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
            listdemandesemploi.add(d);
        }
        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listdemandesemploi;
    }
    public static void addjob(String namejob) throws SQLException{
        Connection conn = Connexion1();
        try{
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO `Company`.Job ( namejob ) VALUES ('" + namejob + "');");
        
        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void addcandidat(String lastname, String firstname, String email, String motdepasse, int phone, int selection) throws SQLException{
        Connection conn = Connexion1();
        try{
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO `Company`.Candidat ( lastnamecan, firstnamecan, email, motdepasse, phone, selection ) VALUES ('" + lastname + "', '" + firstname + "', '" + email + "', '" + motdepasse + "', " + phone + ", '" + selection + "');");
        
        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void addemployer(String lastname, String firstname, String email, String motdepasse, int phone, String job, String sizecompany) throws SQLException{
        Connection conn = Connexion1();
        try{
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO `Company`.Employer ( lastnameemp, firstnameemp, email, motdepasse, phone, job, sizecompany, compteur ) VALUES ('" + lastname + "', '" + firstname + "', '" + email + "', '" + motdepasse + "', " + phone + ", '" + job + "', '" + sizecompany + "', " + 0 + ");");
        
        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void addrecruiter(String lastname, String firstname, String email, String motdepasse, int phone, String job) throws SQLException{
        Connection conn = Connexion1();
        try{
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO `Company`.Recruiter ( lastnamerec, firstnamerec, email, motdepasse, phone, job ) VALUES ('" + lastname + "', '" + firstname + "', '" + email + "', '" + motdepasse + "', " + phone + ", '" + job + "');");
        
        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void adddemandeemploi(int idcan, String Metier, String statut, String Date) throws SQLException{
        Connection conn = Connexion1();
        try{
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO `Company`.DemandeEmploi ( idcan, metier, statut, datedebut ) VALUES (" + idcan + ", '" + Metier + "', '" + statut + "', '" + Date + "');");
        
        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void deletejobs(String namejob) throws SQLException{
        Connection conn = Connexion1();
        try{
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("delete from job where namejob='" + namejob + "';");
        
        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    /*public int numberspecificjob(String namejob) throws SQLException{
        Connection conn = Connexion1();
        int number=0;
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select count(lastnamemem) from employer where job='" + namejob + "';");
            while(rs.next()){
            number=rs.getInt(1);
        }
        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Le camembert ne marche pas", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
        return number;
    }
    public static int Nombrejob() throws SQLException{
        
        Connection conn=Connexion1();
        int nombrejob = 0;
        try{
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("Select count(namejob) from job;");
        while(rs.next()){
            nombrejob=rs.getInt(1);
            System.out.println("Hello " + nombrejob);
        }
        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Mot de passe INCORECT", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
        return nombrejob;
    }
    public static String[] Affichagejob() throws SQLException{
        int nombrejob=Nombrejob();
        String[] listJob=new String[nombrejob];
        Connection conn=Connexion1();
        try{
        Statement stmt = conn.createStatement();
        int i=0;
        ResultSet rs = stmt.executeQuery("Select * from job;");
        while(rs.next()){
            String namejob=rs.getString(1);
            System.out.println("Coucou " + namejob);
            listJob[i]=namejob;
            System.out.println(listJob[i]);
            i+=1;
        }
        //jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(listJob));
        conn.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Mot de passe INCORECT", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
        return listJob;
    }*/
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        addjob("Chauffeurs");
        addcandidat("Nivet", "Guillaume", "guillaume@edu.ece.fr", "dyjs", 689957846, 0);
        addemployer("Granger", "Isaure", "isaure@edu.ece.fr", "dyjs", 689789524, "Ingenieur", "micro");
        addrecruiter("Farrenq", "Thomas", "thomas@edu.ece.fr", "dyjs", 751335526, "Ingenieur en robotique");
        adddemandeemploi(1, "Ingenieur en electromagnetisme", "Etudiant", "15 déc. 2021");
        deletejobs("Ingenieur");
        
        //addemployer("Gonzales", String firstname, String email, String motdepasse, int phone, String job, String sizecompany);
    }
    
}
