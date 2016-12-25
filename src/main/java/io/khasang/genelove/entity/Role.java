package io.khasang.genelove.entity;


public enum Role {
    USER("USER"),
    MANAGER("MANAGER"),
    ADMINISTRATOR("ADMINISTRATOR");
    String name;


    Role(final String name){
        this.name=name;
    }
}
