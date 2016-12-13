package io.khasang.genelove.model;

/**
 * Created by Elena on 11.12.2016.
 */
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
