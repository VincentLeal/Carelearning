package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created on 22/05/2018.
 */
public class MainView extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainController.fxml"));

        Scene scene = new Scene(root);

        primaryStage.setTitle("Menu principal");

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
