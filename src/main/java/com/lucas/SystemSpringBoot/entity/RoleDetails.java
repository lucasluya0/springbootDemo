package com.lucas.SystemSpringBoot.entity;

import java.io.Serializable;

public class RoleDetails implements Serializable {
    private String roleDetailsId;//角色Id

    private String roleName;//角色名字

    private String description;//说明

    private Integer sortField;//排序字段

    public String getRoleDetailsId() {
        return roleDetailsId;
    }

    public void setRoleDetailsId(String roleDetailsId) {
        this.roleDetailsId = roleDetailsId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSortField() {
        return sortField;
    }

    public void setSortField(Integer sortField) {
        this.sortField = sortField;
    }

}
