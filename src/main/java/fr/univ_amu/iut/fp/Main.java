package fr.univ_amu.iut.fp;

import fr.univ_amu.iut.view.map.AcademiePath;
import fr.univ_amu.iut.view.map.France;
import fr.univ_amu.iut.view.map.FranceBuilder;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.xml.namespace.QName;


public class Main extends Application {

    France france;
    @FXML
    private StackPane stackPaneFrance ;

    private void initFrance(){
        france = FranceBuilder.create()
//                .backgroundColor(Color.web("#4aa9d7"))
                //.fillColor(Color.web("#dcb36c"))
                //.strokeColor(Color.web("#987028"))
                //.hoverColor(Color.web("#fec47e"))
                //.pressedColor(Color.web("#6cee85"))
                //.selectedColor(Color.MAGENTA)
                .mousePressHandler(evt -> {
                    AcademiePath academiePath = (AcademiePath) evt.getSource();
                    System.out.println("On vient de cliquer sur l'"+academiePath.getAcademie().getNom());
                })
                .selectionEnabled(true)
                .build();
        stackPaneFrance.getChildren().addAll(france);

    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/fr/univ_amu/iut/fp/fp.fxml"));
//        initFrance();
        primaryStage.setTitle("Carte des académie");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public  static void main(String[] args) {launch(args);}

    }

