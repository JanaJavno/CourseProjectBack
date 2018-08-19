package com.example.req.domain;

import javax.persistence.*;

@Entity
public class Manual {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(length = 64)
    private String title;

    private String url;

    public Manual() {
    }

    public Manual(String name, String picturePath) {
        this.title = name;
        this.url = picturePath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
