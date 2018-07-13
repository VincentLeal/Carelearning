package controller.exercises;

import controller.TransitionView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Exercise;
import service.ExerciseService;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrefixAndSuffixOverviewController implements Initializable {
    private ExerciseService exerciseService = new ExerciseService();

    private TransitionView transitionView = new TransitionView();
    String fxmlBackScene = "/fxml/exercises/ExercisesOverviewController.fxml";

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField questionInput;

    @FXML
    private TextField goodAnswerInput;

    @FXML
    private TextField moduleInput;

    @FXML
    private Button goBackButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        goBackButton.setOnAction(event -> transitionView.goBackButton(anchorPane, fxmlBackScene, 800.0, 400.0));
    }

    @FXML
    private void createPrefixAndSuffixExercise() {
        String type = "Suffixe et préfixe";
        String choice1 = "/";
        String choice2 = "/";
        String choice3 = "/";

        Exercise prefixAndSuffixExercise = new Exercise(
                questionInput.getText(),
                goodAnswerInput.getText(),
                choice1,
                choice2,
                choice3,
                moduleInput.getText(),
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
        moduleInput.clear();
    }
}
