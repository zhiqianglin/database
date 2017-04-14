package Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;


/**
 * Created by zlin on 4/13/17.
 */
public class LoginController {

    public TextField username;
    public PasswordField password;

    public void login(ActionEvent actionEvent) {
        if (username.getText().equals("") || password.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Missing credentials");
            alert.setHeaderText("Please enter username and password.");
            alert.setContentText("Click register if you don't have an account.");

            alert.showAndWait();
        } else {

            System.out.println(username.getText());
            System.out.println(password.getText());
        }

    }

    public void register(ActionEvent actionEvent) throws IOException {
        System.out.println(this.getClass());
        Helper.changeScene(actionEvent, this.getClass());

    }
}
