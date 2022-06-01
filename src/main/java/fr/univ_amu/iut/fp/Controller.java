package fr.univ_amu.iut.fp;

import fr.univ_amu.iut.view.map.France;
import fr.univ_amu.iut.view.map.FranceBuilder;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initFrance();
        stackPaneFrance.getChildren().add(france);
    }
}
