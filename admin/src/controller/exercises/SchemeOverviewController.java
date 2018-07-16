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
    private Button addImage;

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




    public void createImages() {
        String label = "";
        String url = "";
        List<String> labelList = new ArrayList<>();
        List<String> urlList = new ArrayList<>();
        int i = 0;

        HashMap<String, String> images = new HashMap<>();

        for(Node node : anchorPane.getChildren()) {
            /*System.out.println("Id " + node.getId());*/
            if(node instanceof TextField) {
                    if(node.getId().startsWith("nameImage" + i)){
                        label = ((TextField) node).getText();
                        System.out.println(label);
                        labelList.add(label);
                    }else if(node.getId().startsWith("imageInput")){
                        url = ((TextField) node).getText();
                        System.out.println(url);
                        urlList.add(url);
                    }
                images.put(label, url);

                ((TextField)node).setText("hello");
            }
        }

        //Récupérer tous les noms de chacune des images


        //Récupérer toute les url
        //En faire un objet Image

        //Ajouter tous les objets dans une liste
        //postImage avec liste


    }

    private void clearImageInput() {
        labelInput.clear();
        urlInput.clear();
    }
}
