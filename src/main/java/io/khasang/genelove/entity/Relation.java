package io.khasang.genelove.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "relations")
public class Relation {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String relation; // e.g. Mother, Father, Daughter, etc.

    @Column
    private String name;

    @Column
    private Date dateOfBirth;

    @OneToOne(targetEntity = Tree.class)
    @JoinColumn(name = "tree_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "relations_trees_fkey"))
    private Tree tree;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
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

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }
}
