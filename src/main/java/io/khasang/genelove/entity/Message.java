package io.khasang.genelove.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Сообщения
 * @author Denis Guzikov
 * @version 1.0
 */

@Entity
public class Message {
    public Message() {
    }

    @Id
    private int id;
    private long userId;
    /** Поле "от кого" */
    private long toUserId;
    /** Поле "кому" */
    private long fromUserId;
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getToUserId() {
        return toUserId;
    }

    public void setToUserId(long toUserId) {
        this.toUserId = toUserId;
    }

    public long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
