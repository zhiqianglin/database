package Model;

import javafx.beans.property.*;

/**
 * Created by zlin on 4/15/17.
 */
public class POIReport {

    private final SimpleStringProperty locationName;
    private final SimpleStringProperty city;
    private final SimpleStringProperty state;
    private final SimpleDoubleProperty moldMin;
    private final SimpleDoubleProperty moldAvg;
    private final SimpleDoubleProperty moldMax;
    private final SimpleDoubleProperty aqMin;
    private final SimpleDoubleProperty aqAvg;
    private final SimpleDoubleProperty aqMax;
    private final SimpleIntegerProperty numOfDataPoint;
    //TODO: USE STRING?
    private SimpleBooleanProperty flagged;

    public POIReport(String locationName, String city, String state,
                       double moldMin, double moldAvg, double moldMax,
                       double AQMin, double AQAvg, double AQMax, int numOfDataPoint,
                       boolean flagged) {
        this.locationName = new SimpleStringProperty(locationName);
        this.city = new SimpleStringProperty(city);
        this.state = new SimpleStringProperty(state);
        this.moldMin = new SimpleDoubleProperty(moldMin);
        this.moldAvg = new SimpleDoubleProperty(moldAvg);
        this.moldMax = new SimpleDoubleProperty(moldMax);
        this.aqMin = new SimpleDoubleProperty(AQMin);
        this.aqAvg = new SimpleDoubleProperty(AQAvg);
        this.aqMax = new SimpleDoubleProperty(AQMax);
        this.numOfDataPoint = new SimpleIntegerProperty(numOfDataPoint);
        this.flagged = new SimpleBooleanProperty(flagged);
    }


    public String getLocationName() {
        return locationName.get();
    }

    public String getCity() {
        return city.get();
    }

    public String getState() {
        return state.get();
    }

    public Double getMoldMin() {
        return moldMin.get();
    }
    public Double getMoldAvg() {
        return moldAvg.get();
    }
    public Double getMoldMax() {
        return moldMax.get();
    }
    public Double getAqMin() {
        return aqMin.get();
    }

    public Double getAqAvg() {
        return aqAvg.get();
    }
    public Double getAqMax(){
        return aqMax.get();
    }

    public Integer getNumOfDataPoint() {
        return this.numOfDataPoint.get();
    }

    public final boolean isFlagged() {
        return this.flagged.get();
    }

}
