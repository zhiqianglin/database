package Controller;

import javafx.event.ActionEvent;

/**
 * Created by zlin on 4/14/17.
 */
public class AddLocationController {


    public void back(ActionEvent actionEvent) {
        Helper.changeScene(actionEvent, this.getClass(), Helper.CITY_SCIENTIST);
    }

    public void submit(ActionEvent actionEvent) {
    }
}
