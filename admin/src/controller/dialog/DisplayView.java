package controller.dialog;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created on 19/07/2018.
 */
public class DisplayView {
    public void dialog(String fxmlToLoad, String title) {
        try {
            Parent page = FXMLLoader.load(getClass().getResource(fxmlToLoad));
            Scene scene = new Scene(page);

            Stage stage = new Stage();

            stage.setTitle(title);

            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void window(String fxmlToLoad, String title, ActionEvent event) {
        try {
            Parent page = FXMLLoader.load(getClass().getResource(fxmlToLoad));
            Scene scene = new Scene(page);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setTitle(title);

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
