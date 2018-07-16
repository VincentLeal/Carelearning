package model;

import javafx.beans.property.*;

/**
 * Created on 13/05/2018.
 */
public class Student {
    private SimpleIntegerProperty id;
    private SimpleStringProperty firstname;
    private SimpleStringProperty lastname;
    private SimpleStringProperty password;
    private SimpleStringProperty mail;
    private SimpleStringProperty school;
    private SimpleStringProperty registerDate;
    private SimpleStringProperty role;

    public Student () {}

    public Student(String firstname,
                   String lastname,
                   String mail,
                   String school,
                   String password,
                   String registerDate,
                   String role) {
        this(-1, firstname, lastname, mail, school, registerDate, password, role);
    }

    public Student (int id,
                    String firstname,
                    String lastname,
                    String mail,
                    String school,
                    String registerDate,
                    String password,
                    String role) {
        this.id = new SimpleIntegerProperty(id);
        this.firstname = new SimpleStringProperty(firstname);
        this.lastname = new SimpleStringProperty(lastname);
        this.mail = new SimpleStringProperty(mail);
        this.school = new SimpleStringProperty(school);
        this.registerDate = new SimpleStringProperty(registerDate);
        this.password = new SimpleStringProperty(password);
        this.role = new SimpleStringProperty(role);
    }

    public Integer getId() {
        return id.get();
    }

    public void setId(Integer id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getFirstname() {
        return firstname.get();
    }

    public void setFirstname(String firstname) {
        this.firstname.set(firstname);
    }

    public StringProperty firstnameProperty() {
        return firstname;
    }

    public String getLastname() {
        return lastname.get();
    }

    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }

    public StringProperty lastnameProperty() {
        return lastname;
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public String getMail() {
        return mail.get();
    }

    public void setMail(String mail) {
        this.mail.set(mail);
    }

    public StringProperty mailProperty() {
        return mail;
    }

    public String getSchool() {
        return school.get();
    }

    public void setSchool(String school) {
        this.school.set(school);
    }

    public StringProperty schoolProperty() {
        return school;
    }

    public String getRegisterDate() {
        return registerDate.get();
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate.set(registerDate);
    }

    public SimpleStringProperty registerDateProperty(){
        return registerDate;
    }

    public String getRole() {
        return role.get();
    }

    public void setRole(String status) {
        this.role.set(status);
    }

    public boolean isAdmin(String role) {
        return role.equals("1") || role.toLowerCase().charAt(0) == 'A';
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstname=" + firstname +
                ", lastname=" + lastname +
                ", password=" + password +
                ", mail=" + mail +
                ", school=" + school +
                ", registerDate=" + registerDate +
                ", role=" + role +
                '}';
    }
}
