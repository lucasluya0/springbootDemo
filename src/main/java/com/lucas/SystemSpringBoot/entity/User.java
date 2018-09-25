package com.lucas.SystemSpringBoot.entity;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private String id;
    private String head;
    private String name;
    private String password;
    private String phone;
    private String picture;
    private String sex;
    private List<RoleDetails> roles;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<RoleDetails> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDetails> roles) {
        this.roles = roles;
    }


}
