package custom_cell;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import model.Student;
import service.StudentService;

public class ButtonDeleteCell extends TableCell<Student, Boolean> {
    private final Button cellButton = new Button("Del");
    StudentService studentService = new StudentService();

    public ButtonDeleteCell() {
        cellButton.setOnAction(event -> System.out.println("Del Button clicked"));
    }

    @Override
    protected void updateItem(Boolean item, boolean empty) {
        super.updateItem(item, empty);

        if(!empty) {
            setGraphic(cellButton);
        }
    }
}
