package ma.ensa.examenblanc;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import ma.ensa.examenblanc.Dao.DaoImp.MembreDaoImp;

import java.util.UUID;

public class HelloController {
    @FXML
    private TextField Nom;
    @FXML
    private TextField Prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField phone;

    @FXML
    protected void ajouter() {
        MembreDaoImp memebredao=new MembreDaoImp();
        String uid=UUID.randomUUID().toString(); //kangenriw l Id unique
        memebredao.insere(new Membre( uid,
                Nom.getText(),
                Prenom.getText(),
                email.getText(),
                phone.getText()
        ));
        System.out.println("je suis laaaa");
        //si une on a une interface qui vient apres celle la on
        // doit savoir quel member va gerer les incident-->on peur le passer a une classe comme singloton
    }

}