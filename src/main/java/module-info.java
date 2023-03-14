module hftm.ch {
    requires java.logging;
    requires javafx.controls;
    requires javafx.base;
    requires javafx.fxml;
    requires javafx.graphics;

    opens hftm.ch;

    opens hftm.ch.controllers to javafx.fxml;
}