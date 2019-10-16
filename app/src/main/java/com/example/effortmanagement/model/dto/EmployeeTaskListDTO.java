package com.example.effortmanagement.model.dto;

import com.google.gson.annotations.SerializedName;

public class EmployeeTaskListDTO {
    @SerializedName("task_id")
    private Integer task_id;
    @SerializedName("title")
    private String title;
    @SerializedName("status")
    private String status;
    @SerializedName("calendar_effort")
    private Double calendar_effort;

    public EmployeeTaskListDTO() {
    }

    public EmployeeTaskListDTO(Integer task_id, String title, String status, Double calendar_effort) {
        this.task_id = task_id;
        this.title = title;
        this.status = status;
        this.calendar_effort = calendar_effort;
    }

    public Integer getTask_id() {
        return task_id;
    }

    public void setTask_id(Integer task_id) {
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

    public Double getCalendar_effort() {
        return calendar_effort;
    }

    public void setCalendar_effort(Double calendar_effort) {
        this.calendar_effort = calendar_effort;
    }
}
