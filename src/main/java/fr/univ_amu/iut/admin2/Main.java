package fr.univ_amu.iut.admin2;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class Main extends Application {

    public  static void main(String[] args) {launch(args);}
    @Override
    public void start(Stage stage) throws Exception {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("/fr/univ_amu/iut/admin2/admin2.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

