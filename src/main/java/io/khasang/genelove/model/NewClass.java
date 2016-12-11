package io.khasang.genelove.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by Дэн on 10.12.16.
 */

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
