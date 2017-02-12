package io.khasang.genelove.entity;

import javax.persistence.*;
import java.io.Serializable;

/** Class that is composite primary key of two different fields "user_id" and "role_id".
 * It is embeddable, so can be used as part of other classes, in our case entity classes to create tables.
 * https://docs.oracle.com/cd/E16439_01/doc.1013/e13981/cmp30cfg001.htm
 * Класс, который является сложным первичным ключом из двух разных полей.
 * Он встраиваемый, то есть может использоваться как часть других классов, в нашем случае - классов сущностей */

@Embeddable
public class AuthorisationKey implements Serializable {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "authorisations_user_fk"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "authorisations_role_fk"))
    private Role role;

    public AuthorisationKey() {

    }

    public AuthorisationKey(User user, Role role) {
        this.user = user;
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorisationKey that = (AuthorisationKey) o;

        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return role != null ? role.equals(that.role) : that.role == null;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}

