package Model;

import javafx.beans.property.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by zlin on 4/15/17.
 */
public class DataPoint {

//    public TextField dataValue;
//    public ChoiceBox locationNames;
//    public ChoiceBox dataType;
//    public DatePicker date;
//    public JFXTimePicker time;

    private final SimpleStringProperty locationName;
    private final SimpleStringProperty dataType;
    private final SimpleIntegerProperty dataValue;
    private final SimpleObjectProperty<LocalDateTime> dateTime;
    private SimpleBooleanProperty selected;

    public DataPoint(String locationName, LocalDateTime dateTime, String dataType, int dataValue) {
        this.locationName = new SimpleStringProperty(locationName);
        this.dataType = new SimpleStringProperty(dataType);
        this.dataValue = new SimpleIntegerProperty(dataValue);
        this.dateTime = new SimpleObjectProperty<LocalDateTime>(dateTime);
        this.selected = new SimpleBooleanProperty();
    }

    public String getLocationName() {
        return locationName.get();
    }

    public String getDataType() {
        return dataType.get();
    }

    public Integer getDataValue() {
        return dataValue.get();
    }

    public LocalDateTime getDateTime() {
        return dateTime.get();
    }


//    public String getDateTime() {
//        return dateTime.get()
//                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
//    }


    public final BooleanProperty selectedProperty() {
        return this.selected;
    }


    public final boolean isSelected() {
        return this.selected.get();
    }
    public final void setSelected(final boolean selected) {
        this.selectedProperty().set(selected);
    }

}
