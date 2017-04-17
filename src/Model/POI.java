package Model;

import javafx.beans.property.*;
import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by zlin on 4/15/17.
 */
public class POI {

    private final SimpleStringProperty locationName;
    private final SimpleStringProperty city;
    private final SimpleStringProperty state;
    private final SimpleIntegerProperty zipCode;
    private SimpleBooleanProperty flagged;
    private SimpleObjectProperty<LocalDate> dateFlagged;

    public POI(String locationName, String city, String state, int zipCode) {
        this.locationName = new SimpleStringProperty(locationName);
        this.city = new SimpleStringProperty(city);
        this.state = new SimpleStringProperty(state);
        this.zipCode = new SimpleIntegerProperty(zipCode);
        this.flagged = new SimpleBooleanProperty();
        this.dateFlagged = new SimpleObjectProperty<>(null);
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

    public int getZipCode() {
        return zipCode.get();
    }


    public final BooleanProperty selectedProperty() {
        return this.flagged;
    }


    public final boolean isFlagged() {
        return this.flagged.get();
    }
    public final void setFlagged(final boolean flagged) {
        this.selectedProperty().set(flagged);
    }

    public LocalDate getDateFlagged() {
        return this.dateFlagged.get();
    }

    public void setDateFlagged(LocalDate dateFlagged) {
        this.dateFlagged.set(dateFlagged);
    }
    /*






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
     */

}
