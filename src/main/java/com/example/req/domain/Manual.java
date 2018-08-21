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

    private String description;

    @Column(length = 32, columnDefinition = "varchar(32)")
    @Enumerated(value = EnumType.STRING)
    private ManualCategory category;

    public Manual() {
    }

    public Manual(String title, String url, String description, ManualCategory category) {
        this.title = title;
        this.url = url;
        this.description = description;
        this.category = category;
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

    public ManualCategory getCategory() {
        return category;
    }

    public void setCategory(ManualCategory category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
