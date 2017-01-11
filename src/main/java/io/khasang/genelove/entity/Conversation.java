package io.khasang.genelove.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "conversations")
public class Conversation {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String description;

    @OneToMany(mappedBy = "conversation")
    private List<Message> messages;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
