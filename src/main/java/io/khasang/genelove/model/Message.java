package io.khasang.genelove.model;

import org.springframework.stereotype.Component;

@Component
public class Message {
    private String messageOut;
    private String message = "my bean";

    public Message(String messageOut) {
        this.messageOut = messageOut;
    }


    public String getMessageOut() {
        return messageOut;
    }

    public void setMessageOut(String messageOut) {
        this.messageOut = messageOut;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;

    }
}
