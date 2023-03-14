package hftm.ch.controllers;

import java.util.List;

import hftm.ch.models.Ortschaft;
import hftm.ch.utils.Repository;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;

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
        List<Ortschaft> list = Repository.getOrtschaften();
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
        Repository.load();
        String ort = textFieldOrt.getText();
        String plz = textFieldPlz.getText();
        Ortschaft ortschaft = new Ortschaft();
        ortschaft.setOrt(ort);
        ortschaft.setPlz(plz);
        ortschaften.add(ortschaft);
        Ortschaft repoOrtschaft = Repository.newOrtschaft();
        repoOrtschaft.setOrt(ort);
        repoOrtschaft.setPlz(plz);
        Repository.addOrtschaft(repoOrtschaft);
        textFieldOrt.clear();
        textFieldPlz.clear();
        Repository.save();
    }

    @FXML
    private void deleteOrtschaft() {
        tableViewOrtschaft.getItems().removeAll(
            tableViewOrtschaft.getSelectionModel().getSelectedItems()
        );
    }

}
