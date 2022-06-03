package fr.univ_amu.iut.fp;

import fr.univ_amu.iut.dao.DAORessource;
import fr.univ_amu.iut.dao.DAOThematique;
import fr.univ_amu.iut.dao.factory.DAOFactory;
import fr.univ_amu.iut.dao.factory.DAOFactoryProducer;
import fr.univ_amu.iut.dao.factory.DAOType;
import fr.univ_amu.iut.model.Ressource;
import fr.univ_amu.iut.model.Thematique;
import fr.univ_amu.iut.view.map.France;
import fr.univ_amu.iut.view.map.FranceBuilder;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    France france;


    DAOFactory daoFactory;
    DAORessource daoRessource;
    DAOThematique daoThematique;

    @FXML
    private Pane stackPaneFrance;

    @FXML
    private AnchorPane ressource;

    @FXML
    private AnchorPane thematique;

    private void initFrance() {
        france = FranceBuilder.create()
                .backgroundColor(Color.web("#f5f0e1"))
                .fillColor(Color.web("#1e3d59"))
//                .strokeColor(Color.web("#987028"))
//                .hoverColor(Color.web("#fec47e"))
//                .pressedColor(Color.web("#6cee85"))
//                .selectedColor(Color.MAGENTA)
//                .mousePressHandler(evt -> {
//                    AcademiePath academiePath = (AcademiePath) evt.getSource();
//                    System.out.println("On vient de cliquer sur l'"+academiePath.getAcademie().getNom());
//                })
                .selectionEnabled(true)
                .build();
    }


    /*<Button layoutX="38.0" layoutY="30.0" mnemonicParsing="false" prefHeight="115.0" prefWidth="235.0" style="-fx-background-radius: 30; -fx-background-color: #ff6e40;" text="Button" />
                        <Button layoutX="332.0" layoutY="30.0" mnemonicParsing="false" prefHeight="115.0" prefWidth="235.0" style="-fx-background-radius: 30; -fx-background-color: #ff6e40#ff6e40;" text="Button" />*/


    private Button initButton(String ressource,int x,int y){
        Button bt = new Button(ressource);
        bt.setMnemonicParsing(false);
        bt.setMinSize(235,115);
        bt.layoutXProperty().setValue(x);
        bt.layoutYProperty().setValue(y);
        bt.setId(ressource);
        bt.prefHeight(115);
        bt.prefWidth(235);
        bt.setText(ressource);
        bt.setBackground(new Background(new BackgroundFill(Color.rgb(255,110,64), new CornerRadii(30), Insets.EMPTY)));
        return bt;
    }

    private Void placeButtonRessource(){
        List<Ressource> ressources = daoRessource.findAll();
        ressource.setMinHeight(ressources.size()*65);
        for (int i = 0;i<ressources.size();++i){
            if (i%2 == 0){
                ressource.getChildren().add(initButton(ressources.get(i).getNomRessource(),38,i/2*130));
            }
            else {
                ressource.getChildren().add(initButton(ressources.get(i).getNomRessource(),332,i/2*130));
            }
        }

        return null;
    }

    private Void placeButtonThematique(){
        List<Thematique> thematiques = daoThematique.findAll();
        thematique.setMinHeight(thematiques.size()*65);
        for (int i = 0;i<thematiques.size();++i){
            if (i%2 == 0){
                thematique.getChildren().add(initButton(thematiques.get(i).getNom(),38,i/2*130));
            }
            else {
                thematique.getChildren().add(initButton(thematiques.get(i).getNom(),332,i/2*130));
            }
        }
        return null;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initFrance();
        stackPaneFrance.getChildren().add(france);

        // init
        daoFactory = DAOFactoryProducer.getFactory(DAOType.TEST);
        daoRessource = daoFactory.createDAORessource();
        daoThematique = daoFactory.createDAOThematique();

        // a chaque fois
        List<Ressource> l = daoRessource.findAll();
        List<Thematique> t = daoThematique.findAll();

        placeButtonThematique();
        placeButtonRessource();
//        matiere.getChildren().add(initButton(t.get(0).getNom(),38,30));
//        matiere.getChildren().add(initButton("test",38,160));
    }
}
