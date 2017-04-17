package Controller;

import DAO.DBUtil;
import DAO.UserDAO;
import Model.User;
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
            alert.setHeaderText(null);
            alert.setContentText("Please enter username and password.\n\nRegister if you don't have an account.");

            alert.showAndWait();
            return;
        }


        System.out.println(username.getText());
        System.out.println(password.getText());
        User currUser = DAO.UserDAO.findUserByUsername(username.getText());
        if (currUser == null) {
            Helper.showAlert("Error", "No account found. Please enter valid information.");
        }
    }

    public void register(ActionEvent actionEvent) throws IOException {
        System.out.println(this.getClass());
        Helper.changeScene(actionEvent, this.getClass(), Helper.REGISTER);
    }
}
