package com.haoyan.homeworkEbayRest.entity;

import java.util.ArrayList;

public class User {
    private int userId;
    private String accountName;
    private String role;
    private ArrayList<String> endpointList;
    public User(int userId, String accountName, String role){
        this.userId = userId;
        this.accountName = accountName;
        this.role = role;
        this.endpointList = new ArrayList<>();
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ArrayList<String> getEndpointList() {
        return endpointList;
    }

    public void setEndpointList(ArrayList<String> endpointList) {
        this.endpointList = endpointList;
    }
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", accountName='" + accountName + '\'' +
                ", role=" + role +
                ", endpointList=" + endpointList +
                '}';
    }
}
