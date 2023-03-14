package hftm.ch;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
}
