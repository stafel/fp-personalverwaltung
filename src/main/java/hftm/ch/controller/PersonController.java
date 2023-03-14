package hftm.ch.controller;

import hftm.ch.models.Ortschaft;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;

public class PersonController {

    @FXML
    private AnchorPane AnchorPaneAdresse;

    @FXML
    private Label LableTitel;

    @FXML
    private TableColumn<?, ?> TableColumnStrasse;

    @FXML
    private TableColumn<?, ?> TableColumnOrtschaft;

    @FXML
    private TableColumn<?, ?> TableColumnNummer;

    @FXML
    private TableColumn<?, ?> TableColumnTo;

    @FXML
    private TableView<?> TableViewAdresse;

    @FXML
    private TableColumn<?, ?> TableColumnFrom;

    private StringProperty strasse;

    private StringProperty nummer;

    private Date validFrom;

    private Date validTo;

    private Ortschaft ortschaft;

    public PersonController() throws IOException {
    }
    String path = "AdressePersonView.fxml";

    URL location = ClassLoader.getSystemClassLoader().getResource(path);

    FXMLLoader fxmlLoader = new FXMLLoader(location);
    Parent root = fxmlLoader.load();
    Stage stage = new Stage();
    Scene scene = new Scene(root, 600, 600);

    public void initialized() {
        setAdressView(strasse, nummer, validFrom, validTo, ortschaft);
    }

    public void setAdressView(StringProperty strasse, StringProperty nummer, Date validFrom, Date validTo, Ortschaft ortschaft) {
        TableColumnOrtschaft.setText(ortschaft.toString());
        TableColumnStrasse.setText(ortschaft.toString());
        TableColumnNummer.setText(nummer.toString());
        TableColumnTo.setText(validTo.toString());
        TableColumnFrom.setText(validFrom.toString());
    }
}


