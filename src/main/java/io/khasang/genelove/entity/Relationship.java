package io.khasang.genelove.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "relationships")
public class Relationship {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "person_1_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "relationships_persons_1_fk"))
    private Person person_1;

    @ManyToOne
    @JoinColumn(name = "person_2_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "relationships_persons_2_fk"))
    private Person person_2;

    @ManyToOne
    @JoinColumn(name = "relationship_type_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "relationships_rel_types_fk"))
    private RelationshipType relationshipType;

    @ManyToOne
    @JoinColumn(name = "role_1_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "relationships_rel_roles_1_fk"))
    private RelationshipRole role_1;

    @ManyToOne
    @JoinColumn(name = "role_2_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "relationships_rel_roles_2_fk"))
    private RelationshipRole role_2;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column
    private String details;

    @ManyToOne
    @JoinColumn(name = "tree_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "relationships_trees_fk"))
    private Tree tree;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Person getPerson_1() {
        return person_1;
    }

    public void setPerson_1(Person person_1) {
        this.person_1 = person_1;
    }

    public Person getPerson_2() {
        return person_2;
    }

    public void setPerson_2(Person person_2) {
        this.person_2 = person_2;
    }

    public RelationshipType getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(RelationshipType relationshipType) {
        this.relationshipType = relationshipType;
    }

    public RelationshipRole getRole_1() {
        return role_1;
    }

    public void setRole_1(RelationshipRole role_1) {
        this.role_1 = role_1;
    }

    public RelationshipRole getRole_2() {
        return role_2;
    }

    public void setRole_2(RelationshipRole role_2) {
        this.role_2 = role_2;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }
}
