package io.khasang.genelove.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Messages
 * @author Denis Guzikov
 * @version 1.0
 */

@Entity
public class Message {
    public Message() {
    }

    @Id
    private int id;
    @ManyToOne
    private Users user;
    /** Field "from user" */
    @ManyToOne
    private Users toUser;
    /** Field "to user" */
    @ManyToOne
    private Users fromUser;
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Users getToUser() {
        return toUser;
    }

    public void setToUser(Users toUser) {
        this.toUser = toUser;
    }

    public Users getFromUser() {
        return fromUser;
    }

    public void setFromUser(Users fromUser) {
        this.fromUser = fromUser;
    }
}
