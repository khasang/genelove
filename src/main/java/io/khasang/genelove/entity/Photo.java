package io.khasang.genelove.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Фото
 */

@Entity
public class Photo {
    public Photo() {
    }

    @Id
    private long id;
    @ManyToOne
    private Album album;
    private int type;     //главное фото, обычное фото
    private String address;  //путь файла в сети

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
