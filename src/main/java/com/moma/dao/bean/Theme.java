package com.moma.dao.bean;

import java.util.List;

public class Theme {
    private Integer id;

    private String name;

    private String create_time;

    private String delete_time;

    private String update_time;

    private List<ThemeItem> theme_item;

    public List<ThemeItem> getTheme_item() {
        return theme_item;
    }

    public void setTheme_item(List<ThemeItem> theme_item) {
        this.theme_item = theme_item;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getDelete_time() {
        return delete_time;
    }

    public void setDelete_time(String delete_time) {
        this.delete_time = delete_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }
}