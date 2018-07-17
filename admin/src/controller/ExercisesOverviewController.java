package controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import sun.security.krb5.internal.PAData;
import tool.TransitionView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ExercisesOverviewController extends Application implements Initializable {
    private TransitionView transitionView = new TransitionView();

    private String fxmlBackScene = "/fxml/MainController.fxml";

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button medicalTerminology;

    @FXML
    private Button prefixAndSuffix;

    @FXML
    private Label doseCalculation;

    @FXML
    private Label scheme;

    @FXML
    private Button goBackButton;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/exercises/ExercisesOverviewController.fxml"));
        Scene scene =  new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        goBackButton.setOnAction(event -> transitionView.goBackButton(anchorPane, fxmlBackScene, 300.0, 500.0));
    }

    @FXML
    private void medicalTerminologyExercise(ActionEvent event) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("/fxml/exercises/MedicalTerminologyOverviewController.fxml"));
        Scene scene = new Scene(page);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void prefixAndSuffixExercise(ActionEvent event) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("/fxml/exercises/PrefixAndSuffixOverviewController.fxml"));
        Scene scene = new Scene(page);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void doseCalculationExercise(ActionEvent event) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("/fxml/exercises/DoseCalculationOverviewController.fxml"));
        Scene scene = new Scene(page);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void schemeExercise(ActionEvent event) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("/fxml/exercises/SchemeOverviewController.fxml"));
        Scene scene = new Scene(page);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }
}

