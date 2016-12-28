package io.khasang.genelove.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Relatives {

    @Id
    private int id;

    private int mother_id;

    private int father_id;

    public Relatives() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMother_id() {
        return mother_id;
    }

    public void setMother_id(int mother_id) {
        this.mother_id = mother_id;
    }

    public int getFather_id() {
        return father_id;
    }

    public void setFather_id(int father_id) {
        this.father_id = father_id;
    }
}


