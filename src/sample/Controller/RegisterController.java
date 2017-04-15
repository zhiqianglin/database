package sample.Controller;

import java.sql.SQLException;
import java.util.*;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.event.*;
import sample.DAO.CityStateDAO;
import sample.Model.User;

import sample.DAO.UserDAO;


public class RegisterController {
    @FXML
    private Pane registration;
    @FXML
    private TextField username;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField password2;
    @FXML
    private ChoiceBox userType;
    @FXML
    private ChoiceBox city;
    @FXML
    private ChoiceBox state;
    @FXML
    private TextField title;
    @FXML
    private Button create;
    @FXML
    private Button cancel;

    @FXML
    private void initialize () throws SQLException, ClassNotFoundException{
//        registration.setMinHeight(600);
//        registration.setMaxWidth(400);
//        registration.setMinSize(400.0, 600.0);

        // Configuration for the state and city choice boxes.
        List<List<String>> inputState = CityStateDAO.findAllState();
        // Convert query result to a 1D LinkedList
        List<String> parsed_state = new LinkedList<>();
        ListIterator<List<String>> iter1 = inputState.listIterator();
        while (iter1.hasNext()) {
            ListIterator<String> iter2 = iter1.next().listIterator();
            while (iter2.hasNext()){
                parsed_state.add(iter2.next());
            }
        }
        // Fill the state choicebox
        ObservableList stateData = FXCollections.observableList(parsed_state);
        state.getItems().clear();
        state.setItems(stateData);
        state.getSelectionModel().selectFirst();

        // Get the default cities of the default state
        String curState = state.getSelectionModel().getSelectedItem().toString();
        List<List<String>> curCities = CityStateDAO.findAllCity(curState);
        // Convert query result to a 1D LinkedList
        List<String> parsed_cities = new LinkedList<>();
        iter1 = curCities.listIterator();
        while (iter1.hasNext()) {
            ListIterator<String> iter2 = iter1.next().listIterator();
            while (iter2.hasNext()){
                parsed_cities.add(iter2.next());
            }
        }
        // Fill the state choicebox
        ObservableList cityData = FXCollections.observableList(parsed_cities);
        city.getItems().clear();
        city.setItems(cityData);
        city.getSelectionModel().selectFirst();

        state.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                String curState = state.getItems().get((Integer) newValue).toString();
                List<List<String>> curCities = null;
                try {
                    curCities = CityStateDAO.findAllCity(curState);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                // Convert query result to a 1D LinkedList
                List<String> parsed_cities = new LinkedList<>();
                ListIterator<List<String>> iter1 = curCities.listIterator();
                while (iter1.hasNext()) {
                    ListIterator<String> iter2 = iter1.next().listIterator();
                    while (iter2.hasNext()){
                        parsed_cities.add(iter2.next());
                    }
                }
                // Fill the state choicebox
                ObservableList cityData = FXCollections.observableList(parsed_cities);
                city.getItems().clear();
                city.setItems(cityData);
                city.getSelectionModel().selectFirst();
            }
        });
    }

    /*
     *  The handler for the create button. Check the validity of each field and pass the
     *  new record into the database.
     */
    @FXML
    public void handleCreateClick() throws SQLException, ClassNotFoundException{

        // Check the validity of all input fields
        if (username.getText().trim().isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Username cannot be empty");

            alert.showAndWait();
            return;
        }
        if (email.getText().trim().isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Email cannot be empty");

            alert.showAndWait();
            return;
        }
        if (password.getText().trim().isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Password cannot be empty");

            alert.showAndWait();
            return;
        }
        if (password2.getText().trim().isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please confirm your password");

            alert.showAndWait();
            return;
        }
        if (!password.getText().equals(password2.getText())) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Passwords do not match. Please double check");

            alert.showAndWait();
            return;
        }

        User temp = new User(username.getText(), email.getText(), password.getText(), "Asd",
                            city.getSelectionModel().getSelectedItem().toString(),
                            state.getSelectionModel().getSelectedItem().toString(), title.getText());
        String result = null;

        // Insert the new user to database, return the result of the insertion
        try {
            result = UserDAO.insertUser(temp);
        } catch (SQLException e) {
            System.out.println("Problem occurred while inserting user: " + e);
        }

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(result);
        alert.showAndWait();

        if (result == "New record added")
            Platform.exit();
    }

    /*
     *  The handler for the cancel button. Simply close the window.
     */
    @FXML
    public void handleCancelClick() throws SQLException, ClassNotFoundException{
        Platform.exit();
    }
}
