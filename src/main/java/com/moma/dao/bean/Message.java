package com.moma.dao.bean;

public class Message {
    private Integer id;

    private String title;

    private Integer uid;

    private String container;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container == null ? null : container.trim();
    }
}