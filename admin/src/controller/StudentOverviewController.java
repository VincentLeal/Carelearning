package controller;

import controller.dialog.DisplayView;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Student;
import service.StudentService;
import tool.DateFormatter;
import tool.EmailValidator;
import tool.TransitionView;
import tool.exception.HTTPConflictException;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableArrayList;

/**
 * Created on 19/05/2018.
 */
public class StudentOverviewController implements Initializable {
    private StudentService studentService = new StudentService();

    private TransitionView transitionView = new TransitionView();
    private String fxmlBackScene = "/fxml/MainController.fxml";
    private String fxmlBackSceneTitle = "Menu principal";

    private EmailValidator emailValidator = new EmailValidator();

    private DisplayView displayView = new DisplayView();

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private AnchorPane anchorPaneInput;

    @FXML
    private TextField searchBar;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private Button searchButton;

    @FXML
    private TableView<Student> studentTableView;

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
    private TableColumn<Student, String> roleColumn;

    @FXML
    private TableColumn resultColumn;

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
    private ComboBox<String> roleBox;

    @FXML
    private Button delStudent;

    @FXML
    private Button backToMenu;

    @FXML
    private ObservableList<Student> studentData = observableArrayList(studentService.getStudents());

    private int id = 0;

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
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
        roleColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        choiceBox.getItems().addAll("nom", "prénom", "mail", "ecole", "date d'inscription", "role");
        choiceBox.setValue("nom");

        studentTableView.setItems(studentData);

        editColumn(firstnameColumn, "firstname");
        editColumn(lastnameColumn, "lastname");
        editColumn(mailColumn, "mail");
        editColumn(schoolColumn, "school");
        editColumn(roleColumn, "role");

        roleBox.getItems().addAll("user", "admin");
        roleBox.getSelectionModel().select("user");

        passwordInput.disableProperty().bind(roleBox.valueProperty().isEqualTo("user"));

        backToMenu.setOnAction(event -> transitionView.goBackButton(anchorPane, fxmlBackScene, fxmlBackSceneTitle, 184.0, 338.0));

        getSelectedRow();
    }

    @FXML
    private void searchStudent() {
        FilteredList<Student> student = new FilteredList<>(studentData, stdt -> true);
        studentTableView.setItems(student);

        searchButton.setOnAction(event -> {
            switch (choiceBox.getValue().toString()) {
                case "nom":
                    student.setPredicate(stdt -> stdt.getFirstname().contains(searchBar.getText().toLowerCase().trim()));
                    break;
                case "prénom":
                    student.setPredicate(stdt -> stdt.getLastname().contains(searchBar.getText().toLowerCase().trim()));
                    break;
                case "mail":
                    student.setPredicate(stdt -> stdt.getMail().contains(searchBar.getText().toLowerCase().trim()));
                    break;
                case "ecole":
                    student.setPredicate(stdt -> stdt.getSchool().contains(searchBar.getText().toLowerCase().trim()));
                    break;
                case "date d'inscription":
                    student.setPredicate(stdt -> stdt.getRegisterDate().contains(searchBar.getText().toLowerCase().trim()));
                    break;
                case "role":
                    student.setPredicate(stdt -> stdt.getRole().contains(searchBar.getText().toLowerCase().trim()));
                    break;
            }
        });
    }

    private void editColumn(TableColumn<Student, String> column, String key){
        column.setOnEditCommit(event -> {
            String newValue = event.getNewValue();
            int id = event.getTableView().getItems().get(event.getTablePosition().getRow()).getId();

            try {
                studentService.updateStudent(key, newValue, id);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @FXML
    private void saveNewStudent() {
        if(!emailValidator.validate(mailInput.getText())) {
            mailInput.setText("format mail invalide");
        }else {
            Student student = new Student(
                    firstnameInput.getText(),
                    lastnameInput.getText(),
                    mailInput.getText(),
                    schoolInput.getText(),
                    passwordInput.getText(),
                    DateFormatter.currentDate(),
                    roleBox.getValue().toString()
            );

            try {
                boolean emptyField = isEmptyTextfield(roleBox.getValue().toString());

                if (!emptyField) {
                    int newStudentId = studentService.postStudent(student);
                    student.setId(newStudentId);
                    studentData.add(student);
                    displayView.dialog("/fxml/dialog/success/ConfirmRegistrationDialog.fxml", "Utilisateur enregistré !");
                    clearForm();
                } else {
                    displayView.dialog("/fxml/dialog/error/EmptyFieldDialog.fxml", "Vous avez oublié quelque chose");
                }

            } catch (HTTPConflictException ex) {
                displayView.dialog("/fxml/dialog/error/ConflictDialog.fxml", "Impossible de créer cet utilisateur !");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    private void getSelectedRow() {
        studentTableView.setOnMouseClicked((MouseEvent event) -> getSelectedId());
    }

    private void getSelectedId() {
        if(studentTableView.getSelectionModel().getSelectedItem() != null) {
            Student selectedStudent = studentTableView.getSelectionModel().getSelectedItem();
            id = selectedStudent.getId();
            delStudent.setOnAction(event -> {
                try {
                    studentService.deleteStudent(id);

                    Student selectedItem = studentTableView.getSelectionModel().getSelectedItem();
                    studentTableView.getItems().remove(selectedItem);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private boolean isEmptyTextfield(String role) {
        ObservableList<Node> observableList = anchorPaneInput.getChildren();

        for(Node verifyTextField : observableList) {
            if(verifyTextField instanceof TextField){
                if(role.equals("user")
                    && !verifyTextField.getId().equals("passwordInput")
                    && ((TextField) verifyTextField).getText().trim().isEmpty()) {
                        return true;

                }else if(role.equals("admin")
                    && ((TextField) verifyTextField).getText().trim().isEmpty()){
                        return true;
                    }
                }
            }
        return false;
    }

    @FXML
    private void getResult(ActionEvent event) {
        if(studentTableView.getSelectionModel().getSelectedItem() != null) {
            Student selectedStudent = studentTableView.getSelectionModel().getSelectedItem();

            displayView.window("/fxml/ResultStudentController.fxml", "Résultats", event);
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