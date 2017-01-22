package io.khasang.genelove.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class PrivateMessage {
    public enum Status {
        READ, UNREAD
    }

    @Id
    @GeneratedValue
    private long id;

    @Column
    private long sender_id;

    @Column
    private long recipient_id;

    @Column
    private Date creationTime;

    @Column
    private Date readingTime;

    @Column
    private Enum status;

    @Column(length = 9999)
    private String PrivateMessage;

    public PrivateMessage() {
    }

    public PrivateMessage(long sender_id, long recipient_id, String PrivateMessage) {
        this.sender_id = sender_id;
        this.recipient_id = recipient_id;
        this.creationTime = new Date(System.currentTimeMillis());
        this.readingTime = null;
        this.status = Status.UNREAD;
        this.PrivateMessage = PrivateMessage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSender_id() {
        return sender_id;
    }

    public void setSender_id(long sender_id) {
        this.sender_id = sender_id;
    }

    public long getRecipient_id() {
        return recipient_id;
    }

    public void setRecipient_id(long recipient_id) {
        this.recipient_id = recipient_id;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getReadingTime() {
        return readingTime;
    }

    public void setReadingTime(Date readingTime) {
        this.readingTime = readingTime;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }

    public String getPrivateMessage() {
        return PrivateMessage;
    }

    public void setPrivateMessage(String PrivateMessage) {
        this.PrivateMessage = PrivateMessage;
    }
}
