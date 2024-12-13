package ma.ensa.examenblanc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.System.exit;

public class Membre {
    private String identifiant,nom,prenom,email,phone;
    List<Incident> incidents;

    public Membre(String id,String nom,String prenom,String phone,String email){
        this.identifiant=id;
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;
        this.phone=phone;
        incidents =new ArrayList<>();
    }
    public Membre(String nom,String prenom,String phone,String email){
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;
        this.phone=phone;
        incidents =new ArrayList<>();
    }
    public void addIncident(Incident I){
        if(I==null){
            System.out.println("objet I null");
            exit(1);
        }
        incidents.add(I);
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public int hashCode(){
       return  Objects.hash(identifiant,nom,prenom);
    }
    @Override
    public boolean equals(Object o){
        if(o==this)return true;
        if(o==null || getClass()!= o.getClass())return false;
        Membre m=(Membre) o;
        return this.identifiant.equals(m.getIdentifiant());
    }

}
