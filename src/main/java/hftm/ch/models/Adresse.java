package hftm.ch.models;

import java.util.Date;

import javafx.beans.property.StringProperty;

public class Adresse {
    StringProperty strasse;
    StringProperty nummer;
    Date validFrom;
    Date validTo;
    Ortschaft ortschaft;
}
