package hftm.ch.models;

import java.sql.Date;
import java.util.List;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import javafx.beans.property.StringProperty;

public class Ortschaft implements Serializable {
    @Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "ORDID")
	private Long id;

    private StringProperty plz;
    private StringProperty ort;

    public Ortschaft() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StringProperty getPlz() {
        return plz;
    }

    public void setPlz(StringProperty plz) {
        this.plz = plz;
    }

    public StringProperty getOrt() {
        return ort;
    }

    public void setOrt(StringProperty ort) {
        this.ort = ort;
    }

    
}
