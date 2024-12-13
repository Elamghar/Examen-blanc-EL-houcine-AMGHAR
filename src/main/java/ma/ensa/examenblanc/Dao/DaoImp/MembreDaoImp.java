package ma.ensa.examenblanc.Dao.DaoImp;

import ma.ensa.examenblanc.Dao.MembreDao;
import ma.ensa.examenblanc.Incident;
import ma.ensa.examenblanc.Membre;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.*;

import  ma.ensa.examenblanc.dbConnexion;
import  java.sql.Connection;

public class MembreDaoImp implements MembreDao {
    @Override
    public void insere(Membre m) {
        String sql = "INSERT INTO MEMBRE (identifiant,nom,prenom,email,phone) VALUES (?,?,?,?,?)";
        dbConnexion db = new dbConnexion();
        Connection conn = db.getConn();
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, m.getIdentifiant());
            stm.setString(2, m.getNom());
            stm.setString(3, m.getPrenom());
            stm.setString(4, m.getEmail());
            stm.setString(5, m.getPhone());
            stm.executeUpdate();
        } catch (SQLException s) {
            s.printStackTrace();
        }

    }

    @Override
    public List<Incident> chargerListIncidents() {
        String sql = "SELECT * FROM INCIDENT";
        dbConnexion db = new dbConnexion();
        Connection conn = db.getConn();
        List<Incident> listincident = new ArrayList<>();
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                listincident.add(new Incident(
                        rs.getString("reference"),
                        rs.getDate("time"),
                        rs.getString("status")
                ));
            }
        } catch (SQLException e) {

        }
        return listincident;
    }

    @Override
    public Set<Membre> chargerListeMembre(String nomFichier){
        Set<Membre> membres = new HashSet<>();
        String ligne;
        try (BufferedReader br = new BufferedReader(new FileReader(nomFichier))){
            br.readLine();
            while((ligne = br.readLine()) != null){
                String[] valeurs = ligne.split(",");
                if (valeurs.length == 5){
                    Membre membre= new Membre(
                            valeurs[1],
                            valeurs[2],
                            valeurs[3],
                            valeurs[4]
                    );
                    membres.add(membre);
                }
            }
        } catch (IOException e){
            System.err.println("Erreur lors de la lecture du fichier CSV : " + e.getMessage());
        }
        return membres;
    }
}
