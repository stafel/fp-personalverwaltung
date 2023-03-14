package hftm.ch.models;

import java.util.List;
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

public class Person implements Serializable{
    static final long serialVersionUID = 42L;

	private Long id;
    
    String lastname;
    String name;
    String birthday;
    String homeplace;
    List<Adresse> adressen;

    public Person() {

    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    } /*
    public StringProperty getLastname() {
        return lastname;
    }
    public void setLastname(StringProperty lastname) {
        this.lastname = lastname;
    }
    public StringProperty getName() {
        return name;
    }
    public void setName(StringProperty name) {
        this.name = name;
    }
    public StringProperty getBirthday() {
        return birthday;
    }
    public void setBirthday(StringProperty birthday) {
        this.birthday = birthday;
    }
    public StringProperty getHomeplace() {
        return homeplace;
    }
    public void setHomeplace(StringProperty homeplace) {
        this.homeplace = homeplace;
    } */
    public List<Adresse> getAdressen() {
        return adressen;
    }
    public void setAdressen(List<Adresse> adressen) {
        this.adressen = adressen;
    }
}
