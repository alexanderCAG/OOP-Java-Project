
package FonctionSQL;

/*Nos imports*/
import java.sql.*;

public class Connexion {
    public static Connection Connexion1() throws SQLException{
        String url="jdbc:mysql://localhost:3306/Company?autoReconnect=true&useSSL=false";
        String user="root";     /*C'est ici que vous devez rentrer votre nom d'utilisateur*/
        String pass="root";     /*C'est ici que vous devez rentrez votre mot de passe*/
        Connection conn=DriverManager.getConnection(url, user, pass);
        return conn;
    }
    
    
    public static void main(String[] args) throws SQLException {}
    
}
