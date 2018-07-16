package model;

import java.util.List;

public class Exercise {
    private int id;
    private String question;
    private  String goodAnswer;
    private String choice1;
    private String choice2;
    private String choice3;
    private String module;
    private String type;
    private List<Image> images;

    public Exercise() {}

    public Exercise(String question,
                    String goodAnswer,
                    String choice1,
                    String choice2,
                    String choice3,
                    String module,
                    String type) {
        this(-1, question, goodAnswer, choice1, choice2, choice3, module, type, null);
    }

    public Exercise(String question,
                    String goodAnswer,
                    String choice1,
                    String choice2,
                    String choice3,
                    String module,
                    String type,
                    List<Image> images) {
        this(-1, question, goodAnswer, choice1, choice2, choice3, module, type, images);
    }

    private Exercise(int id, String question,
                     String goodAnswer,
                     String choice1,
                     String choice2,
                     String choice3,
                     String module,
                     String type, List<Image> images) {

        this.id = id;
        this.question = question;
        this.goodAnswer = goodAnswer;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.module = module;
        this.type = type;
        this.images = images;
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

    public String getGoodAnswer() {
        return goodAnswer;
    }

    public void setGoodAnswer(String goodAnswer) {
        this.goodAnswer = goodAnswer;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
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

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", goodAnswer='" + goodAnswer + '\'' +
                ", choice1='" + choice1 + '\'' +
                ", choice2='" + choice2 + '\'' +
                ", choice3='" + choice3 + '\'' +
                ", module='" + module + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
