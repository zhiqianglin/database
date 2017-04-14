package Controller;

import com.jfoenix.controls.JFXTimePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import java.time.LocalDate;
import java.time.LocalTime;

import com.jfoenix.controls.JFXDatePicker;


/**
 * Created by zlin on 4/13/17.
 */
public class AddDataPointController {

    public TextField dataValue;
    public ChoiceBox locationNames;
    public ChoiceBox dataType;
    public DatePicker date;
    public JFXTimePicker time;


    public void initialize() {
        //get the values of the locations DYNAMICALLY
        locationNames.getItems().addAll("Hello", "World");
        locationNames.getSelectionModel().selectFirst();

        //get the DataType Dynamically
        dataType.getItems().addAll("Mold", "Whatever");
        dataType.getSelectionModel().selectFirst();

        date.setValue(LocalDate.now());
        time.setValue(LocalTime.now());
//        checkInDatePicker.setValue(LocalDate.now());

    }

    public void submit(ActionEvent actionEvent) {
        try {
            int a = Integer.parseInt(dataValue.getText());
        }
        catch (Exception e){
            Helper.showAlert("Wrong value", "Please enter valid data value");
            return;
        }
        System.out.println(date.getClass());
        System.out.println(locationNames.getValue());
        System.out.println(dataType.getValue());
        System.out.println(dataValue.getText());
        System.out.println(time.getValue());
        //write to database


    }

    public void back(ActionEvent actionEvent) {
        System.out.println("Going back. To be implemented");
    }
}
