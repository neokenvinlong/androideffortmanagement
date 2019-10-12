package com.example.effortmanagement.model.dto;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class TaskCreDTO {
    @SerializedName("id")
    private int taskId;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("status")
    private String status;

    @SerializedName("endDate")
    private String endDate;

    @SerializedName("calendarEffort")
    private int calendarEffort;

    @SerializedName("project_id")
    private int projectId;

    @SerializedName("emp_id")
    private int employeeId;

    public TaskCreDTO() {
    }

    public TaskCreDTO(String title, String description, String status, String endDate, int calendarEffort, int projectId, int employeeId) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.endDate = endDate;
        this.calendarEffort = calendarEffort;
        this.projectId = projectId;
        this.employeeId = employeeId;
    }

    public TaskCreDTO(int taskId, String title, String description, String status, String endDate, int calendarEffort, int projectId, int employeeId) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.status = status;
        this.endDate = endDate;
        this.calendarEffort = calendarEffort;
        this.projectId = projectId;
        this.employeeId = employeeId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
