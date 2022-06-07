package fr.univ_amu.iut;

import java.io.IOException;

import fr.univ_amu.iut.screenController.ScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AppMain extends Application {
    private Scene scene = new Scene(new Pane());
    private ScreenController gestionnaireDePages = new ScreenController(scene);

    public static boolean testMode;

    @Override
    public void start(Stage stage) throws IOException{

        String res = getParameters().getNamed().get("testMode");
        testMode = res!=null&&res.equals("true");


        ScreenController.addScreen("Accueil",FXMLLoader.load(getClass().getResource("/fr/univ_amu/iut/ui/fenetrePrincipale/fp.fxml")));
        
        //TODO Ajouter les pages d'admin pour l'ajout des usages
        //ScreenController.addScreen("admin1",pane);
        //ScreenController.addScreen("admin2",pane);
        
        ScreenController.activate("Accueil");
        stage.setTitle("Carte des académie");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
