/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FonctionSQL;
import java.sql.*;
import java.util.Scanner;
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
    public static void afficherjobs() throws SQLException{
        Connection conn = Connexion1();
        try{
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("Select namejob from job");

        while(rs.next()){
            System.out.println(rs.getString(1)+" ");
        }
        String sqlStatement = "";

        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void affichermemeberemployer() throws SQLException{
        Connection conn = Connexion1();
        try{
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("Select lastnamemem, firstnamemem from memberemployer");

        while(rs.next()){
            System.out.println(rs.getString(1)+" "+rs.getString(2));
        }
        String sqlStatement = "";

        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void affichernewemployer() throws SQLException{
        Connection conn = Connexion1();
        try{
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("Select lastnamenew, firstnamenew from newemployer");

        while(rs.next()){
            System.out.println(rs.getString(1)+" "+rs.getString(2));
        }
        String sqlStatement = "";

        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void afficherjobseeker() throws SQLException{
        Connection conn = Connexion1();
        try{
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("Select lastnamesee, firstnamesee from jobseeker");

        while(rs.next()){
            System.out.println(rs.getString(1)+" "+rs.getString(2));
        }
        String sqlStatement = "";

        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void countnewemployer() throws SQLException{
        Connection conn = Connexion1();
        try{
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("Select count(lastnamenew) from newemployer");

        while(rs.next()){
            System.out.println(rs.getString(1));
        }
        String sqlStatement = "";

        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void countmemberemployer() throws SQLException{
        Connection conn = Connexion1();
        try{
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("Select count(lastnamemem) from memberemployer");

        while(rs.next()){
            System.out.println(rs.getString(1));
        }
        String sqlStatement = "";

        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void countjobseeker() throws SQLException{
        Connection conn = Connexion1();
        try{
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("Select count(lastnamesee) from jobseeker");

        while(rs.next()){
            System.out.println(rs.getString(1));
        }
        String sqlStatement = "";

        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void addjobs() throws SQLException{
        Connection conn = Connexion1();
        Scanner s=new Scanner(System.in);
        System.out.println("Inserez le nom d'un job,svp:");
        String namejob=s.nextLine();
        try{
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO `Company`.Job ( namejob ) VALUES ('" + namejob + "');");
        
        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void addnewemployer() throws SQLException{
        Connection conn = Connexion1();
        Scanner s=new Scanner(System.in);
        System.out.println("Inserez le un nouveau new employer,svp:");
        String idnew=s.nextLine();
        String lastnamenew=s.nextLine();
        String firstnamenew=s.nextLine();
        String email=s.nextLine();
        String motdepasse=s.nextLine();
        int phone=s.nextInt();
        String job=s.nextLine();
        try{
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO `Company`.NewEmployer ( idnew, lastnamenew, firstnamenew, email, motdepasse, phone, job ) VALUES ('" + idnew + "', '" + lastnamenew + "', '" + firstnamenew + "', '" + email + "', '" + motdepasse + "', " + phone + ", '" + job + "');");
        
        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void addmememployer() throws SQLException{
        Connection conn = Connexion1();
        Scanner s=new Scanner(System.in);
        System.out.println("Inserez le un nouveau member employer,svp:");
        String idmem=s.nextLine();
        String lastnamemem=s.nextLine();
        String firstnamemem=s.nextLine();
        String email=s.nextLine();
        String motdepasse=s.nextLine();
        int phone=s.nextInt();
        String job=s.nextLine();
        try{
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO `Company`.memberEmployer ( idmem, lastnamemem, firstnamemem, email, motdepasse, phone, job ) VALUES ('" + idmem + "', '" + lastnamemem + "', '" + firstnamemem + "', '" + email + "', '" + motdepasse + "', " + phone + ", '" + job + "');");
        
        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     public static void addjobseeker() throws SQLException{
        Connection conn = Connexion1();
        Scanner s=new Scanner(System.in);
        System.out.println("Inserez le un nouveau jobseeker,svp:");
        String idmem=s.nextLine();
        String lastnamemem=s.nextLine();
        String firstnamemem=s.nextLine();
        String email=s.nextLine();
        String motdepasse=s.nextLine();
        int phone=s.nextInt();
        String job=s.nextLine();
        try{
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO `Company`.jobseeker ( idmem, lastnamemem, firstnamemem, email, motdepasse, phone, job ) VALUES ('" + idmem + "', '" + lastnamemem + "', '" + firstnamemem + "', '" + email + "', '" + motdepasse + "', " + phone + ", '" + job + "');");
        
        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     
    public static void deletejobs() throws SQLException{
        Connection conn = Connexion1();
        Scanner s=new Scanner(System.in);
        System.out.println("Inserez le nom d'un job à supprimer,svp:");
        String namejob=s.nextLine();
        try{
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("delete from job where namejob='" + namejob + "';");
        
        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        //afficherjobs();
        //deletejobs();
        //addjobs();
        //affichermemeberemployer();
        //affichernewemployer();
        //countnewemployer();
        afficherjobseeker();
    }
    
}
