package io.khasang.genelove.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "trees")
public class Tree {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
