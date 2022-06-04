package fr.univ_amu.iut.fp;

import fr.univ_amu.iut.Donnees;
import fr.univ_amu.iut.dao.DAODiscipline;
import fr.univ_amu.iut.dao.DAORessource;
import fr.univ_amu.iut.dao.DAOThematique;
import fr.univ_amu.iut.dao.factory.DAOFactory;
import fr.univ_amu.iut.dao.factory.DAOFactoryProducer;
import fr.univ_amu.iut.dao.factory.DAOType;
import fr.univ_amu.iut.model.Discipline;
import fr.univ_amu.iut.model.Thematique;
import fr.univ_amu.iut.view.map.France;
import fr.univ_amu.iut.view.map.FranceBuilder;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    France france;


    DAOFactory daoFactory;
    DAODiscipline daoDiscipline;
    DAOThematique daoThematique;

    @FXML
    private Pane stackPaneFrance;

    @FXML
    private AnchorPane discipline;

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


    private Button initButton(Object obj,int x,int y){
        String nom = "";
        EventHandler<ActionEvent> handler;
        if ( obj instanceof Discipline ){
            Discipline disciplineActuelle = (Discipline) obj;
            nom = disciplineActuelle.getNom();
            handler = event -> {
                if (Donnees.getDisciplineSelectionee().equals(disciplineActuelle)){
                    Donnees.setDisciplineSelectionee(Discipline.Toutes);
                }
                else{
                    Donnees.setDisciplineSelectionee(disciplineActuelle);
                }
            };
        }
        else{
            Thematique thematiqueActuelle = (Thematique) obj;
            handler = event -> {
                if (Donnees.getThematiqueSelectionee() == null || !(Donnees.getThematiqueSelectionee().equals(obj))){
                    Donnees.setThematiqueSelectionee(thematiqueActuelle);
                }
                else{
                    Donnees.setThematiqueSelectionee(null);
                }
            };
            nom = thematiqueActuelle.getNom();
        }

        Button bt = new Button(nom);
        bt.setMnemonicParsing(false);
        bt.setMinSize(235,115);
        bt.layoutXProperty().setValue(x);
        bt.layoutYProperty().setValue(y);
        bt.setId(nom);
        bt.prefHeight(115);
        bt.prefWidth(235);
        bt.setText(nom);
        bt.setBackground(new Background(new BackgroundFill(Color.rgb(255,110,64), new CornerRadii(30), Insets.EMPTY)));
        bt.setOnAction(handler);
        return bt;
    }

    private Void placeButtonDiscipline(){
        List<Discipline> disciplines = daoDiscipline.findAll();
        discipline.setMinHeight(disciplines.size()*65);
        for (int i = 0;i<disciplines.size();++i){
            if (i%2 == 0){
                discipline.getChildren().add(initButton(disciplines.get(i),38,i/2*130));
            }
            else {
                discipline.getChildren().add(initButton(disciplines.get(i),332,i/2*130));
            }
        }

        return null;
    }

    private Void placeButtonThematique(){
        List<Thematique> thematiques = daoThematique.findAll();
        thematique.setMinHeight(thematiques.size()*65);
        for (int i = 0;i<thematiques.size();++i){
            if (i%2 == 0){
                thematique.getChildren().add(initButton(thematiques.get(i),38,i/2*130));
            }
            else {
                thematique.getChildren().add(initButton(thematiques.get(i),332,i/2*130));
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
        daoDiscipline = daoFactory.createDAODiscipline();
        daoThematique = daoFactory.createDAOThematique();

        // a chaque fois
        
        List<Discipline> d = daoDiscipline.findAll();
        List<Thematique> t = daoThematique.findAll();

        placeButtonThematique();
        placeButtonDiscipline();
//        matiere.getChildren().add(initButton(t.get(0).getNom(),38,30));
//        matiere.getChildren().add(initButton("test",38,160));
    }
}
