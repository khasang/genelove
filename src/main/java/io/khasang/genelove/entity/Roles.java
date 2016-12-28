package io.khasang.genelove.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Roles {

    @Id
    private int role_id;

    private String role_name;

    private boolean lookTree;

    private boolean lookProfile;

    private boolean startMessage;

    public Roles() {
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public boolean isLookTree() {
        return lookTree;
    }

    public void setLookTree(boolean lookTree) {
        this.lookTree = lookTree;
    }

    public boolean isLookProfile() {
        return lookProfile;
    }

    public void setLookProfile(boolean lookProfile) {
        this.lookProfile = lookProfile;
    }

    public boolean isStartMessage() {
        return startMessage;
    }

    public void setStartMessage(boolean startMessage) {
        this.startMessage = startMessage;
    }
}
