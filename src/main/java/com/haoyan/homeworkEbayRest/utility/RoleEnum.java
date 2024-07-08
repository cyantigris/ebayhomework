package com.haoyan.homeworkEbayRest.utility;

public enum RoleEnum {
    ADMIN("admin"), USER("user");
    private String role;
    RoleEnum(String role){
        this.role = role;
    }
    public String getRoleValue(){
        return role;
    }
}