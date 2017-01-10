package io.khasang.genelove.model;

import org.springframework.stereotype.Component;

@Component
public class Message{

    private String message = "my bean";

    public Message() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
