/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.java.project;

import java.sql.*;
import oop.java.project.GUI.*;

/**
 *
 * @author alexa
 */
public class OOPJavaProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        
        //new Login();
        Class.forName("com.mysql.jdbc.Driver");

        // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
        String urlDatabase = "jdbc:mysql://localhost:3308/Company";
       // String urlDatabase = "jdbc:mysql://localhost:3308/jps?characterEncoding=latin1";

        //création d'une connexion JDBC à la base 
        Connection conn = DriverManager.getConnection(urlDatabase, "root", "");

        // création d'un ordre SQL (statement)
        //Statement stmt = conn.createStatement();
    }
    
}
