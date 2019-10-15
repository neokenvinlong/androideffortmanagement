package com.example.effortmanagement.model.dto;

import com.google.gson.annotations.SerializedName;

public class TaskEmpEffortDTO {

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("effort")
    private double effort;

    @SerializedName("calendar_effort")
    private double calendarEffort;

    public TaskEmpEffortDTO() {
    }

    public TaskEmpEffortDTO(int id, String title, double effort, double calendarEffort) {
        this.id = id;
        this.title = title;
        this.effort = effort;
        this.calendarEffort = calendarEffort;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getEffort() {
        return effort;
    }

    public void setEffort(double effort) {
        this.effort = effort;
    }

    public double getCalendarEffort() {
        return calendarEffort;
    }

    public void setCalendarEffort(double calendarEffort) {
        this.calendarEffort = calendarEffort;
    }
}
