package souvenirs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SouvenirsApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SouvenirsApplication.class.getResource("SouvenirsView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 625, 465);
        stage.setTitle("Сувеніри");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}