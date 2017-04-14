package sample.Controller;

import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import sample.Model.User;

import sample.DAO.userDAO;


public class RegisterController {
    @FXML
    private TextField username;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField password2;
    @FXML
    private MenuButton userType;
    @FXML
    private MenuButton city;
    @FXML
    private MenuButton state;
    @FXML
    private TextField title;
    @FXML
    private Button create;

    @FXML
    public void handleButtonClick(ActionEvent actionEvent) throws SQLException, ClassNotFoundException{
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
        User temp = new User(username.getText(), email.getText(), password.getText(), userType.getText(), city.getText(),
                            state.getText(), title.getText());
        String result = null;

        try {
            result = userDAO.insertUser(temp);
        } catch (SQLException e) {
            System.out.println("Problem occurred while inserting user: " + e);
        }

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(result);

        alert.showAndWait();
        return;
    }
}
