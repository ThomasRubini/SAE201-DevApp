package fr.univ_amu.iut.fp;

import fr.univ_amu.iut.AppMain;
import fr.univ_amu.iut.Donnees;
import fr.univ_amu.iut.dao.DAODiscipline;
import fr.univ_amu.iut.dao.DAORessource;
import fr.univ_amu.iut.dao.DAOThematique;
import fr.univ_amu.iut.dao.DAOUsage;
import fr.univ_amu.iut.dao.factory.DAOFactory;
import fr.univ_amu.iut.dao.factory.DAOFactoryProducer;
import fr.univ_amu.iut.dao.factory.DAOType;
import fr.univ_amu.iut.model.Discipline;
import fr.univ_amu.iut.model.Thematique;
import fr.univ_amu.iut.screenController.ScreenController;
import fr.univ_amu.iut.view.map.AcademiePath;
import fr.univ_amu.iut.view.map.France;
import fr.univ_amu.iut.view.map.FranceBuilder;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    France france;
    EventHandler<MouseEvent> onEnterHandler;
    EventHandler<MouseEvent> onExitHandler;
    DAOFactory daoFactory;
    DAODiscipline daoDiscipline;
    DAOThematique daoThematique;
    DAOUsage daoUsage;

    Stage lastResultSceneOpened;

    @FXML
    private Pane stackPaneFrance;

    @FXML
    private TextField barreDeRecherche;

    @FXML
    private AnchorPane discipline;

    @FXML
    private AnchorPane thematique;

    @FXML
    private Button recherche;

    @FXML
    private Button rechercheTextuelle;

    // Style des boutons
    Background btNormalBackground = new Background(new BackgroundFill(Color.rgb(255,110,64), new CornerRadii(30), Insets.EMPTY));
    Background btNormalHover = new Background(new BackgroundFill(Color.rgb(255,152,120), new CornerRadii(30), Insets.EMPTY));
    Background btNormalSelected = new Background(new BackgroundFill(Color.rgb(255,60,0), new CornerRadii(30), Insets.EMPTY));

    private void initFrance() {
        france = FranceBuilder.create()
                .backgroundColor(Color.web("#f5f0e1"))
                .fillColor(Color.web("#1e3d59"))
                .mousePressHandler(evt -> {
                   AcademiePath academiePath = (AcademiePath) evt.getSource();
                   Donnees.setAcademieSelectionee(academiePath.getAcademie());
                })
                .selectionEnabled(true)
                .build();
    }

    private Button initButton(Object obj,int x,int y){
        String nom = "";
        
        EventHandler<ActionEvent> actionHandler;
        EventHandler<MouseEvent> onPressHandler;
        
        onEnterHandler = evt -> {
           Button bt = (Button) evt.getSource();
           bt.setBackground(btNormalHover);
        };
        
        onExitHandler= evt -> {
            Button bt = (Button) evt.getSource();
            bt.setBackground(btNormalBackground);
        };

        onPressHandler = event -> {
            Button bt = (Button) event.getSource();
            if(bt.getBackground().equals(btNormalSelected)){
                bt.setBackground(btNormalHover);
                bt.setOnMouseEntered(onEnterHandler);
                bt.setOnMouseExited(onExitHandler);
            }
            else{
                bt.setBackground(btNormalSelected);
                bt.setOnMouseEntered(null);
                bt.setOnMouseExited(null);
            }
        };

        if ( obj instanceof Discipline ){
            Discipline disciplineActuelle = (Discipline) obj;
            nom = disciplineActuelle.getNom();
            actionHandler = event -> {Donnees.setDisciplineSelectionee(disciplineActuelle);};
        }
        else{
            Thematique thematiqueActuelle = (Thematique) obj;
            nom = thematiqueActuelle.getNom();
            actionHandler = event -> {Donnees.setThematiqueSelectionee(thematiqueActuelle);};
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
        bt.setBackground(btNormalBackground);
        bt.setOnAction(actionHandler);
        bt.setOnMouseClicked(onPressHandler);
        bt.setOnMouseEntered(onEnterHandler);
        bt.setOnMouseExited(onExitHandler);
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
        daoFactory = DAOFactoryProducer.getFactory(AppMain.testMode ? DAOType.TEST : DAOType.JPA);
        daoDiscipline = daoFactory.createDAODiscipline();
        daoThematique = daoFactory.createDAOThematique();
        daoUsage = daoFactory.createDAOUsage();

        // a chaque fois
        
        List<Discipline> d = daoDiscipline.findAll();
        List<Thematique> t = daoThematique.findAll();

        placeButtonThematique();
        placeButtonDiscipline();
        EventHandler<ActionEvent> handleRechercheTextuelle = event ->{
            
            Donnees.setUsagesObtenus(daoUsage.findByNamePart(barreDeRecherche.getText()));

            Stage resultats = new Stage();
            try {
                resultats.setScene(new Scene(FXMLLoader.load(getClass().getResource("/fr/univ_amu/iut/fResultat/FResultat.fxml"))));
                resultats.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        rechercheTextuelle.setOnAction(handleRechercheTextuelle);


        EventHandler<ActionEvent> handleRechercheCrieters = event ->{
            System.out.println("test");
            Donnees.setUsagesObtenus(daoUsage.findByCriterias(Donnees.getThematiqueSelectionee(),Donnees.getDisciplineSelectionee(),Donnees.getAcademieSelectionee()));
            Stage resultats = new Stage();
            try {
                resultats.setScene(new Scene(FXMLLoader.load(getClass().getResource("/fr/univ_amu/iut/fResultat/FResultat.fxml"))));
                resultats.show();
                lastResultSceneOpened = resultats;
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        recherche.setOnAction(handleRechercheCrieters);
    }
}
