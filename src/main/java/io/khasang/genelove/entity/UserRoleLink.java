package io.khasang.genelove.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "user_role_link")
public class UserRoleLink {
    public UserRoleLink() {
    }

    private final String USER_ID = "user_id";
    private final String ROLE_ID = "role_id";

    @Id
    private long id;

    @Column(name = USER_ID)
    private long userId;

    @Column(name = ROLE_ID)
    private int roleId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
