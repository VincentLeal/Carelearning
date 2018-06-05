package controller;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Student;
import service.StudentService;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

import static javafx.collections.FXCollections.observableArrayList;

/**
 * Created on 19/05/2018.
 */
public class StudentOverviewController implements Initializable {
    StudentService studentService = new StudentService();
    Student student = new Student();

    @FXML
    TableView<Student> studentTableView;

    @FXML
    private TableColumn<Student, Integer> idColumn;

    @FXML
    private TableColumn<Student, String> firstnameColumn;

    @FXML
    private TableColumn<Student, String> lastnameColumn;

    @FXML
    private TableColumn<Student, String> mailColumn;

    @FXML
    private TableColumn<Student, String> schoolColumn;

    @FXML
    private TableColumn<Student, String> registerDateColumn;

    @FXML
    private TextField firstnameInput;

    @FXML
    private TextField lastnameInput;

    @FXML
    private TextField mailInput;

    @FXML
    private TextField schoolInput;

    @FXML
    private PasswordField passwordInput;

    @FXML
    Button addStudent;

    @FXML
    Button removeStudent;

    @FXML
    private final ObservableList<Student> studentData = observableArrayList(studentService.getStudents());

    private IntegerProperty index = new SimpleIntegerProperty();

    private static final AtomicInteger count = new AtomicInteger(4);

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle){
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstnameColumn.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        lastnameColumn.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        mailColumn.setCellValueFactory(new PropertyValueFactory<>("mail"));
        schoolColumn.setCellValueFactory(new PropertyValueFactory<>("school"));
        registerDateColumn.setCellValueFactory(new PropertyValueFactory<>("registerDate"));

        studentTableView.setItems(studentData);

        indexOf();
    }

    private void indexOf(){
        studentTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            index.set(studentData.indexOf(newValue));
            System.out.println("OK index of is : " + studentData.indexOf(newValue));
        });
    }

    @FXML
    private void saveNewStudent(ActionEvent event) throws IOException {
        Student student = new Student(
                count.incrementAndGet(),
                firstnameInput.getText(),
                lastnameInput.getText(),
                mailInput.getText(),
                schoolInput.getText(),
                passwordInput.getText(),
                "2018-10-04T22:00:00.000Z"
        );

        try{
            studentService.postStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*student.setFirstname(firstnameInput.getText());
        student.setLastname(lastnameInput.getText());
        student.setMail(mailInput.getText());
        student.setSchool(schoolInput.getText());
        student.setPassword(passwordInput.getText());*/

        studentData.add(student);

        clearForm();
    }

    @FXML
    public void deleteStudent(ActionEvent event) {
        int i = index.get();
        if(i > -1) {
            studentData.remove(i);
            studentTableView.getSelectionModel().clearSelection();
        }
    }

    private void clearForm() {
        firstnameInput.clear();
        lastnameInput.clear();
        mailInput.clear();
        schoolInput.clear();
        passwordInput.clear();
    }
}
