package hftm.ch.models;

import java.sql.Date;
import java.util.List;
import java.io.Serializable;
import java.io.Externalizable;

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

public class Adresse implements Serializable {
    static final long serialVersionUID = 42L;

	private Long id = 1L;

    String strasse;
    String nummer;
    Date validFrom;
    Date validTo;
    Ortschaft ortschaft;

    public Adresse() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public Ortschaft getOrtschaft() {
        return ortschaft;
    }

    public void setOrtschaft(Ortschaft ortschaft) {
        this.ortschaft = ortschaft;
    }

    
}
