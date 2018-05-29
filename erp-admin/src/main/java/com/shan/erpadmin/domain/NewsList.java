package com.shan.erpadmin.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by chenjunshan
 * 2018-03-07 15:00
 */
@Entity
public class NewsList {

    @Id
    @GeneratedValue
    private Integer id;

    //关联id
    private String relateId;

    //新闻标题
    private String title;

    //新闻简介
    private String intro;

    //发布时间
    private String time;

    public NewsList() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRelateId() {
        return relateId;
    }

    public void setRelateId(String relateId) {
        this.relateId = relateId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "NewsList{" +
                "id=" + id +
                ", relateId='" + relateId + '\'' +
                ", title='" + title + '\'' +
                ", intro='" + intro + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
