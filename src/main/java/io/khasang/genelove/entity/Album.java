package io.khasang.genelove.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Denis Guzikov
 * Date 26-12-2016
 * Альбомы мультимедиа (фото, видео, аудио)
 */

@Entity
public class Album {
    public Album() {
    }

    @Id
    private long id;
    private String name;
    private String descr;
    private long personId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }
}
