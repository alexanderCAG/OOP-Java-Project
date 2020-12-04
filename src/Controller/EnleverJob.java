/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static FonctionSQL.Connexion.Connexion1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Geoffroy
 */
public class EnleverJob implements ActionListener{
    private String namejob;

    public EnleverJob(String namejob) {
        this.namejob = namejob;
    }
    public void actionPerformed(ActionEvent ae){
        try {
            Supprimerjob();
        } catch (SQLException ex) {
            Logger.getLogger(EnleverJob.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Supprimerjob() throws SQLException{
        Connection conn=Connexion1();
        try{
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("Delete from job where namejob='" + namejob + "';");
        
        //int rows = stmt.executeUpdate(sqlStatement);
        conn.close();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        Affichagejob();
    }
}
