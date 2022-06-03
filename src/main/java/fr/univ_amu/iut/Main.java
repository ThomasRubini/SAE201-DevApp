package fr.univ_amu.iut;

import java.io.IOException;

import fr.univ_amu.iut.screenController.ScreenController;
import fr.univ_amu.iut.view.map.AcademiePath;
import fr.univ_amu.iut.view.map.France;
import fr.univ_amu.iut.view.map.FranceBuilder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    France france;

    @Override
    public void init() {
        france = FranceBuilder.create()
//                .backgroundColor(Color.web("#4aa9d7"))
//                .fillColor(Color.web("#dcb36c"))
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

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(new Pane());
        ScreenController gestionnaireDePages = new ScreenController(scene);
        gestionnaireDePages.addScreen("Acceuil",FXMLLoader.load(getClass().getResource("/fr/univ_amu/iut/fp/fp.fxml")));
        gestionnaireDePages.addScreen("Resultats",FXMLLoader.load(getClass().getResource("/fr/univ_amu/iut/fResultat/FResultat.fxml")));;
        gestionnaireDePages.activate("Resultats");
        stage.setTitle("Carte des académie");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
