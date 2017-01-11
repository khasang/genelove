package io.khasang.genelove.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "roles")
public class Role {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "role_name", length = 255)
    private String roleName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
