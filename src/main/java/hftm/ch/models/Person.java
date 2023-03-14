package hftm.ch.models;

import java.util.List;

import javafx.beans.property.StringProperty;

public class Person {
    StringProperty lastname;
    StringProperty name;
    StringProperty birthday;
    StringProperty homeplace;
    List<Adresse> adressen;
}
