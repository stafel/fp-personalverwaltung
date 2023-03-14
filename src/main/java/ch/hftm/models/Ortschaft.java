package ch.hftm.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Ortschaft {
    private final StringProperty plz = new SimpleStringProperty();
    private final StringProperty ort = new SimpleStringProperty();

    public Ortschaft(String ort, String plz) {
        this.plz.set(plz);
        this.ort.set(ort);
    }

    public String getPlz() {
        return plz.get();
    }
    public void setPlz(String plz) {
        this.plz.set(plz);
    }
    public String getOrt() {
        return ort.get();
    }
    public void setOrt(String ort) {
        this.ort.set(ort);
    }

    public StringProperty plzProperty() {
        return plz;
    }

    public StringProperty ortProperty() {
        return ort;
    }

    
}
