package Controller;

import Model.POI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

/**
 * Created by zlin on 4/14/17.
 */
public class ViewPOIsController {
    public TextField zipCode;
    public ChoiceBox locationNames;
    public ChoiceBox cities;
    public ChoiceBox states;
    public CheckBox flagged;
    public DatePicker dataFlaggedMin;
    public DatePicker dataFlaggedMax;
    public TableColumn locationNameCol;
    public TableColumn cityCol;
    public TableColumn stateCol;
    public TableColumn zipCodeCol;
    public TableColumn flaggedCol;
    public TableColumn dateFlaggedCol;
    public TableView filteredTable;
    ObservableList<POI> data = FXCollections.observableArrayList();


    public void initialize() {
        //TODO: get the values of the locations DYNAMICALLY

        locationNames.getItems().addAll("Hello", "World");
        locationNames.getSelectionModel().selectFirst();

        //TODO: get the cities

        cities.getItems().addAll("Atlanta", "Marietta");
        cities.getSelectionModel().selectFirst();

        //TODO: get the states

        states.getItems().addAll("GA", "CA");
        states.getSelectionModel().selectFirst();

        locationNameCol.setCellValueFactory(new PropertyValueFactory<POI, String>("locationName"));
        cityCol.setCellValueFactory(new PropertyValueFactory<POI, String>("city"));
        stateCol.setCellValueFactory(new PropertyValueFactory<POI, String>("state"));
        zipCodeCol.setCellValueFactory(new PropertyValueFactory<POI, Integer>("zipCode"));
        flaggedCol.setCellValueFactory(new PropertyValueFactory<POI, Boolean>("flagged"));
        //TODO: UPDATE THE DATE
        dateFlaggedCol.setCellValueFactory(new PropertyValueFactory<POI, LocalDate>(""));

        filteredTable.setItems(data);



    }

    //TODO: Communicate with the database
    public void applyFilter(ActionEvent actionEvent) {
        System.out.println(locationNames.getValue());
        System.out.println(cities.getValue());
        System.out.println(states.getValue());
        System.out.println(flagged.isSelected());
        System.out.println(dataFlaggedMax.getValue());
        System.out.println(dataFlaggedMin.getValue());

        data.add(new POI("Georgia Tech", "Atlanta", "GA", 30318));

    }

    public void resetFilter(ActionEvent actionEvent) {
        data.add(new POI("Cheetah", "Atlanta", "GA", 30318));
    }


    public void back(ActionEvent actionEvent) {
    }
}
