package com.example.effortmanagement.model;

import com.google.gson.annotations.SerializedName;

public class Account {
    @SerializedName("name")
    private String name;

    @SerializedName("password")
    private String password;

    @SerializedName("role")
    private String role;

    @SerializedName("token")
    private String tokens;

    public Account(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTokens() {
        return tokens;
    }

    public void setTokens(String tokens) {
        this.tokens = tokens;
    }
}
