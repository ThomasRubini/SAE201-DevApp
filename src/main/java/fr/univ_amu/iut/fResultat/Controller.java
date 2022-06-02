package fr.univ_amu.iut.fResultat;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    private TableColumn<Utilisateur, String> Disciplines;

    @FXML
    private TableColumn<Utilisateur, String> Niveaux;

    @FXML
    private TableColumn<Utilisateur, String> Noms;

    @FXML
    private TableColumn<Utilisateur, Integer> Numéro;

    @FXML
    private TableView<Utilisateur> Table;

    @FXML
    private TableColumn<Utilisateur, String> Types;

    ObservableList<Utilisateur> list = FXCollections.observableArrayList(
            new Utilisateur(1,"Patrik","Maht","Blog","Terminal"),
            new Utilisateur(2,"Mark","Chimie","Site","Seconde")
     );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Noms.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("Noms"));
        Numéro.setCellValueFactory(new PropertyValueFactory<Utilisateur, Integer>("Numéro"));
        Disciplines.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("Disciplines"));
        Types.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("Types"));
        Niveaux.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("Niveaux"));

        Table.setItems(list);


    }
}
