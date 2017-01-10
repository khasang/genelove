package io.khasang.genelove.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Topic {
    @Id
    private long id;
    private String title;
    private String description;
    private Date dateOfTopic;

    public Topic() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateOfTopic() {
        return dateOfTopic;
    }

    public void setDateOfTopic(Date dateOfTopic) {
        this.dateOfTopic = dateOfTopic;
    }
}
