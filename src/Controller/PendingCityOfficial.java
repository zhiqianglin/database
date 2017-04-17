package Controller;

import javafx.event.ActionEvent;

/**
 * Created by zlin on 4/14/17.
 */
public class PendingCityOfficial {
    public void back(ActionEvent actionEvent) {
        Helper.changeScene(actionEvent, this.getClass(), Helper.CHOOSE_FUNCTIONALITY_ADMIN);
    }

    public void reject(ActionEvent actionEvent) {
    }

    public void accept(ActionEvent actionEvent) {
    }
}
