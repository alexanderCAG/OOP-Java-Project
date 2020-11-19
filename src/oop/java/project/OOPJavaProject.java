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
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        String url="jdbc:mysql://localhost:3306/Company?autoReconnect=true&useSSL=false";
        String user="root";
        String pass="";
        Connection conn=DriverManager.getConnection(url, user, pass);
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

        //new Login();
        
    }
    
}
