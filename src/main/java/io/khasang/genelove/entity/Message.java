package io.khasang.genelove.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "messages")
public class Message {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "conversation_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "messages_conversations_fkey"))
    private Conversation conversation;

    @ManyToOne
    @JoinColumn(name = "from_user", referencedColumnName = "id", foreignKey = @ForeignKey(name = "messages_users_from_fkey"))
    private User fromUser;

    @ManyToOne
    @JoinColumn(name = "to_user", referencedColumnName = "id", foreignKey = @ForeignKey(name = "messages_users_to_fkey"))
    private User toUser;

    @Column(length = 2500)
    private String text;

    @Column
    private Date date;

    @Column(name = "parent_message")
    private int parentMessage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getParentMessage() {
        return parentMessage;
    }

    public void setParentMessage(int parentMessage) {
        this.parentMessage = parentMessage;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }



}