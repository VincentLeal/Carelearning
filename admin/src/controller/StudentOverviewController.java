package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Student;
import service.StudentService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created on 19/05/2018.
 */
public class StudentOverviewController implements Initializable {
    StudentService studentService = new StudentService();

    @FXML
    TableView<Student> studentTableView;

    @FXML
    private TableColumn<Student, Integer> idColumn;

    @FXML
    private TableColumn<Student, String> firstnameColumn;

    @FXML
    private TableColumn<Student, String> lastnameColumn;

    @FXML
    final ObservableList<Student> studentData = FXCollections.observableArrayList(studentService.getStudent());

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle){
        idColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
        firstnameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("firstname"));
        lastnameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("lastname"));

        studentTableView.setItems(studentData);
    }
}
