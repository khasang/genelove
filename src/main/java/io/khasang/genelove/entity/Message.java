package io.khasang.genelove.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Сообщения
 */

@Entity
public class Message {
    public Message() {
    }

    @Id
    private int id;
    @ManyToOne
    private Users user;
    @ManyToOne
    private Users toUser;     //от кого
    @ManyToOne
    private Users fromUser;   //кому
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
}
