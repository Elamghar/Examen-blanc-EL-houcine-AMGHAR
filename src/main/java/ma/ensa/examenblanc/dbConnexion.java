package ma.ensa.examenblanc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnexion {
    String url="jdbc:mysql://localhost:3306/supervision";
    ;
    String user="root";
    String passwd="root";
    Connection conn;

    public dbConnexion(){
        try {
            conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("connexion bien effectuer");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public Connection getConn(){
        return conn;
    }
}
