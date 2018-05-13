package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * Created on 13/05/2018.
 */
public class Student {
    private int id;
    private String firstname;
    private String lastname;
    private String password;
    private String mail;
    private String school;
    private String registerDate;

    public Student (int id, String firstname, String lastname, String password, String mail, String school, String registerDate){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.mail = mail;
        this.school = school;
        this.registerDate = registerDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "id : " + this.getId()
                + ", firstname : " + this.getFirstname()
                + ", lastname : " + this.getLastname()
                + ", mail : " + this.getMail()
                + ", school : " + this.getSchool()
                + ", register date : " + this.getRegisterDate() + "\n";

        //return super.toString();
    }
    /*public void displayStudent(String message) {
        Stage primaryStage = new Stage();
        try {
            final URL url = getClass().getResource("displayStudent");
            final FXMLLoader fxmlLoader = new FXMLLoader(url);
            final AnchorPane root = (AnchorPane) fxmlLoader.load();

            final Scene scene = new Scene(root, 500, 500);
            primaryStage.setScene(scene);
        } catch (IOException e) {
            System.out.println("Loading Error...");
        }
        primaryStage.setTitle("Student List");
        primaryStage.show();
    }*/
}
