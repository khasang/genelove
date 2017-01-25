package io.khasang.genelove.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "favourites")
public class Favourite {

    @EmbeddedId
    private FavouriteKey favouriteKey;

    @Column(length = 1500)
    private String notes;

    public Favourite() {

    }

    public Favourite(User user, User favourite) {
        this.favouriteKey = new FavouriteKey(user, favourite);
        this.notes = favourite.getFirstName() + " " + favourite.getLastName() + " is my new friend!";
    }

    public FavouriteKey getFavouriteKey() {
        return favouriteKey;
    }

    public void setFavouriteKey(FavouriteKey favouriteKey) {
        this.favouriteKey = favouriteKey;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
