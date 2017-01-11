package io.khasang.genelove.entity;

import javax.persistence.*;

@Entity(name = "tree_structures")
public class TreeStructure {

    @EmbeddedId
    private TreeKey treeKey;

    public TreeKey getTreeKey() {
        return treeKey;
    }

    public void setTreeKey(TreeKey treeKey) {
        this.treeKey = treeKey;
    }
}
