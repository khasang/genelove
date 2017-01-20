package io.khasang.genelove.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "users_old")
public class Users {
    @Id
    private long id;

    private String login;
    private String name;
    private String password;
    private int role_id;
    public Users() {
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

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }


}
