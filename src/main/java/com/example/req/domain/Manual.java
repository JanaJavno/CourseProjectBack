package com.example.req.domain;

import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Resolution;
import org.hibernate.search.annotations.TermVector;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import java.util.Date;

@Entity
@Indexed
public class Manual {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(length = 64)
    @Field(termVector = TermVector.YES)
    private String title;

    private String url;
    @Field(termVector = TermVector.YES)
    private String description;

    @Column(length = 32, columnDefinition = "varchar(32)")
    @Enumerated(value = EnumType.STRING)
    @Field
    private ManualCategory category;

    @Field
    @DateBridge(resolution = Resolution.DAY)
    private Date createdAt;

    public Manual() {
    }

    public Manual(String title, String url, String description, ManualCategory category, Date createdAt) {
        this.title = title;
        this.url = url;
        this.description = description;
        this.category = category;
        this.createdAt = createdAt;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
