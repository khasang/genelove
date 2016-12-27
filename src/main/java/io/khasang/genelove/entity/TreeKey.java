package io.khasang.genelove.entity;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class TreeKey implements Serializable {

    @ManyToOne(targetEntity = Relation.class)
    @JoinColumn(name = "relation", referencedColumnName = "id", foreignKey = @ForeignKey(name = "trees_relations_relation_fkey"))
    private Relation relation;

    @ManyToOne(targetEntity = Relation.class)
    @JoinColumn(name = "parent", referencedColumnName = "id", foreignKey = @ForeignKey(name = "trees_relations_parent_fkey"))
    private Relation parent;

    public Relation getRelation() {
        return relation;
    }

    public void setRelation(Relation relation) {
        this.relation = relation;
    }

    public Relation getParent() {
        return parent;
    }

    public void setParent(Relation parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreeKey treeKey = (TreeKey) o;

        if (relation != null ? !relation.equals(treeKey.relation) : treeKey.relation != null) return false;
        return parent != null ? parent.equals(treeKey.parent) : treeKey.parent == null;
    }

    @Override
    public int hashCode() {
        int result = relation != null ? relation.hashCode() : 0;
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        return result;
    }
}
