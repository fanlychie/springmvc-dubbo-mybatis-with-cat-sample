package org.fanlychie.entity;

import java.io.Serializable;

/**
 * Created by fanlychie on 2018/7/28.
 */
public class Article implements Serializable {

    private Long id;

    private Long userId;

    private String title;

    private String summary;

    public Article() {

    }

    public Article(Long id, Long userId, String title, String summary) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.summary = summary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

}