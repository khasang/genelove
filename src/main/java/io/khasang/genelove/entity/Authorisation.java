package io.khasang.genelove.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/** Class that is used by Hibernate to create table "authorisations" in the Database.
 * It uses (embeds) class AuthorisationKey as composite primary key.
 * This table is used to store roles of every user.
 *
 * Класс, используя который, Hibernate создаёт таблицу в Базе данных.
 * Он использует (встраивает) в себя класс AuthorisationKey в качестве сложного первичного ключа.
 * В таблице хранятся роли каждого пользователя.*/

@Entity(name = "authorisations")
public class Authorisation {

    @EmbeddedId
    private AuthorisationKey authorisationKey;

    public Authorisation() {

    }

    public Authorisation(AuthorisationKey key) {
        this.authorisationKey = key;
    }

    public AuthorisationKey getAuthorisationKey() {
        return authorisationKey;
    }

    public void setAuthorisationKey(AuthorisationKey authorisationKey) {
        this.authorisationKey = authorisationKey;
    }
}
