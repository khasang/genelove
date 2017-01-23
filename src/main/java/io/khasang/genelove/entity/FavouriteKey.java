package io.khasang.genelove.entity;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class FavouriteKey implements Serializable {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "favourites_user_fk"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "favourite_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "favourites_favourite_fk"))
    private User favourite;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getFavourite() {
        return favourite;
    }

    public void setFavourite(User favourite) {
        this.favourite = favourite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FavouriteKey that = (FavouriteKey) o;

        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return favourite != null ? favourite.equals(that.favourite) : that.favourite == null;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (favourite != null ? favourite.hashCode() : 0);
        return result;
    }
}