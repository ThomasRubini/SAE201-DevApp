package fr.univ_amu.iut.fp;

import fr.univ_amu.iut.dao.DAO;
import fr.univ_amu.iut.model.Ressource;
import fr.univ_amu.iut.model.Thematique;
import fr.univ_amu.iut.view.map.France;
import fr.univ_amu.iut.view.map.FranceBuilder;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    France france;

    @FXML
    private Pane stackPaneFrance;

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

    /*<Button layoutX="38.0" layoutY="30.0" mnemonicParsing="false" prefHeight="115.0" prefWidth="235.0" style="-fx-background-radius: 30; -fx-background-color: #ff6e40#ff6e40;" text="Button" />
                        <Button layoutX="332.0" layoutY="30.0" mnemonicParsing="false" prefHeight="115.0" prefWidth="235.0" style="-fx-background-radius: 30; -fx-background-color: #ff6e40#ff6e40;" text="Button" />*/
@FXML
private AnchorPane matiere;

private Button initButton(){

}
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initFrance();
        stackPaneFrance.getChildren().add(france);
        DAO<Thematique> theme = new DAO<Thematique>();
        try {
            theme.findAll();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        DAO<Ressource> ressource = new DAO<Ressource>();
        try {
            theme.findAll();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
