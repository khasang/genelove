package io.khasang.genelove.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/** Class that is used by Hibernate to create table "favourites" in the Database.
 * It uses (embeds) class FavouriteKey as composite primary key.
 * This table is used to store list of id-s of the users that are friends, relatives and date candidates of the user.
 *
 * Класс, используя который, Hibernate создаёт таблицу в Базе данных.
 * Он использует (встраивает) в себя класс FavouriteKey в качестве сложного первичного ключа.
 * В таблице хранится список о пользователей, которые являются друзьями, родственниками
 * или кандидатами для знакомства пользователя. */

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
