package com.example.effortmanagement.model.dto;

public class EmployeeTaskListItem {
    String taskName, status;
    int effot;

    public EmployeeTaskListItem() {
    }

    public EmployeeTaskListItem(String taskName, String status, int effot) {
        this.taskName = taskName;
        this.status = status;
        this.effot = effot;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStatus() {
        return status;
    }

    public int getEffot() {
        return effot;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setEffot(int effot) {
        this.effot = effot;
    }
}
