package controller;

import controller.dialog.DisplayView;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import model.Result;
import service.ResultService;
import tool.TransitionView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created on 22/07/2018.
 */
public class ResultStudentController implements Initializable{
    private TransitionView transitionView = new TransitionView();
    private String fxmlBackScene = "/fxml/StudentOverviewController.fxml";
    private String fxmlBackSceneTitle = "Gestion des étudiants";

    private ResultService resultService = new ResultService();

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TableView<Result> resultTableView;

    @FXML
    private TableColumn<Result, String> dateColumn;

    @FXML
    private TableColumn<Result, String> scoreColumn;

    @FXML
    private TableColumn<Result, String> moduleColumn;

    @FXML
    private ObservableList<Result> resultData = observableArrayList(resultService.getResults());

    @FXML
    private Button goBackButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        dateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
        scoreColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        moduleColumn.setCellValueFactory(new PropertyValueFactory<>("module"));
        moduleColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        resultTableView.setItems(resultData);

        goBackButton.setOnAction(event -> transitionView.goBackButton(anchorPane, fxmlBackScene, fxmlBackSceneTitle, 900.0, 600.0));
    }


}
