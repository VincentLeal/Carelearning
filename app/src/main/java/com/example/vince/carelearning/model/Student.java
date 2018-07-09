package com.example.vince.carelearning.model;

public class Student {

    private Integer id;
    private String firstname;
    private String lastname;
    private String password;
    private String mail;
    private String school;
    private String registerDate;

    public Student() {}

    public Student(String firstname, String lastname, String mail, String school, String password, String registerDate){
        this.firstname = firstname;
        this.lastname =  lastname;
        this.mail = mail;
        this.password = password;
        this.school = school;
        this.registerDate = registerDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override public String toString() {
        return "Student{"
                + "id='"
                + id
                + '\''
                + ", firstname='"
                + firstname
                + '\''
                + ", lastname='"
                + lastname
                + '\''
                + ", password='"
                + password
                + '\''
                + ", mail='"
                + mail
                + '\''
                + ", school='"
                + school
                + '\''
                + ", registerDate='"
                + registerDate
                + '\''
                + '}';
    }
}
