package io.khasang.genelove.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Roles {
    public Roles() {
    }

    private final String ROLE_NAME = "role_name";

    @Id
    private int id;

    @Column(name = ROLE_NAME)
    private String roleName;

    private String descr;
//    @ManyToMany
//    private List<Users> users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String role_name) {
        this.roleName = role_name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}
