package io.khasang.genelove.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Images {
    @Id
    private long id;
    private String filename;
    private String title;
    private String author;
    private String description;
    private String location;
    private Date dateOfImaging;

    public Images() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDateOfImaging() {
        return dateOfImaging;
    }

    public void setDateOfImaging(Date dateOfImaging) {
        this.dateOfImaging = dateOfImaging;
    }
}
