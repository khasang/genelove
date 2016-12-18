package io.khasang.genelove.model;

import org.springframework.stereotype.Component;

@Component
public class NewClass {

    private String messOut;

    public NewClass(String messOut) {
        this.messOut = messOut;
    }

    public NewClass(){}

    public String getMessOut() {
        return messOut;
    }

    public void setMessOut(String messOut) {
        this.messOut = messOut;
    }
}
