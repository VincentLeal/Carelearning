package model;

public class Exercise {
    private int id;
    private String question;
    private String choice;
    private String module;
    private String type;

    public Exercise() {}

    public Exercise(int id, String question, String choice, String module, String type) {
        this.id = id;
        this.question = question;
        this.choice = choice;
        this.module = module;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", choice='" + choice + '\'' +
                ", module='" + module + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
