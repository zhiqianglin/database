import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

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
        Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

//        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/registration.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("sample/fxml/registration.fxml"));

        Scene scene = new Scene(root);

        stageTheEventSourceNodeBelongs.setScene(scene);
        stageTheEventSourceNodeBelongs.show();



//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 600, 400));
//        primaryStage.show();
    }
}
