package io.khasang.genelove.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Factories {
    @Id
    private int id;

    @Column(name = "inn")
    private String names;

    @Column
    private int cowCount;

    public Factories() {
    }

    public int getCowCount() {
        return cowCount;
    }

    public void setCowCount(int cowCount) {
        this.cowCount = cowCount;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
