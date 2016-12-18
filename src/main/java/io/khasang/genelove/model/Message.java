package io.khasang.genelove.model;

import org.springframework.stereotype.Component;

// Created by DGatilov on 17.12.2016.
@Component
public class Message {
    private String messageOut;

    public Message(String messageOut) {
        this.messageOut = messageOut;
    }

    public String getMessageOut() {
        return messageOut;
    }

    public void setMessageOut(String messageOut) {
        this.messageOut = messageOut;
    }

    public Message() {

    }
}