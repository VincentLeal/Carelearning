package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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

    public Student () {}

    public Student (int id,
                    String firstname,
                    String lastname,
                    String mail,
                    String school,
                    String registerDate) {
        this.id = new SimpleIntegerProperty(id);
        this.firstname = new SimpleStringProperty(firstname);
        this.lastname = new SimpleStringProperty(lastname);
        this.mail = new SimpleStringProperty(mail);
        this.school = new SimpleStringProperty(school);
        this.registerDate = new SimpleStringProperty(registerDate);
    }

    public Student(
                   String firstname,
                   String lastname,
                   String mail,
                   String school,
                   String password,
                   String registerDate) {
        this.firstname = new SimpleStringProperty(firstname);
        this.lastname = new SimpleStringProperty(lastname);
        this.mail = new SimpleStringProperty(mail);
        this.school = new SimpleStringProperty(school);
        this.password = new SimpleStringProperty(password);
        this.registerDate = new SimpleStringProperty(registerDate);
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
/*
    public StringProperty registerDateProperty() {
        return registerDate;
    }*/

    @Override
    public String toString() {
        return "Id : " + this.getId()
                + "\nFirstname : " + this.getFirstname()
                + "\nLastname : " + this.getLastname()
                + "\nMail : " + this.getMail()
                + "\nSchool : " + this.getSchool()
                + "\nRegister date : " + this.getRegisterDate() + "\n";
    }
}
