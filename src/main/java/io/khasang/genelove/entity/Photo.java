package io.khasang.genelove.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Фото
 * @author Denis Guzikov
 * @version 1.0
 */

@Entity
public class Photo {
    public Photo() {
    }

    @Id
    private long id;
    @ManyToOne
    private Album album;
    /** Поле "тип" (главное фото, обычное фото) */
    private int type;
    /** Поле "адрес" (путь файла в сети) */
    private String address;

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
