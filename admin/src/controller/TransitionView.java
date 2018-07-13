package controller;

import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

/*
 Created on 13/07/2018.
 */

public class TransitionView {
    public void goBackButton(AnchorPane anchorPane, String fxml, double width, double height) {
        makeFadeOut(anchorPane, fxml, width, height);
    }

    private void makeFadeOut(AnchorPane anchorPane, String fxml, double width, double height) {
        FadeTransition fadeTransition = new FadeTransition();

        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(anchorPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);

        fadeTransition.setOnFinished(event -> {
            try {
                loadBackScene(anchorPane, fxml, width, height);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        fadeTransition.play();
    }

    private void loadBackScene(AnchorPane anchorPane, String fxml, double width, double height) throws IOException {
        Parent parent;
        parent = FXMLLoader.load(getClass().getResource(fxml));

        Scene scene = new Scene(parent, width, height);
        Stage stage = (Stage) anchorPane.getScene().getWindow();

        stage.setScene(scene);
        stage.show();


    }
}
