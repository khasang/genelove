package io.khasang.genelove.model;

public class MyMessage {
    private String message;

    public MyMessage() {
        this("");
    }

    public MyMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
