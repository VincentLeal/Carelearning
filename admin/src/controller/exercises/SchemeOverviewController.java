package controller.exercises;

import controller.dialog.DisplayView;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import model.Exercise;
import model.Image;
import service.ExerciseService;
import service.ImageService;
import tool.TransitionView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SchemeOverviewController implements Initializable{
    private ExerciseService exerciseService = new ExerciseService();
    private ImageService imageService = new ImageService();

    List<Image> images = new ArrayList<>();

    private TransitionView transitionView = new TransitionView();
    private String fxmlBackScene = "/fxml/exercises/ExercisesOverviewController.fxml";
    private String fxmlBackSceneTitle = "Exercices";

    private DisplayView displayView = new DisplayView();

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextArea descriptionInput;

    @FXML
    private TextField titleInput;

    @FXML
    private TextField labelInput;
    @FXML
    private TextField urlInput;

    @FXML
    private ComboBox moduleBox;

    @FXML
    private ListView imageListView;

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

    public void addImage() {
        Image image = new Image(
                titleInput.getText(),
                labelInput.getText(),
                urlInput.getText()
        );
        System.out.println(image);
        images.add(image);

        imageListView.getItems().add(image);

        clearImageInput();
    }

    @FXML
    private void createSchemeExercise() {
        boolean emptyField = titleInput.getText().trim().isEmpty();
        boolean emptyTextArea =  descriptionInput.getText().trim().isEmpty();;
        boolean emptyListView = imageListView.getItems().isEmpty();

        if(!emptyField && ! emptyTextArea && !emptyListView){

            String type = "Schéma";
            String goodAnswer =  "/";
            String choice1 = "/";
            String choice2 = "/";
            String choice3 = "/";
            String module = moduleBox.getValue().toString();

            Exercise schemaExercise = new Exercise(
                    descriptionInput.getText(),
                    goodAnswer,
                    choice1,
                    choice2,
                    choice3,
                    module,
                    type,
                    images
            );

            try {
                exerciseService.postExercise(schemaExercise);
                displayView.dialog("/fxml/dialog/success/SuccessExerciseCreation.fxml", "Succès !");
                clear();

            }catch (IOException e){
                displayView.dialog("/fxml/dialog/error/FailExerciseCreation.fxml", "Erreur !");
                e.printStackTrace();
            }
        } else {
            displayView.dialog("/fxml/dialog/error/FailExerciseCreation.fxml", "Erreur !");
        }
    }
    private void clearImageInput() {
        labelInput.clear();
        urlInput.clear();
    }

    private void clear() {
        moduleBox.getSelectionModel().select("Calcul de dose");
        imageListView.getItems().clear();
    }
}
