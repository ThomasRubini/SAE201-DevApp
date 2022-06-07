package fr.univ_amu.iut.fResultat;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import javafx.event.EventHandler;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import fr.univ_amu.iut.Donnees;
import fr.univ_amu.iut.model.Usage;

public class Controller implements Initializable{

    @FXML
    private TableView<TableEntry> table;

    @FXML
    private TableColumn<TableEntry, String> discipline;

    @FXML
    private TableColumn<TableEntry, String> niveau;

    @FXML
    private TableColumn<TableEntry, String> nom;

    @FXML
    private TableColumn<TableEntry, String> description;

    @FXML
    private TableColumn<TableEntry, String> fauxBoutons;

    @FXML
    private TabPane onglets;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        

        List<TableEntry> entries = new ArrayList<>();
        for (Usage usage: Donnees.getUsagesObtenus()){
            entries.add(new TableEntry(usage));
        }
        ObservableList<TableEntry> tableEntries = FXCollections.observableArrayList(entries);
        
        
        nom.setCellValueFactory(new PropertyValueFactory<TableEntry, String>("nom"));
        discipline.setCellValueFactory(new PropertyValueFactory<TableEntry, String>("discipline"));
        description.setCellValueFactory(new PropertyValueFactory<TableEntry, String>("description"));
        niveau.setCellValueFactory(new PropertyValueFactory<TableEntry, String>("niveau"));
        
        
        EventHandler<MouseEvent> selection = event ->{
            Donnees.setUsageSelectione(table.getSelectionModel().getSelectedItem().getUsage());
            Tab onglet;
            try {
                onglet = new Tab(Donnees.getUsageSelectione().getNom(),FXMLLoader.load(getClass().getResource("/fr/univ_amu/iut/detailResultats/detail.fxml")));
                onglets.getTabs().add(onglet);
            } catch (IOException e) {
                e.printStackTrace();
            }

           

        };
        table.setOnMouseClicked(selection);
        table.setItems(tableEntries);
    }

}
