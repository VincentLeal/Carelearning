package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created on 22/05/2018.
 */
public class MainController implements Initializable{

    @FXML
    private void studentActionButton(ActionEvent event) throws IOException {
        Parent displayStudentPage = FXMLLoader.load(getClass().getResource("/fxml/StudentOverviewController.fxml"));
        Scene displayStudentScene = new Scene(displayStudentPage);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(displayStudentScene);
        stage.show();
    }

    @FXML
    private void lessonActionButton(ActionEvent event) throws IOException {
        Parent displayLessonPage = FXMLLoader.load(getClass().getResource("/fxml/LessonOverviewController.fxml"));
        Scene displayLessonScene = new Scene(displayLessonPage);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(displayLessonScene);
        stage.show();
    }

    @FXML
    private void exerciseActionButton(ActionEvent event) throws IOException {
        Parent displayExercisePage = FXMLLoader.load(getClass().getResource("/fxml/exercises/ExercisesOverviewController.fxml"));
        Scene displayExerciseScene = new Scene(displayExercisePage);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(displayExerciseScene);
        stage.show();
    }

    public void initialize(URL url, ResourceBundle resourceBundle){

    }

}
