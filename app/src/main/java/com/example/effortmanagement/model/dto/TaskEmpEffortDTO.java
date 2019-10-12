package com.example.effortmanagement.model.dto;

import com.google.gson.annotations.SerializedName;

public class TaskEmpEffortDTO {

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("effort")
    private int effort;

    @SerializedName("calendar_effort")
    private int calendarEffort;

    public TaskEmpEffortDTO() {
    }

    public TaskEmpEffortDTO(int id, String title, int effort, int calendarEffort) {
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

    public int getEffort() {
        return effort;
    }

    public void setEffort(int effort) {
        this.effort = effort;
    }

    public int getCalendarEffort() {
        return calendarEffort;
    }

    public void setCalendarEffort(int calendarEffort) {
        this.calendarEffort = calendarEffort;
    }
}
