package io.khasang.genelove.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * BookMarks(favorite users)
 * @author Denis Guzikov
 * @version 1.0
 */

@Entity
public class BookMark {
    public BookMark() {
    }

    @Id
    private long id;
    @ManyToOne
    private Users user;
    @ManyToOne
    private Users markUser;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Users getMarkUser() {
        return markUser;
    }

    public void setMarkUser(Users markUser) {
        this.markUser = markUser;
    }
}
