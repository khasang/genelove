package io.khasang.genelove.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;

@Entity
public class Message {

    @Id
    private int messageId;

    private int user_id1;

    private int user_id2;

    private String message;

    private java.sql.Timestamp messageDatetime;

    public Message() {
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getUser_id1() {
        return user_id1;
    }

    public void setUser_id1(int user_id1) {
        this.user_id1 = user_id1;
    }

    public int getUser_id2() {
        return user_id2;
    }

    public void setUser_id2(int user_id2) {
        this.user_id2 = user_id2;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getMessageDatetime() {
        return messageDatetime;
    }

    public void setMessageDatetime(Timestamp messageDatetime) {
        this.messageDatetime = messageDatetime;
    }
}
