package io.khasang.genelove.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity(name = "chat_messages")
public class ChatMessage {

    public enum ChatMessageStatus {
        SENT, DELETED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "chat_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "chat_messages_chats_fk"))
    private Chat chat;

    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "chat_messages_users_fk"))
    private User sender;

    @Column(length = 500)
    private String text;

    @Column(name = "sent_at")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date sentAt;

    @Column(name = "message_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ChatMessageStatus status;

    public ChatMessage() {
        this.status = ChatMessageStatus.SENT;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getSentAt() {
        return sentAt;
    }

    public void setSentAt(Date sentAt) {
        this.sentAt = sentAt;
    }

    public ChatMessageStatus getStatus() {
        return status;
    }

    public void setStatus(ChatMessageStatus status) {
        this.status = status;
    }
}
