package io.khasang.genelove.entity;

import javax.persistence.*;
import java.io.Serializable;

/** Class that is composite primary key of two different fields "user_id" and "favourite_id".
 * It is embeddable, so can be used as part of other classes, in our case entity classes to create tables.
 * https://docs.oracle.com/cd/E16439_01/doc.1013/e13981/cmp30cfg001.htm
 * Класс, который является сложным первичным ключом из двух разных полей.
 * Он встраиваемый, то есть может использоваться как часть других классов, в нашем случае - классов сущностей */

@Embeddable
public class FavouriteKey implements Serializable {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "favourites_user_fk"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "favourite_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "favourites_favourite_fk"))
    private User favourite;

    public FavouriteKey() {

    }

    public FavouriteKey(User user, User favourite) {
        this.user = user;
        this.favourite = favourite;
    }

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