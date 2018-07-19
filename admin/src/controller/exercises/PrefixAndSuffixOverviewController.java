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

public class PrefixAndSuffixOverviewController implements Initializable {
    private ExerciseService exerciseService = new ExerciseService();

    private TransitionView transitionView = new TransitionView();
    private String fxmlBackScene = "/fxml/exercises/ExercisesOverviewController.fxml";
    private String fxmlBackSceneTitle = "Exercices";

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField questionInput;

    @FXML
    private TextField goodAnswerInput;

    @FXML
    private ComboBox moduleBox;

    @FXML
    private Button goBackButton;

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
    private void createPrefixAndSuffixExercise() {
        String type = "Suffixe et préfixe";
        String choice1 = "/";
        String choice2 = "/";
        String choice3 = "/";
        String module = moduleBox.getValue().toString();

        Exercise prefixAndSuffixExercise = new Exercise(
                questionInput.getText(),
                goodAnswerInput.getText(),
                choice1,
                choice2,
                choice3,
                module,
                type
        );

        try {
            exerciseService.postExercise(prefixAndSuffixExercise);
        } catch (IOException e) {
            e.printStackTrace();
        }
        clearForm();
    }



    private void clearForm() {
        questionInput.clear();
        goodAnswerInput.clear();
        moduleBox.getSelectionModel().select("Calcul de dose");
    }
}
