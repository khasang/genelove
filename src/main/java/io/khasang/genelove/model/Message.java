package io.khasang.genelove.model;

import org.springframework.stereotype.Component;

/**
 * Created by Руслан on 11.12.2016.
 */


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
