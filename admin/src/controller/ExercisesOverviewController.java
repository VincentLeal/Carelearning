package controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


import java.awt.event.ActionEvent;
import java.io.IOException;

public class ExercisesOverviewController extends Application {
    @FXML
    private Button medicalTerminology;

    @FXML
    private Label prefixAndSuffix;

    @FXML
    private Label doseCalculation;

    @FXML
    private Label scheme;

    @Override
    public void start(Stage primaryStage) throws Exception {
        medicalTerminology.setStyle("-fx-background-color: transparent;");

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/exercises/ExercisesOverviewController.fxml"));
        Scene scene =  new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    @FXML
    private void medicalTerminologyExercise(javafx.event.ActionEvent event) throws IOException {
       // medicalTerminology.setOnAction(event -> System.out.println("Préfixe et suffixe"));

        Parent displayMedicalTerminologyPage = FXMLLoader.load(getClass().getResource("/fxml/exercises/MedicalTerminologyOverviewController.fxml"));
        Scene displayMedicalTerminologyScene = new Scene(displayMedicalTerminologyPage);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(displayMedicalTerminologyScene);
        stage.show();
    }

    @FXML
    private void prefixAndSuffixExercice() {
        prefixAndSuffix.setOnMouseClicked(event -> System.out.println("Préfixe et suffixe"));

    }

    @FXML
    private void doseCalculationExercise() {
        doseCalculation.setOnMouseClicked(event -> System.out.println("Calcul de deose"));

    }

    @FXML
    private void schemeExercice() {
        scheme.setOnMouseClicked(event -> System.out.println("Schéma"));

    }
}

