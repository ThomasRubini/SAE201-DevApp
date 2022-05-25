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
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.xml.namespace.QName;


public class Main extends Application {

    public  static void main(String[] args) {launch(args);}
    @Override
    public void start(Stage stage) throws Exception {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("/fr/univ_amu/iut/fp/fp.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

