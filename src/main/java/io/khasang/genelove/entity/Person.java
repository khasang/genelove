package io.khasang.genelove.entity;

import javax.persistence.*;
import java.util.Date;

/** Class that is used by Hibernate to create table "persons" in the Database.
 * This table is used to store list of relatives of the user. Relatives are not necessary registered users.
 * The list is used to create Genealogical Tree.
 *
 * Класс, используя который, Hibernate создаёт таблицу в Базе данных.
 * В таблице хранится список родствеников пользователя. Родственники - не обязательно зарегистрированные пользователи.
 * Список используется для построения Генеалогического Дерева.*/

@Entity(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column
    private String name;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "place_of_birth")
    private String placeOfBirth;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "persons_users_fk"))
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
