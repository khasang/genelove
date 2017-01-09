package io.khasang.genelove.entity;

import javax.persistence.*;

@Entity
public class Users_Relations {
    @Id
    private long uniq_rec_id;
    @Column
    private long id;
    /*
    @Column
    private long relative_id;
    */
    @ManyToOne
    @JoinColumn(name = "relative_id",
            foreignKey = @ForeignKey(name = "USERS_ID_FK")
    )
    private Users users;

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

}
