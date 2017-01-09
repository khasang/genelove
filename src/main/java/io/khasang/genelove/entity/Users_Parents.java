package io.khasang.genelove.entity;

import javax.persistence.*;

@Entity
public class Users_Parents {
    @Id
    private long id;

    @Column
    private long mother_id;
    @Column
    private long father_id;

    public Users_Parents() {
    }
    /*
    public long get_id() {
        return id;
    }
    */
    /* public void set_id(long id) {
        this.id = id;
    }
    */

    public long getMother_id() {
        return mother_id;
    }

    public void setMother_id(long mother_id) {
        this.mother_id = mother_id;
    }

    public long getFather_id() {
        return father_id;
    }

    public void setFather_id(long father_id) {
        this.father_id = father_id;
    }
}
