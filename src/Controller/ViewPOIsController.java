package Controller;

import DAO.CityStateDAO;
import DAO.POIDAO;
import Model.POI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Date;

/**
 * Created by zlin on 4/14/17.
 */
public class ViewPOIsController {
    public TextField zipCode;
    public ChoiceBox locationName;
    public ChoiceBox city;
    public ChoiceBox state;
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
        ObservableList<String> locationNames = null;
        ObservableList<String> cities = null;
        ObservableList<String> states = null;
        try {
            locationNames = FXCollections.observableList(POIDAO.queryAllLocationNames());
        } catch (Exception e) {
            Helper.showAlert("Error", "Unable to retrieve location names from database.\n" + e.getMessage());

        }
        locationName.setItems(locationNames);
//        locationName.getSelectionModel().selectFirst();

        //TODO: get the city

        try {
            cities = FXCollections.observableList(CityStateDAO.queryAllCity());
        } catch (Exception e) {
            Helper.showAlert("Error", "Unable to retrieve location names from database.\n" + e.getMessage());

        }
//        cities.add(0, null);
        city.setItems(cities);
//        city.getItems().addAll("Atlanta", "Marietta");
//        city.getSelectionModel().selectFirst();

        //TODO: get the state


        try {
            states = FXCollections.observableList(CityStateDAO.queryAllState());
        } catch (Exception e) {
            Helper.showAlert("Error", "Unable to retrieve location names from database.\n" + e.getMessage());

        }
        state.setItems(states);


        locationNameCol.setCellValueFactory(new PropertyValueFactory<POI, String>("locationName"));
        cityCol.setCellValueFactory(new PropertyValueFactory<POI, String>("city"));
        stateCol.setCellValueFactory(new PropertyValueFactory<POI, String>("state"));
        zipCodeCol.setCellValueFactory(new PropertyValueFactory<POI, Integer>("zipCode"));
        flaggedCol.setCellValueFactory(new PropertyValueFactory<POI, Boolean>("flagged"));
        //TODO: UPDATE THE DATE
        dateFlaggedCol.setCellValueFactory(new PropertyValueFactory<POI, Date>(""));

        filteredTable.setItems(data);



    }

    //TODO: Communicate with the database
    public void applyFilter(ActionEvent actionEvent) {
        System.out.println(locationName.getValue());
        System.out.println(city.getValue());
        System.out.println(state.getValue());
        System.out.println(flagged.isSelected());
        System.out.println(dataFlaggedMax.getValue());
        System.out.println(dataFlaggedMin.getValue());

//        data.add(new POI("Georgia Tech", "Atlanta", "GA", 30318));

    }

    public void resetFilter(ActionEvent actionEvent) {
//        data.add(new POI("Cheetah", "Atlanta", "GA", 30318));
    }


    public void back(ActionEvent actionEvent) {
        Helper.changeScene(actionEvent, this.getClass(), Helper.CHOOSE_FUNCTIONALITY_CITY_OFFICIAL);
    }
}
