package hftm.ch.controllers;

import java.util.ArrayList;
import java.util.List;

import hftm.ch.models.Ortschaft;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class OrtschaftController {

    private static ObservableList<Ortschaft> ortschaften;

    @FXML
    private TableView<Ortschaft> tableViewOrtschaft;

    @FXML
    private TableColumn<Ortschaft, String> tableColumnOrt;

    @FXML
    private TableColumn<Ortschaft, String> tableColumnPlz;

    @FXML
    private TextField textFieldOrt;

    @FXML
    private TextField textFieldPlz;

    @FXML
    private void initialize() {
        List<Ortschaft> list = new ArrayList<>();
        ortschaften = FXCollections.observableList(list);

        tableViewOrtschaft.setItems(ortschaften);
        tableColumnOrt.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getOrt()));
        tableColumnOrt.setCellFactory(TextFieldTableCell.forTableColumn());
        tableColumnOrt.setOnEditCommit(
            new EventHandler<TableColumn.CellEditEvent<Ortschaft,String>>() {
                @Override
                public void handle(CellEditEvent<Ortschaft, String> t) {
                    ((Ortschaft) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setOrt(t.getNewValue());
                }
            }
        );
        tableColumnPlz.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getPlz()));
        tableColumnPlz.setCellFactory(TextFieldTableCell.forTableColumn());
        tableColumnPlz.setOnEditCommit(
            new EventHandler<TableColumn.CellEditEvent<Ortschaft,String>>() {
                @Override
                public void handle(CellEditEvent<Ortschaft, String> t) {
                    ((Ortschaft) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setPlz(t.getNewValue());
                }
            }
        );
    }

    @FXML
    private void addOrtschaft() {
        Ortschaft ortschaft = new Ortschaft();
        ortschaft.setOrt(textFieldOrt.getText());
        ortschaft.setPlz(textFieldPlz.getText());
        ortschaften.add(ortschaft);
        textFieldOrt.clear();
        textFieldPlz.clear();
    }

    @FXML
    private void deleteOrtschaft() {
        tableViewOrtschaft.getItems().removeAll(
            tableViewOrtschaft.getSelectionModel().getSelectedItems()
        );
    }

}
