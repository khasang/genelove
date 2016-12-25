package io.khasang.genelove.entity;

import io.khasang.genelove.constants.UserConstants;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity(name = UserConstants.Entity.TABLE_NAME_USER)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = UserConstants.Entity.ID_USER)
    private Long id;
    @Column(name = UserConstants.Entity.LOGIN)
    private String login;
    @Column(name = UserConstants.Entity.PASSWORD)
    private String password;
    @Column(name = UserConstants.Entity.ROLE)
    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
