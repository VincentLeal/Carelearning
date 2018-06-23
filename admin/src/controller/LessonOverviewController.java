package controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created on 23/06/2018.
 */
public final class LessonOverviewController extends Application {
    private Desktop desktop = Desktop.getDesktop();

    @FXML
    Button chooseFileButton;

    @FXML
    private void openFile(){
        final FileChooser fileChooser = new FileChooser();

        Stage stage = new Stage();

        chooseFileButton.setOnAction(e -> {
            System.out.println("button pressed");
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                openFile(file);
            }
        });
    }

    @Override
    public void start(final Stage stage) {
        openFile();
    }

    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
                    LessonOverviewController.class.getName()).log(
                    Level.SEVERE, null, ex
            );
        }
    }

}

