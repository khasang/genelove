package io.khasang.genelove.entity;

import javax.persistence.*;

/** Class that is used by Hibernate to create table "relationship_types" in the Database.
 * The table is used to create Genealogical Tree.
 *
 * Класс, используя который, Hibernate создаёт таблицу в Базе данных.
 * Список используется для построения Генеалогического Дерева.*/

@Entity(name = "relationship_types")
public class RelationshipType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column
    private String description;

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
}
