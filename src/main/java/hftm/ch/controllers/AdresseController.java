package hftm.ch.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import hftm.ch.models.Adresse;
import hftm.ch.models.Ortschaft;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Date;

public class AdresseController {

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonDelete;

    @FXML
    private TextField inputBis;

    @FXML
    private TextField inputNummer;

    @FXML
    private TextField inputOrtschaft;

    @FXML
    private TextField inputStrasse;

    @FXML
    private TextField inputVon;

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

    private String strasse;

    private Integer nummer;

    private Date validFrom;

    private Date validTo;

    private Ortschaft ortschaft;

    private Adresse adresse;

    public AdresseController() throws IOException {
    }


    public void Adresse(String strasse, Integer nummer, Date validFrom, Date validTo, Ortschaft ortschaft) {
        this.strasse = strasse;
        this.nummer = nummer;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.ortschaft = ortschaft;
    }

    public void Adresse() {
    }

    public void initialized() throws IOException {
        setAdressView(strasse, nummer, validFrom, validTo, ortschaft);

        String path = "AdressPersonView.fxml";
        URL location = ClassLoader.getSystemClassLoader().getResource(path);
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root, 600, 600);
        stage.show();
    }

    public void setAdressView(String strasse, Integer nummer, Date validFrom, Date validTo, Ortschaft ortschaft) {
        TableColumnOrtschaft.setText(ortschaft.toString());
        TableColumnStrasse.setText(ortschaft.toString());
        TableColumnNummer.setText(nummer.toString());
        TableColumnTo.setText(validTo.toString());
        TableColumnFrom.setText(validFrom.toString());
    }

    public void buttonDeleteAdressAction(ActionEvent event) {
        TableViewAdresse.getItems().removeAll(
                TableViewAdresse.getSelectionModel().getSelectedItems()
        );



    }

    public void buttonAddAdressAction(ActionEvent event) {
        System.out.println(inputStrasse.getText());
        System.out.println(inputBis.getText());
        System.out.println(inputVon.getText());
        System.out.println(inputOrtschaft.getText());
        System.out.println(inputNummer.getText());
        Adresse.add(new Adresse(
                inputStrasse.getText(),
                inputBis.getText(),
                inputVon.getText(),
                inputNummer.getText()
        ));
        inputStrasse.clear();
        inputBis.clear();
        inputVon.clear();
        inputNummer.clear();
    }

}


