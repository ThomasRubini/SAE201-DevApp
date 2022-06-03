package fr.univ_amu.iut.screenController;

import java.util.HashMap;

import javafx.scene.*;
import javafx.scene.layout.Pane;

public class ScreenController {
    private HashMap<String, Pane> screenMap = new HashMap<>();
    private Scene main;

    public ScreenController(Scene main) {
        this.main = main;
    }

    public void addScreen(String name, Pane pane){
         screenMap.put(name, pane);
    }

    public void activate(String name){
        main.setRoot( screenMap.get(name) );
    }
}
