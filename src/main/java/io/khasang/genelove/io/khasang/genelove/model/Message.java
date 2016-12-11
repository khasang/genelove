package io.khasang.genelove.io.khasang.genelove.model;

import org.springframework.stereotype.Component;

/**
 * Created by Руслан on 11.12.2016.
 */


//@Component
public class Message{

    private String message;

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
