package io.khasang.genelove.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by lembergIP on 09.12.2016.
 */
public class LembergMessage {

    private Integer a;
    private Integer b;

    public String sumTwoNumbers(Integer a,Integer b){
        return ""+a+" + "+b+" ="+(a+b);
    }

    public LembergMessage() {

    }

    public LembergMessage(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }


    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }
}
