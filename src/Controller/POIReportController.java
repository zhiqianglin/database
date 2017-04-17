package Controller;

import Model.POIReport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Created by zlin on 4/14/17.
 */
public class POIReportController {
    public TableColumn locationNameCol;
    public TableColumn cityCol;
    public TableColumn stateCol;
    public TableColumn moldMinCol;
    public TableColumn moldAvgCol;
    public TableColumn moldMaxCol;
    public TableColumn aqMinCol;
    public TableColumn aqAvgCol;
    public TableColumn aqMaxCol;
    public TableColumn numDataPointCol;
    public TableColumn flaggedCol;
    public TableView reportTable;
    ObservableList<POIReport> report = FXCollections.observableArrayList();


    public void initialize() {
        //TODO: get the values of the locations DYNAMICALLY, UPDATE report


        locationNameCol.setCellValueFactory(new PropertyValueFactory<POIReport, String>("locationName"));
        cityCol.setCellValueFactory(new PropertyValueFactory<POIReport, String>("city"));
        stateCol.setCellValueFactory(new PropertyValueFactory<POIReport, String>("state"));
        flaggedCol.setCellValueFactory(new PropertyValueFactory<POIReport, Boolean>("flagged"));
        moldMinCol.setCellValueFactory(new PropertyValueFactory<POIReport, Double>("moldMin"));
        moldMaxCol.setCellValueFactory(new PropertyValueFactory<POIReport, Double>("moldMax"));
        moldAvgCol.setCellValueFactory(new PropertyValueFactory<POIReport, Double>("moldAvg"));
        aqMinCol.setCellValueFactory(new PropertyValueFactory<POIReport, Double>("aqMin"));
        aqMaxCol.setCellValueFactory(new PropertyValueFactory<POIReport, Double>("aqMax"));
        aqAvgCol.setCellValueFactory(new PropertyValueFactory<POIReport, Double>("aqAvg"));
        numDataPointCol.setCellValueFactory(new PropertyValueFactory<POIReport, Integer>("numOfDataPoint"));
        reportTable.setItems(report);

        report.add(new POIReport("Georgia Tech", "Atlanta", "Georgia", 2, 43.1, 160, 3, 33.4, 84,
                52, false));


    }

    public void back(ActionEvent actionEvent) {

        Helper.changeScene(actionEvent, this.getClass(), Helper.CHOOSE_FUNCTIONALITY_CITY_OFFICIAL);
    }
}
