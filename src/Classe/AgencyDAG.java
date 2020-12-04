/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe;

import static FonctionSQL.Connexion.Connexion1;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Geoffroy
 */
public class AgencyDAG {
    private String nameag;
    private ArrayList<AJob> listJob;

    public AgencyDAG(String nameag, ArrayList<AJob> listJob) {
        this.nameag = nameag;
        this.listJob = listJob;
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

    
}
