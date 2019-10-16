package com.example.effortmanagement.model.dto;

import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeTaskDetailDTO {
    @SerializedName("task_id")
    private Integer task_id;
    @SerializedName("title")
    private String title;
    @SerializedName("status")
    private String status;
    @SerializedName("calendar_effort")
    private Double calendar_effort;
    @SerializedName("effort")
    private Double effort;
    @SerializedName("employee_id")
    private Integer employee_id;
    @SerializedName("created_date")
    private Date created_date;
    @SerializedName("end_date")
    private Date end_date;
    @SerializedName("description")
    private String description;
    @SerializedName("project_id")
    private Integer project_id;

    public EmployeeTaskDetailDTO() {
    }

    public EmployeeTaskDetailDTO(Integer task_id, String title, String status, Double calendar_effort, Double effort, Integer employee_id, Date created_date, Date end_date, String description) {
        this.task_id = task_id;
        this.title = title;
        this.status = status;
        this.calendar_effort = calendar_effort;
        this.effort = effort;
        this.employee_id = employee_id;
        this.created_date = created_date;
        this.end_date = end_date;
        this.description = description;
    }

    public EmployeeTaskDetailDTO(Double effort, Integer task_id) {
        this.task_id = task_id;
        this.effort = effort;
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

    public Integer getTask_id() {
        return task_id;
    }

    public void setTask_id(Integer task_id) {
        this.task_id = task_id;
    }

    public Double getCalendar_effort() {
        return calendar_effort;
    }

    public void setCalendar_effort(Double calendar_effort) {
        this.calendar_effort = calendar_effort;
    }

    public Double getEffort() {
        return effort;
    }

    public void setEffort(Double effort) {
        this.effort = effort;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public String getCreated_date() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(created_date);
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public String getEnd_date() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(end_date);
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getProject_id() {
        return project_id;
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }
}

