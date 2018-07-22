package controller;

import controller.dialog.DisplayView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import service.ConnectionService;
import tool.EmailValidator;

/**
 * Created on 22/07/2018.
 */
public class ConnectionOverviewController {
    private EmailValidator emailValidator = new EmailValidator();

    private ConnectionService connectionService = new ConnectionService();

    private DisplayView displayView = new DisplayView();

    @FXML
    private TextField mailInput;

    @FXML
    private TextField passwordInput;

    @FXML
    private Label emptyField;

    public void connect(ActionEvent event){
        if(!emailValidator.validate(mailInput.getText())) {
            mailInput.setText("Format email invalide!");
        } else {
            try {
                String mail = mailInput.getText();
                String password = passwordInput.getText();

                if (isEmpty(mailInput, passwordInput)) {
                    emptyField.setText("Tous les champs doivent être remplis!");
                } else {
                    String accessToken =  connectionService.checkIfAdmin(mail, password);
                    displayView.window("/fxml/MainController.fxml", "Menu principal", event);
                }
            }catch (NullPointerException e) {
                e.printStackTrace();
                emptyField.setText("Erreur d'authentification !");
            }
        }
    }

    private boolean isEmpty(TextField mail, TextField password) {
        if(mail.getText().trim().isEmpty() || password.getText().trim().isEmpty())
            return true;
        return false;
    }
}
