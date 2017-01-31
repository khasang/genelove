package io.khasang.genelove.entity.entity_training;

import javax.persistence.*;

@Entity
public class Table {
    @Id
    private String name;

    public Table() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
