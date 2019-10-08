package com.example.effortmanagement.model.dto;

import com.google.gson.annotations.SerializedName;

public class AccountInfoDTO {
    @SerializedName("id")
    private String id;

    @SerializedName("accountName")
    private LoginRoleAccountDTO accountName;

    @SerializedName("email")
    private String email;

    @SerializedName("name")
    private String name;

    @SerializedName("phone")
    private String phone;

    @SerializedName("skill")
    private String skill;

    public AccountInfoDTO() {
    }

    public AccountInfoDTO(String id, LoginRoleAccountDTO accountName, String email, String name, String phone, String skill) {
        this.id = id;
        this.accountName = accountName;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.skill = skill;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LoginRoleAccountDTO getAccountName() {
        return accountName;
    }

    public void setAccountName(LoginRoleAccountDTO accountName) {
        this.accountName = accountName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
