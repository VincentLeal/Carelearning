package controller;

import custom_cell.ButtonDeleteCell;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import model.Student;
import service.StudentService;
import tool.DateFormatter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableArrayList;

/**
 * Created on 19/05/2018.
 */
public class StudentOverviewController implements Initializable {
    private StudentService studentService = new StudentService();

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
    Button refresh;

    @FXML
    private ObservableList<Student> studentData = observableArrayList(studentService.getStudents());

    private IntegerProperty index = new SimpleIntegerProperty();

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle){
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstnameColumn.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        firstnameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lastnameColumn.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        lastnameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        mailColumn.setCellValueFactory(new PropertyValueFactory<>("mail"));
        mailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        schoolColumn.setCellValueFactory(new PropertyValueFactory<>("school"));
        schoolColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        registerDateColumn.setCellValueFactory(new PropertyValueFactory<>("registerDate"));


        TableColumn delete = new TableColumn<>("DELETE");
        delete.setSortable(false);

        delete.setCellValueFactory(
                (Callback<TableColumn.CellDataFeatures<Student, Boolean>, ObservableValue<Boolean>>) p -> new SimpleBooleanProperty(p.getValue() != null));

        delete.setCellFactory(
                (Callback<TableColumn<Student, Boolean>, TableCell<Student, Boolean>>) p -> new ButtonDeleteCell());

        studentTableView.getColumns().add(delete);

        studentTableView.setItems(studentData);

        editColumn(firstnameColumn, "firstname");
        editColumn(lastnameColumn, "lastname");
        editColumn(mailColumn, "mail");
        editColumn(schoolColumn, "school");
    }

    private void editColumn(TableColumn<Student, String> column, String key){
        column.setOnEditCommit(event -> {
            String newValue = event.getNewValue();
            int id = event.getTableView().getItems().get(event.getTablePosition().getRow()).getId();

            try{
                studentService.updateStudent(key, newValue, id);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @FXML
    private void saveNewStudent(ActionEvent event) {
        Student student = new Student(
                firstnameInput.getText(),
                lastnameInput.getText(),
                mailInput.getText(),
                schoolInput.getText(),
                passwordInput.getText(),
                DateFormatter.currentDate()
        );

        try {
            studentService.postStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
        }

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
