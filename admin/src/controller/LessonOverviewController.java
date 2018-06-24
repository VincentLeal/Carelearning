package controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import tool.CsvMapper;
import tool.CsvReader;

import java.awt.*;
import java.io.*;
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
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter(".csv files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(extensionFilter);

        Stage stage = new Stage();

        chooseFileButton.setOnAction(e -> {
            System.out.println("button pressed");
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                try {
                    openFile(file);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    @Override
    public void start(final Stage stage) {
        openFile();
    }

    private void openFile(File file) throws IOException {
        CsvMapper csvMapper = new CsvMapper();
        csvMapper.readCsv();
    }


}

