package controller.exercises;

import javafx.scene.control.ComboBox;
import tool.TransitionView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.scene.layout.AnchorPane;
import model.Exercise;
import service.ExerciseService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MedicalTerminologyOverviewController implements Initializable {
    private ExerciseService exerciseService = new ExerciseService();

    private TransitionView transitionView = new TransitionView();
    private String fxmlBackScene = "/fxml/exercises/ExercisesOverviewController.fxml";

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField questionInput;

    @FXML
    private TextField goodAnswerInput;

    @FXML
    private TextField choice1Input;

    @FXML
    private TextField choice2Input;

    @FXML
    private TextField choice3Input;

    @FXML
    private Button goBackButton;

    @FXML
    private ComboBox moduleBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        goBackButton.setOnAction(event -> transitionView.goBackButton(anchorPane, fxmlBackScene, 800.0, 500.0));

        moduleBox.getItems().addAll("Cancérologie","Cardio-vasculaire","Digestif",
                "Endocrino", "Gynécologie", "Infectieux et VIH","Ophtalmo","Neurologie",
                "ORL-Dermato-Stomato","Ortho-Traumato","Pédiatrie","Pneumologie",
                "Psychiatrie","Urgences-Réa-transfu","Urologie");
        moduleBox.getSelectionModel().select("Calcul de dose");


    }

    @FXML
    private void createNewMCQ() {
        String type = "QCM";
        String module = moduleBox.getValue().toString();


        Exercise mcqExercise = new Exercise(
                questionInput.getText(),
                goodAnswerInput.getText(),
                choice1Input.getText(),
                choice2Input.getText(),
                choice3Input.getText(),
                module,
                type
        );

        try {
            exerciseService.postExercise(mcqExercise);
        } catch (IOException e) {
            e.printStackTrace();
        }
        clearForm();
    }

    private void clearForm() {
        questionInput.clear();
        goodAnswerInput.clear();
        choice1Input.clear();
        choice2Input.clear();
        choice3Input.clear();
        moduleBox.getSelectionModel().select("Calcul de dose");
    }

}
