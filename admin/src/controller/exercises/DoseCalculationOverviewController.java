package controller.exercises;

import controller.dialog.DisplayView;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Exercise;
import service.ExerciseService;
import tool.TransitionView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DoseCalculationOverviewController implements Initializable {
    private ExerciseService exerciseService = new ExerciseService();

    private TransitionView transitionView = new TransitionView();
    private String fxmlBackScene = "/fxml/exercises/ExercisesOverviewController.fxml";
    private String fxmlBackSceneTitle = "Exercices";

    private DisplayView displayView = new DisplayView();

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextArea questionInput;

    @FXML
    private TextArea descriptionInput;

    @FXML
    private TextField answerInput;

    @FXML
    private Button goBackButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        goBackButton.setOnAction(event -> transitionView.goBackButton(anchorPane, fxmlBackScene, fxmlBackSceneTitle, 800.0,500.0));
    }

    @FXML
    public void createDoseCalculationExercise() {
        String type = "Calcul de dose";
        String choice2 = "/";
        String choice3 = "/";
        String module = type;

        Exercise doseCalculation = new Exercise(
                questionInput.getText(),
                answerInput.getText(),
                descriptionInput.getText(),
                choice2,
                choice3,
                module,
                type
        );

        try {
            boolean emptyArea = isEmptyTextArea();
            boolean emptyField = answerInput.getText().trim().isEmpty();

            if(!emptyArea && !emptyField){
                exerciseService.postExercise(doseCalculation);
                displayView.dialog("/fxml/dialog/success/SuccessExerciseCreation.fxml", "Succès !");
                clearForm();
            }else{
                displayView.dialog("/fxml/dialog/error/FailExerciseCreation.fxml", "Erreur !");
            }
        }catch (IOException e) {
            displayView.dialog("/fxml/dialog/error/FailExerciseCreation.fxml", "Erreur !");
            e.printStackTrace();
        }
    }

    private boolean isEmptyTextArea() {
        ObservableList<Node> observableList = anchorPane.getChildren();

        for(Node verifyTextArea : observableList) {
            if(verifyTextArea instanceof TextArea
                && ((TextField) verifyTextArea).getText().trim().isEmpty()){
                 return true;
            }
        }
        return false;
    }

    private void clearForm() {
        questionInput.clear();
        answerInput.clear();
        descriptionInput.clear();
    }
}
