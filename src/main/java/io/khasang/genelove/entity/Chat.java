package io.khasang.genelove.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity(name = "chats")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "created_at")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(length = 255)
    private String name;

    @Column(name = "chat_private")
    private boolean chatPrivate;

    public Chat() {
        this.chatPrivate = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChatPrivate() {
        return chatPrivate;
    }

    public void setChatPrivate(boolean chatPrivate) {
        this.chatPrivate = chatPrivate;
    }
}
