package fr.univ_amu.iut;

import java.io.IOException;

import fr.univ_amu.iut.screenController.ScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    private Scene scene = new Scene(new Pane());
    private ScreenController gestionnaireDePages = new ScreenController(scene);

    @Override
    public void start(Stage stage) throws IOException{
        ScreenController.addScreen("Acceuil",FXMLLoader.load(getClass().getResource("/fr/univ_amu/iut/fp/fp.fxml")));
        
        //TODO Ajouter les pages d'admin pour l'ajout des usages
        //ScreenController.addScreen("admin1",pane);
        //ScreenController.addScreen("admin2",pane);
        
        ScreenController.activate("Acceuil");
        stage.setTitle("Carte des académie");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        launch(args);
    }
}
