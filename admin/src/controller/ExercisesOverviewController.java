package controller;

import controller.dialog.DisplayView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tool.TransitionView;

import java.net.URL;
import java.util.ResourceBundle;

public class ExercisesOverviewController extends Application implements Initializable {
    private TransitionView transitionView = new TransitionView();
    private String fxmlBackScene = "/fxml/MainController.fxml";
    private String fxmlBackSceneTitle = "Menu principal";

    private DisplayView displayView = new DisplayView();

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button goBackButton;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/exercises/ExercisesOverviewController.fxml"));
        Scene scene =  new Scene(root);

        primaryStage.setTitle("Exercices");

        primaryStage.setScene(scene);

        primaryStage.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        goBackButton.setOnAction(event -> transitionView.goBackButton(anchorPane, fxmlBackScene, fxmlBackSceneTitle, 320.0, 500.0));
    }

    @FXML
    private void medicalTerminologyExercise(ActionEvent event) {
        displayView.window("/fxml/exercises/MedicalTerminologyOverviewController.fxml", "Terminologie médicale", event);
    }

    @FXML
    private void prefixAndSuffixExercise(ActionEvent event) {
        displayView.window("/fxml/exercises/PrefixAndSuffixOverviewController.fxml", "Préfixe et suffixe", event);
    }

    @FXML
    private void doseCalculationExercise(ActionEvent event) {
        displayView.window("/fxml/exercises/DoseCalculationOverviewController.fxml", "Calcul de dose", event);
    }

    @FXML
    private void schemeExercise(ActionEvent event) {
        displayView.window("/fxml/exercises/SchemeOverviewController.fxml", "Schémas", event);
    }
}

