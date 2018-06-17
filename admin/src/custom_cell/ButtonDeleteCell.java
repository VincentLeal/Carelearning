package custom_cell;

import javafx.beans.property.IntegerProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Student;
import service.StudentService;

public class ButtonDeleteCell extends TableCell<Student, String> {
    private final Button cellButton = new Button("Del");
    private final Integer studentId;
    private StudentService studentService = new StudentService();
    private TableView<Student> studentTableView;

    public ButtonDeleteCell(Integer studentId,
                            TableView<Student> studentTableView) {
        this.studentId = studentId;
        this.studentTableView = studentTableView;
        makeDelAction();
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        if(!empty) {
            setGraphic(cellButton);
        }
    }

    public void makeDelAction() {
        cellButton.setOnAction(event -> {
            int selectedIndex = studentTableView.getSelectionModel().getSelectedIndex();
            System.out.println(selectedIndex);
                //studentService.deleteStudent(1);
        });
    }
}
