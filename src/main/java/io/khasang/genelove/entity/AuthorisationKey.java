package io.khasang.genelove.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AuthorisationKey implements Serializable {

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "role_id", nullable = false)
    private int roleId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorisationKey that = (AuthorisationKey) o;

        if (userId != that.userId) return false;
        return roleId == that.roleId;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + roleId;
        return result;
    }
}