package sample;

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

    public Student () {}

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
        return "Id : " + this.getId()
                + "\nFirstname : " + this.getFirstname()
                + "\nLastname : " + this.getLastname()
                + "\nMail : " + this.getMail()
                + "\nSchool : " + this.getSchool()
                + "\nRegister date : " + this.getRegisterDate() + "\n";
    }
}
