package fr.univ_amu.iut.screenController;

import java.util.HashMap;

import javafx.scene.*;
import javafx.scene.layout.Pane;

public class ScreenController {
    private static HashMap<String, Pane> screenMap = new HashMap<>();
    private static Scene main;

    public ScreenController(Scene main) {
        ScreenController.main = main;
    }

    public static void addScreen(String name, Pane pane){
        screenMap.put(name, pane);
    }

    public static void activate(String name){
        main.setRoot( screenMap.get(name) );
    }
}
