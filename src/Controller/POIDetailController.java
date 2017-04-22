package Controller;

import Model.DataPoint;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.Month;

/**
 * Created by zlin on 4/14/17.
 */
public class POIDetailController {


    public ChoiceBox dataType;
    public TextField dataValueMin;
    public TextField dataValueMax;
    public DatePicker dateMin;
    public DatePicker dateMax;
    public TableView dataTable;
    public TableColumn dataTypeCol;
    public TableColumn dataValueCol;
    public TableColumn dateTimeCol;
    ObservableList<DataPoint> data = FXCollections.observableArrayList();

    public void initialize() {
        //TODO: GET DYNAMIC DATA
        dataType.getItems().addAll("Mold", "Whatever");
        dataType.getSelectionModel().selectFirst();
        dataTypeCol.setCellValueFactory(new PropertyValueFactory<DataPoint, String>("dataType"));
        dataValueCol.setCellValueFactory(new PropertyValueFactory<DataPoint, Integer>("dataValue"));
        //TODO: UPDATE DATETIME FORMAT
        dateTimeCol.setCellValueFactory(new PropertyValueFactory<DataPoint, LocalDateTime>("dateTime"));
        dataTable.setItems(data);


    }
    public void applyFilter(ActionEvent actionEvent) {

        //TODO: USE DYNAMIC DATA

        data.add(new DataPoint("Atlanta", Timestamp.valueOf(LocalDateTime.now()), "mold", 123));
        data.add(new DataPoint("Roswell", Timestamp.valueOf(LocalDateTime.of(2013, Month.JUNE, 15, 11, 32))
                , "mole", 456));
        data.add(new DataPoint("Dunwoody", Timestamp.valueOf(LocalDateTime.of(2013, Month.APRIL, 29, 10, 39))
                , "air", 456));
        data.add(new DataPoint("Marietta", Timestamp.valueOf(LocalDateTime.of(2017, Month.JANUARY, 13, 9, 40))
                , "air", 456));
    }

    public void resetFilter(ActionEvent actionEvent) {
    }

    public void back(ActionEvent actionEvent) {
        Helper.changeScene(actionEvent, this.getClass(), Helper.CHOOSE_FUNCTIONALITY_CITY_OFFICIAL);
    }

    public void flag(ActionEvent actionEvent) {
    }
}
