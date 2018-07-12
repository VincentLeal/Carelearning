package controller.exercises;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Exercise;
import service.ExerciseService;

import java.io.IOException;

public class PrefixAndSuffixOverviewController {
    private ExerciseService exerciseService = new ExerciseService();

    @FXML
    private TextField questionInput;

    @FXML
    private TextField goodAnswerInput;

    @FXML
    private TextField moduleInput;

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
