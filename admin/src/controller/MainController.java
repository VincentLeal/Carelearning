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
    private void displayStudentActionButton(ActionEvent event) throws IOException{
        Parent displayStudentPage = FXMLLoader.load(getClass().getResource("../fxml/StudentOverviewController.fxml"));
        Scene diplayStudentScene = new Scene(displayStudentPage);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(diplayStudentScene);
        stage.show();
    }

    public void initialize(URL url, ResourceBundle resourceBundle){

    }

}
