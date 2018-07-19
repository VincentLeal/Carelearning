package controller.exercises;

import controller.dialog.DisplayView;
import javafx.collections.ObservableList;
import javafx.scene.Node;
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
    private String fxmlBackSceneTitle = "Exercices";

    private DisplayView displayView = new DisplayView();

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
        goBackButton.setOnAction(event -> transitionView.goBackButton(anchorPane, fxmlBackScene, fxmlBackSceneTitle, 800.0, 500.0));

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

        boolean emptyField = isEmptyTextField();

        if(!emptyField){
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
                displayView.dialog("/fxml/dialog/success/SuccessExerciseCreation.fxml", "Succès !");
                clearForm();
            } catch (IOException e) {
                displayView.dialog("/fxml/dialog/error/FailExerciseCreation.fxml", "Erreur !");
                e.printStackTrace();
            }
        } else {
            displayView.dialog("/fxml/dialog/error/FailExerciseCreation.fxml", "Erreur !");
        }
    }

    private boolean isEmptyTextField() {
        ObservableList<Node> observableList = anchorPane.getChildren();

        for(Node verifyTextField : observableList) {
            if(verifyTextField instanceof TextField
                    && ((TextField) verifyTextField).getText().trim().isEmpty()){
                return true;
            }
        }
        return false;
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
