package model;

/**
 * Created on 23/06/2018.
 */
public class Lesson {
    private int id;
    private String module;
    private String title;
    private String content;

    public Lesson() {}

    public Lesson(String module, String title, String content) {
        this(-1, module, title, content);
    }

    public Lesson(int id, String module, String title, String content) {
        this.id = id;
        this.module = module;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", module='" + module + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
