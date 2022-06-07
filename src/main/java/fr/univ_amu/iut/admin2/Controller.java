package fr.univ_amu.iut.admin2;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Button addActeurs;
    @FXML
    private AnchorPane acteurs;

    @FXML
    private Button addRessources;
    @FXML
    private AnchorPane ressources;


    private int cptActeur = 1;
    private int cptRessource = 1;

    private void addActeur(){
        TextField nom = new TextField();
        TextField type = new TextField();

        nom.setId(String.format("nomActeur%s",cptActeur));
        nom.setLayoutX(13);
        nom.setLayoutY(16+cptActeur*10+cptActeur*36);
        nom.setPrefHeight(36);
        nom.setPrefWidth(240);
        nom.resize(36 ,240);
        nom.setPromptText("Nom");

        type.setId(String.format("typeActeur%s",cptActeur));
        type.setLayoutX(310);
        type.setLayoutY(16+cptActeur*10+cptActeur*36);
        type.setPrefHeight(36);
        type.setPrefWidth(240);
        type.resize(36 ,240);
        type.setPromptText("Type");


        acteurs.getChildren().addAll(nom,type);
        acteurs.resize(acteurs.getHeight()+46,acteurs.getWidth());
        acteurs.setPrefHeight(acteurs.getHeight()+62);
        ++cptActeur;

    }
    /*
    *  <TextField fx:id="nomRessources" layoutX="13.0" layoutY="18.0" prefHeight="36.0" prefWidth="170.0" promptText="Nom" />
       <TextField fx:id="lienRessources" layoutX="199.0" layoutY="18.0" prefHeight="36.0" prefWidth="170.0" promptText="Lien" />
       <TextField fx:id="typeRessources" layoutX="379.0" layoutY="18.0" prefHeight="36.0" prefWidth="170.0" promptText="Type" />
    * */
    private void addRessource(){
        TextField nom = new TextField();
        TextField lien = new TextField();
        TextField type = new TextField();

        nom.setId(String.format("nomRessource%s",cptRessource));
        nom.setLayoutX(13);
        nom.setLayoutY(18+cptRessource*10+cptRessource*36);
        nom.setPrefHeight(36);
        nom.setPrefWidth(170);
        nom.resize(36 ,170);
        nom.setPromptText("Nom");

        lien.setId(String.format("lineRessource%s",cptRessource));
        lien.setLayoutX(199);
        lien.setLayoutY(18+cptRessource*10+cptRessource*36);
        lien.setPrefHeight(36);
        lien.setPrefWidth(170);
        lien.resize(36 ,170);
        lien.setPromptText("Lien");

        type.setId(String.format("typeRessource%s",cptRessource));
        type.setLayoutX(379);
        type.setLayoutY(18+cptRessource*10+cptRessource*36);
        type.setPrefHeight(36);
        type.setPrefWidth(170);
        type.resize(36 ,170);
        type.setPromptText("Type");

        ressources.getChildren().addAll(nom,type,lien);
        ressources.resize(ressources.getHeight()+46,ressources.getWidth());
        ressources.setPrefHeight(ressources.getHeight()+62);
        ++cptRessource;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addActeurs.setOnAction(actionEvent -> addActeur());
        addRessources.setOnAction(actionEvent -> addRessource());
    }
}
