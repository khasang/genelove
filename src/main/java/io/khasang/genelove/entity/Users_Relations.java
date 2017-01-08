package io.khasang.genelove.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users_Relations {
    @Id
    private long uniq_rec_id;
    @Column
    private long id;
    @Column
    private long relative_id;

    public Users_Relations() {
    }

    public long getUniq_rec_id() {
        return uniq_rec_id;
    }

    public void setUniq_rec_id(long uniq_rec_id) {
        this.uniq_rec_id = uniq_rec_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRelative_id() {
        return relative_id;
    }

    public void setRelative_id(long relative_id) {
        this.relative_id = relative_id;
    }
}
