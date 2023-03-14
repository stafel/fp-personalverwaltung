package hftm.ch;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import hftm.ch.models.Ortschaft;
import hftm.ch.utils.Repository;

public class App extends Application
{
    private Stage stage;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        showMainView();
    }

    public void showMainView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource("MainView.fxml"));

        // Show the scene containing the root layout.
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();

        loader.getController();
    }

    public static void testRepository() {
        Repository.load();

        // add ortschaft
        Ortschaft ort = Repository.newOrtschaft();
        ort.setOrt("Grenchen");
        ort.setPlz("2540");
        Repository.addOrtschaft(ort);
        System.out.println(ort.getId());

        ort = Repository.newOrtschaft();
        ort.setOrt("Solothurn");
        ort.setPlz("Wasauchimmer");
        Repository.addOrtschaft(ort);
        System.out.println(ort.getId());

        ort = Repository.newOrtschaft();
        ort.setOrt("Bettlach");
        ort.setPlz("2520?");
        Repository.addOrtschaft(ort);
        System.out.println(ort.getId());

        // delete ortschaft
        Ortschaft toDelete = Repository.getOrtschaftById(1L);
        System.out.println(toDelete.getOrt());
        Repository.removeOrtschaft(toDelete);
        System.out.println();

        // save and reload
        Repository.save();
        Repository.load();

        // get all ortschaften
        for (Ortschaft o: Repository.getOrtschaften()) {
            System.out.println(o.getOrt());
        }
    }
}