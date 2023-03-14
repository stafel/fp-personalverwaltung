package hftm.ch.models;

import java.io.Serializable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Ortschaft implements Serializable {
    static final long serialVersionUID = 42L;

	private Long id;

    private String plz;
    private String ort;

    transient private StringProperty plzProperty = new SimpleStringProperty();
    transient private StringProperty ortProperty = new SimpleStringProperty();
    
    public StringProperty plzProperty() {
        return plzProperty;
    }


    public StringProperty ortProperty() {
        return ortProperty;
    }

    public Ortschaft() {

    }

    public Ortschaft(String ort, String plz) {
        this.plz = plz;
        this.ort = ort;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlz() {
        return plzProperty.get();
    }

    public void setPlz(String plz) {
        this.plzProperty.set(plz);

        this.plz = plz;
    }

    public String getOrt() {
        return ortProperty.get();
    }

    public void setOrt(String ort) {
        this.ortProperty.set(ort);

        this.ort = ort;
    }
}
