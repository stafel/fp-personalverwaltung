package hftm.ch;

import hftm.ch.models.Ortschaft;
import hftm.ch.utils.Repository;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/places.fxml"));
        // System.out.println(fxmlLoader.getLocation());
        Scene scene = new Scene(fxmlLoader.load());
        // Scene scene = new Scene(new FXMLLoader(App.class.getClassLoader().getResource("/view/places.fxml")).load());
        stage.setScene(scene);
        stage.show();
    }

    public static void main( String[] args ) {
        App.testRepository();
        launch();
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
