package com.example.effortmanagement.model.dto;

import com.google.gson.annotations.SerializedName;

public class TaskInfoDTO {
    @SerializedName("task_id")
    private int taskID;

    @SerializedName("title")
    private String title;

    @SerializedName("status")
    private String status;

    @SerializedName("description")
    private String description;

    @SerializedName("created_date")
    private String createdDate;

    @SerializedName("end_date")
    private String endDate;

    @SerializedName("calendar_effort")
    private int calendarEffort;

    @SerializedName("project_id")
    private int projectID;

    @SerializedName("employee_id")
    private int employeeID;

    public TaskInfoDTO() {
    }

    public TaskInfoDTO(int taskID, String title, String status, String description, String createdDate, String endDate, int calendarEffort, int projectID, int employeeID) {
        this.taskID = taskID;
        this.title = title;
        this.status = status;
        this.description = description;
        this.createdDate = createdDate;
        this.endDate = endDate;
        this.calendarEffort = calendarEffort;
        this.projectID = projectID;
        this.employeeID = employeeID;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getCalendarEffort() {
        return calendarEffort;
    }

    public void setCalendarEffort(int calendarEffort) {
        this.calendarEffort = calendarEffort;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
}
