package io.khasang.genelove.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "relations")
public class Relation {

    public enum RelationType {
        MOTHER, FATHER, SISTER, BROTHER, WIFE, HUSBAND, DAUGHTER, SON, NONE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "relation_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private RelationType relationType;

    @Column
    private String name;

    @OneToOne
    @JoinColumn(name = "tree_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "relations_trees_fkey"))
    private Tree tree;

    public Relation() {
        this.relationType = RelationType.NONE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RelationType getRelationType() {
        return relationType;
    }

    public void setRelationType(RelationType relationType) {
        this.relationType = relationType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }
}
