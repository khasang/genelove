package io.khasang.genelove.model;

import org.springframework.stereotype.Component;

@Component
public class Temp {

    private int count = 0;

    public int sum(int i) {
        for (int j = 0; j < 1000 ; j++) {
            count++;
            count--;
        }
        return count + i;
    }
}
