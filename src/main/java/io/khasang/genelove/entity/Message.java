package io.khasang.genelove.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/** Class that is used by Hibernate to create table "messages" in the Database.
 * Table is used to store user-to-user dialog correspondence.
 *
 * Класс, используя который, Hibernate создаёт таблицу в Базе данных.
 * В таблице хранится переписка между двумя пользователями (диалог). */

@Entity(name = "messages")
public class Message {

    public enum MessageStatus {
        NEW, SENT, RECEIVED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "messages_users_sender_fk"))
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "messages_users_receiver_fk"))
    private User receiver;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @Column(name = "sent_date")
    private Timestamp sentDate;

    @Column(name = "received_date")
    private Timestamp receivedDate;

    @Column(name = "message_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private MessageStatus messageStatus;

    @Column(length = 2500)
    private String text;

    public Message() {
        this.messageStatus = MessageStatus.NEW;
        this.createdDate = new Timestamp(new Date().getTime());
    }

    public Message(User sender, User receiver, String text) {
        this.setSender(sender);
        this.setReceiver(receiver);
        this.setCreatedDate(new Timestamp((new Date().getTime()/1000)*1000));
        this.setReceivedDate(null);
        this.setSentDate(null);
        this.setText(text);
        this.messageStatus = MessageStatus.NEW;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getSentDate() {
        return sentDate;
    }

    public void setSentDate(Timestamp sentDate) {
        this.sentDate = sentDate;
    }

    public Timestamp getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Timestamp receivedDate) {
        this.receivedDate = receivedDate;
    }

    public MessageStatus getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(MessageStatus messageStatus) {
        this.messageStatus = messageStatus;
    }
}
