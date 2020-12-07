/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FonctionSQL;

import java.sql.*;
/**
 *
 * @author Geoffroy
 */
public class Connexion {
    public static Connection Connexion1() throws SQLException{
        String url="jdbc:mysql://localhost:3306/Company?autoReconnect=true&useSSL=false";
        String user="root";
        String pass="root";
        Connection conn=DriverManager.getConnection(url, user, pass);
        return conn;
    }
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
        
        //addemployer("Gonzales", String firstname, String email, String motdepasse, int phone, String job, String sizecompany);
    }
    
}
