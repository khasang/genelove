package io.khasang.genelove.model;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMessage {
    private String myMessage;
    private long id;
    private Date date;

    public String getMyMessage() {
        return myMessage;
    }

    public long getId() {
        return id;
    }

    public Date getDate() { return date; }

}
