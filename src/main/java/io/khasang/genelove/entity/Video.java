package io.khasang.genelove.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Видео
 */

@Entity
public class Video {
    public Video() {
    }

    @Id
    private long id;
    private  long albumId;
    private int type;     //главное видео, обычное видео
    private String address;  //путь файла в сети

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
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
}
