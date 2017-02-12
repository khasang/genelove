package io.khasang.genelove.entity;

import javax.persistence.*;

/** Class that is used by Hibernate to create table "trees" in the Database.
 * This table is used to store id-s of Genealogical Trees of registered users.
 *
 * Класс, используя который, Hibernate создаёт таблицу в Базе данных.
 * В таблице хранятся id деревьев зарегистрированных пользователей.*/

@Entity(name = "trees")
public class Tree {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column
    private String description;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "trees_users_fk"))
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

