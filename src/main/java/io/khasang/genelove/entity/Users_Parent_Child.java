package io.khasang.genelove.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users_Parent_Child {
    @Id
    private long id;
    @Column
    private long parent_id;
    @Column
    private long child_id;

    public Users_Parent_Child() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
