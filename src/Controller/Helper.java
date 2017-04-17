package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by zlin on 4/13/17.
 */
public class Helper {

    private final static String PATH = "../fxml/";
    public static final String REGISTER = "registration.fxml";
    public static final String LOGIN = "login.fxml";

    public static void changeScene(ActionEvent actionEvent, Class c, String view) {
        try {
            Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

//        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/registration.fxml"));
            Parent root = FXMLLoader.load(c.getResource(PATH + view)); // Path

            Scene scene = new Scene(root);

            stageTheEventSourceNodeBelongs.setScene(scene);
            stageTheEventSourceNodeBelongs.show();
        }
        catch (IOException e) {
            showAlert("Error", "View not found");
        }
    }

    public static void showAlert(String title, String info){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(info);

        alert.showAndWait();

    }
}
