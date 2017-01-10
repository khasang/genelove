package io.khasang.genelove.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import java.io.Serializable;

@Embeddable
public class FavouriteKey implements Serializable {

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "favourite_id", nullable = false)
    private int favouriteId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFavouriteId() {
        return favouriteId;
    }

    public void setFavouriteId(int favouriteId) {
        this.favouriteId = favouriteId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FavouriteKey that = (FavouriteKey) o;

        if (userId != that.userId) return false;
        return favouriteId == that.favouriteId;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + favouriteId;
        return result;
    }
}