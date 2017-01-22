package io.khasang.genelove.entity;

import javax.persistence.*;
import java.util.*;

@Entity(name = "roles")
public class Role {

    public enum RoleName {
        ROLE_ADMIN, ROLE_BLOCKED, ROLE_USER, ROLE_DB
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "role_name", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    public Role() {

    }

    /*public Role(RoleName roleName) {
        this.roleName = roleName;
    }

    public static Map<RoleName, String> getRoleList() {
        Map<RoleName, String> roleList = new HashMap<>();
        for (RoleName role : RoleName.values()) {
            roleList.put(role, role.toString());
        }
        return roleList;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (id != role.id) return false;
        return roleName == role.roleName;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        return result;
    }
}
