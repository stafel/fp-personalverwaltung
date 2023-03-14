package hftm.ch;

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
        launch();
    }
}
