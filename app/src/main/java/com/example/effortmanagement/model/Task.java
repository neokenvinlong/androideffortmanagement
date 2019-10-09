package com.example.effortmanagement.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Task {

    @SerializedName("task_id")
    private int task_id;

    @SerializedName("title")
    private String title;

    @SerializedName("status")
    private String status;

    @SerializedName("description")
    private String description;

    @SerializedName("created_date")
    private Date createdDate;

    @SerializedName("end_date")
    private Date endDate;

    @SerializedName("calendar_effort")
    private Double calendarEffort;

    public Task() {
    }

    public Task(int task_id, String title, String status, String description, Date createdDate, Date endDate, Double calendarEffort) {
        this.task_id = task_id;
        this.title = title;
        this.status = status;
        this.description = description;
        this.createdDate = createdDate;
        this.endDate = endDate;
        this.calendarEffort = calendarEffort;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getCalendarEffort() {
        return calendarEffort;
    }

    public void setCalendarEffort(Double calendarEffort) {
        this.calendarEffort = calendarEffort;
    }
}
