package controller.exercises;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
        goBackButton.setOnAction(event -> transitionView.goBackButton(anchorPane, fxmlBackScene, 800.0, 400.0));

        moduleBox.getItems().addAll("ORL-Dermato-Stomato", "Digestif", "Urologie",
                "Ophtalmo", "Psychiatrie", "Cancérologie", "Endocrino", "Ortho-Traumato",
                "Infectieux et VIH", "Pneumologie", "Urgences-Réa-transfu",
                "Cardio-vasculaire", "Gynécologie", "Pédiatrie", "Neurologie");
        moduleBox.getSelectionModel().select("ORL-Dermato-Stomato");

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
            int id = exerciseService.postExercise(schemaExercise);
            imageService.postImage(images, schemaExercise);
        }catch (IOException e){
            e.printStackTrace();
        }
        clear();
    }

    private void clearImageInput() {
        labelInput.clear();
        urlInput.clear();
    }

    private void clear() {
        moduleBox.getSelectionModel().select("ORL-Dermato-Stomato");
        imageListView.getItems().clear();
    }
}
