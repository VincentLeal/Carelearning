package controller.exercises;

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
    private TextField moduleInput;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        goBackButton.setOnAction(event -> transitionView.goBackButton(anchorPane, fxmlBackScene, 800.0, 400.0));
    }

    @FXML
    private void createNewMCQ() {
        String type = "QCM";

        Exercise mcqExercise = new Exercise(
                questionInput.getText(),
                goodAnswerInput.getText(),
                choice1Input.getText(),
                choice2Input.getText(),
                choice3Input.getText(),
                moduleInput.getText(),
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
        moduleInput.clear();
    }

}
