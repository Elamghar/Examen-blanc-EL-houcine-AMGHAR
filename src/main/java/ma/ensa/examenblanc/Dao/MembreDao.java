package ma.ensa.examenblanc.Dao;

import ma.ensa.examenblanc.Membre;
import ma.ensa.examenblanc.Incident;
import java.util.List;
import java.util.Set;

public interface MembreDao {
    public void insere(Membre m);
    public List<Incident> chargerListIncidents();
    public Set<Membre> chargerListeMembre(String nomFichier);

    interface IncidentDao {
    }
}
