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
    public static void Connexion1(){
        String url="jdbc:mysql://localhost:3306/Company";
        String user="root";
        String pass="Vhpsq47y78&";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url, user, pass);
            //PreparedStatement pamnt=conn.prepareStatement("insert ");
            /*pamnt.setString(1, 1);
            pamnt.setString(1, 1);*/
            //pamnt.executeUpdate();
            System.out.println("Driver load successfull");
            
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
    public static void main(String[] args) {
        // TODO code application logic here
        Connexion1();
        
    }
    
}
