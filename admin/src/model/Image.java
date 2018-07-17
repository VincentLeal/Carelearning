package model;

/**
 * Created on 16/07/2018.
 */
public class Image {
    private int id;
    private String title;
    private String label;
    private String url;

    private int exerciseId;

    public Image(){}

    public Image(String title,
                 String label,
                 String url){
        this(-1, title, label, url);
    }

    public Image(int id, String title, String label, String url) {
        this.id = id;
        this.title = title;
        this.label = label;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    /*@Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", label='" + label + '\'' +
                ", url='" + url + '\'' +
                '}';
    }*/

    public String toString() {
        return "nom : " + label + " -- " +
                "url : " + url;
    }
}
