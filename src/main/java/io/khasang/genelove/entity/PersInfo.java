package io.khasang.genelove.entity;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Personal info
 * @author Denis Guzikov
 * @version 1.0
 */

public class PersInfo {
    public PersInfo() {
    }

    @Id
    private long id;
    /** Field "about me" */
    private String info;
    private  int orientation;
    private int relationStatus;
    private int height;
    private int weight;
    private int bodyType;
    private int eyeColor;
    private int hairColor;
    /** Field "who I seek" */
    private String lookingFor;
    private String phone;
    private String email;
    private String address;
    private int smoking;
    private int alcohol;
    private int children;
    private int livingStatus;

    @ManyToOne
    private Users user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getLookingFor() {
        return lookingFor;
    }

    public void setLookingFor(String lookingFor) {
        this.lookingFor = lookingFor;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public int getRelationStatus() {
        return relationStatus;
    }

    public void setRelationStatus(int relationStatus) {
        this.relationStatus = relationStatus;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getBodyType() {
        return bodyType;
    }

    public void setBodyType(int bodyType) {
        this.bodyType = bodyType;
    }

    public int getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(int eyeColor) {
        this.eyeColor = eyeColor;
    }

    public int getHairColor() {
        return hairColor;
    }

    public void setHairColor(int hairColor) {
        this.hairColor = hairColor;
    }

    public int getSmoking() {
        return smoking;
    }

    public void setSmoking(int smoking) {
        this.smoking = smoking;
    }

    public int getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(int alcohol) {
        this.alcohol = alcohol;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public int getLivingStatus() {
        return livingStatus;
    }

    public void setLivingStatus(int livingStatus) {
        this.livingStatus = livingStatus;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
