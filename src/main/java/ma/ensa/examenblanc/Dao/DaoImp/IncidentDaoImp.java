package ma.ensa.examenblanc.Dao.DaoImp;

import ma.ensa.examenblanc.Dao.IncidentDao;
import ma.ensa.examenblanc.Incident;
import ma.ensa.examenblanc.Membre;
import ma.ensa.examenblanc.dbConnexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

public class IncidentDaoImp implements IncidentDao {
    @Override
    public void insere(Incident i) {
            String sql="INSERT INTO Incident (reference,time,status) VALUES (?,?,?)";
            dbConnexion db=new dbConnexion();
            Connection conn=db.getConn();
            try {
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setString(1, i.getReference());
                stm.setDate(2, (java.sql.Date)i.getTime());
                stm.setString(3,i.getStatus());
            }catch (SQLException s){

            }

        }

    @Override
    public void insere(Set is) {
    }
}
