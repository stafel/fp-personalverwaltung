module hftm.ch {
    requires java.logging;
    requires javafx.controls;
    requires javafx.base;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.xml;
    requires java.sql;
    requires java.persistence;
    requires org.hibernate.orm.core;

    opens hftm.ch;

    opens hftm.ch.controllers to javafx.fxml;
}