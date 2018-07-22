package controller;

import controller.dialog.DisplayView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created on 22/05/2018.
 */
public class MainController implements Initializable{
    private DisplayView displayView = new DisplayView();

    @FXML
    private void studentActionButton(ActionEvent event) {
        displayView.window("/fxml/StudentOverviewController.fxml", "Elèves", event);
    }

    @FXML
    private void lessonActionButton(ActionEvent event) {
        displayView.window("/fxml/LessonOverviewController.fxml", "Nouvelle leçon", event );
    }

    @FXML
    private void exerciseActionButton(ActionEvent event) {
        displayView.window("/fxml/exercises/ExercisesOverviewController.fxml", "Exercices", event);
    }

    public void initialize(URL url, ResourceBundle resourceBundle){

    }

}
