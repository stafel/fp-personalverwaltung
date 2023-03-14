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
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getHomeplace() {
        return homeplace;
    }
    public void setHomeplace(String homeplace) {
        this.homeplace = homeplace;
    }
    public List<Adresse> getAdressen() {
        return adressen;
    }
    public void setAdressen(List<Adresse> adressen) {
        this.adressen = adressen;
    }
}
