package com.moma.dao.bean;

import java.io.Serializable;
import java.util.List;

public class Banner implements Serializable {
    private Integer id;

    private String name;

    private String create_time;

    private String delete_time;

    private String update_tiem;

    private List<BannerItem> banner_item;

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

    public String getUpdate_tiem() {
        return update_tiem;
    }

    public void setUpdate_tiem(String update_tiem) {
        this.update_tiem = update_tiem;
    }

    public List<BannerItem> getBanner_item() {
        return banner_item;
    }

    public void setBanner_item(List<BannerItem> banner_item) {
        this.banner_item = banner_item;
    }
}