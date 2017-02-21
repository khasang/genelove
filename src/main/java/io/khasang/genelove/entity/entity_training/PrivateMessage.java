package io.khasang.genelove.entity.entity_training;

import java.util.Date;

//@Entity(name = "private_message")
public class PrivateMessage {
    public enum Status {
        READ, UNREAD
    }

    //@Id
    //@GeneratedValue
    private long id;

    //@Column(name = "sender_id")
    private long sender_id;

    //@Column(name = "recipient_id")
    private long recipient_id;

    //@Column(name = "creation_time")
    private Date creationTime;

    //@Column(name = "reading_time")
    private Date readingTime;

    //@Column
    private Enum status;

    //@Column(name = "message", length = 9999)
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
