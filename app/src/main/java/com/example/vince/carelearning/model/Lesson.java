package com.example.vince.carelearning.model;

public class Lesson {
    private Integer id;
    private String module;
    private String title;
    private String content;

    public Lesson(Integer id, String module, String title, String content) {
        this.id = id;
        this.module = module;
        this.title = title;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
