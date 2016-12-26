package io.khasang.genelove.entity;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
public class Users_Roles_Ties {
    @Id
    private long uniq_rec_id;
    @Column
    private long user_id;
    @Column
    private int role_id;

    public Users_Roles_Ties() {
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

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
}
