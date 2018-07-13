package controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import tool.CsvMapper;
import tool.TransitionView;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created on 23/06/2018.
 */
public final class LessonOverviewController extends Application implements Initializable {
    private Desktop desktop = Desktop.getDesktop();

    private TransitionView transitionView = new TransitionView();
    private String fxmlBackScene = "/fxml/MainController.fxml";

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button chooseFileButton;

    @FXML
    private Button goBackButton;

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        goBackButton.setOnAction(event -> transitionView.goBackButton(anchorPane, fxmlBackScene, 300.0, 500.0));
    }
}

