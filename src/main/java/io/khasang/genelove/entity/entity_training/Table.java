package io.khasang.genelove.entity.entity_training;

import javax.persistence.*;

@Entity
public class Table {
    @Id
    private String name;
    private int records;

    public Table() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRecords() {
        return records;
    }

    public void setRecords(int records) {
        this.records = records;
    }
}
