package fr.univ_amu.iut.detailResultats;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PrintColor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;


import java.net.URL;
import java.util.ResourceBundle;

import fr.univ_amu.iut.Donnees;
import fr.univ_amu.iut.model.Acteur;
import fr.univ_amu.iut.model.Ressource;
import fr.univ_amu.iut.model.Usage;

public class Controller implements Initializable{

    @FXML
    private Label acteurLabel;

    @FXML
    private Label disciplineLabel;

    @FXML
    private Label regionAcademieLabel;

    @FXML
    private Label ressourceLabel;

    @FXML
    private Label thematiqueLabel;

    @FXML
    private Label academieLabel;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Usage usage = Donnees.getUsageSelectione();
        StringBuilder sb = new StringBuilder();
        for(Acteur acteur : usage.getActeurs()){
            sb.append(acteur.getIdentite());
            sb.append(",");
        }
        acteurLabel.setText(sb.toString());
        disciplineLabel.setText(usage.getDiscipline().getNom());
        regionAcademieLabel.setText(usage.getAcademie().getRegionAcademique().getNom());
        
        StringBuilder sb2 = new StringBuilder();
        for(Ressource ressource : usage.getRessources()){
            sb.append(ressource.getLienRessource().toString());
            sb.append(",");
        }
        ressourceLabel.setText(sb2.toString());
        thematiqueLabel.setText(usage.getThematique().getNom());
        academieLabel.setText(usage.getAcademie().getNom());

        
    }

}

