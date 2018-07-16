package controller.exercises;

import controller.ExercisesOverviewController;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Exercise;
import model.Image;
import service.ExerciseService;
import service.ImageService;
import tool.TransitionView;

import java.io.IOException;
import java.net.URL;
import java.util.*;

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
    private Button goBackButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        goBackButton.setOnAction(event -> transitionView.goBackButton(anchorPane, fxmlBackScene, 800.0, 400.0));

        moduleBox.getItems().addAll("ORL", "Digestif",
                "Ophtalmo", "Psychiatrie",
                "Infectieux et VIH", "Pneumologie",
                "Cardiologie");
        moduleBox.getSelectionModel().select("ORL");

    }

    public void addImage() {
        Image image = new Image(
                titleInput.getText(),
                labelInput.getText(),
                urlInput.getText()
        );
        System.out.println(image);
        images.add(image);
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

            List<Image> tr = images;

            imageService.postImage(images, id);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void clearImageInput() {
        labelInput.clear();
        urlInput.clear();
    }
}
