package com.example.effortmanagement.model.dto;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class EmployeeProDTO {

    @SerializedName("employee_id")
    private int employeeID;

    @SerializedName("name")
    private String employeeName;

    public EmployeeProDTO() {
    }

    public EmployeeProDTO(int employeeID, String employeeName) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @NonNull
    @Override
    public String toString() {
        return this.getEmployeeName();
    }
}
