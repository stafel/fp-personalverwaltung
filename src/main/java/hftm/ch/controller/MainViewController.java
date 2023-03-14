package hftm.ch.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class MainViewController implements Initializable {

    @FXML
    MenuItem miPrint;

    @FXML
    MenuItem miQuit;

    @FXML
    TabPane tbMain;

    @FXML
    Tab tInhabitants;

    @FXML
    Tab tPlaces;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }
    
}
