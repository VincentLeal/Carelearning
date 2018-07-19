package controller;

import controller.dialog.DisplayView;
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
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created on 23/06/2018.
 */
public final class LessonOverviewController extends Application implements Initializable {
    private Desktop desktop = Desktop.getDesktop();

    private TransitionView transitionView = new TransitionView();
    private String fxmlBackScene = "/fxml/MainController.fxml";
    private String fxmlBackSceneTitle = "Menu principal";

    private DisplayView displayView = new DisplayView();

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

        chooseFileButton.setOnAction(event -> {
            System.out.println("button pressed");
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                try {
                    openFile(file);
                    displayView.dialog("/fxml/dialog/success/ConfirmUploadLesson.fxml", "Leçon enregistrée");
                } catch (IOException e) {
                    displayView.dialog("/fxml/dialog/error/FileErrorDialog.fxml", "Oups !");
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void start(final Stage stage) {
        openFile();
    }

    private void openFile(File csvFile) throws IOException {
        CsvMapper csvMapper = new CsvMapper();
        csvMapper.readCsv(csvFile);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        goBackButton.setOnAction(event -> transitionView.goBackButton(anchorPane, fxmlBackScene, fxmlBackSceneTitle, 320.0, 500.0));
    }
}

