package io.khasang.genelove.model;


public class Message {
    private String messageOut;

    public Message(String messageOut) {
        this.messageOut = messageOut;
    }

    public Message() {
    }

    public String getMessageOut() {
        return messageOut;
    }

    public void setMessageOut(String messageOut) {
        this.messageOut = messageOut;
    }
}
