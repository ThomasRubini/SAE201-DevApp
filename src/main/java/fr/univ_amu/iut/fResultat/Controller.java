package fr.univ_amu.iut.fResultat;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        

        List<TableEntry> entries = new ArrayList<>();
        for (Usage usage: Donnees.getUsagesObtenus()){
            entries.add(new TableEntry(usage));
        }
        ObservableList<TableEntry> tableEntries = FXCollections.observableArrayList(entries);
        table.setItems(tableEntries);
        
        nom.setCellValueFactory(new PropertyValueFactory<TableEntry, String>("nom"));
        discipline.setCellValueFactory(new PropertyValueFactory<TableEntry, String>("discipline"));
        description.setCellValueFactory(new PropertyValueFactory<TableEntry, String>("description"));
        niveau.setCellValueFactory(new PropertyValueFactory<TableEntry, String>("niveau"));
        
    }

}
