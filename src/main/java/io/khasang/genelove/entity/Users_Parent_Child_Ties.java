package io.khasang.genelove.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users_Parent_Child_Ties {
    @Id
    private long uniq_rec_id;
    @Column
    private long user_id;
    @Column
    private long parent_id;
    @Column
    private long child_id;

    public Users_Parent_Child_Ties() {
    }

    public long getUniq_rec_id() {
        return uniq_rec_id;
    }

    public void setUniq_rec_id(long uniq_rec_id) {
        this.uniq_rec_id = uniq_rec_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getParent_id() {
        return parent_id;
    }

    public void setParent_id(long parent_id) {
        this.parent_id = parent_id;
    }

    public long getChild_id() {
        return child_id;
    }

    public void setChild_id(long child_id) {
        this.child_id = child_id;
    }

}
