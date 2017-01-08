package io.khasang.genelove.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Users {
    @Id
    private long id;
    @Column
    private String login;
    private String name;
    private String password;
    //private int role_id;
    public Users() {
    }

    @OneToMany
    private List<Roles> roles = new ArrayList<>();
    public List<Roles> getRoles() {
        return roles;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    /*
    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) { this.role_id = role_id; }
    */
}
