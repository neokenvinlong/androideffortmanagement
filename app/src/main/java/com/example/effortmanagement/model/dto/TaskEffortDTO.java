package com.example.effortmanagement.model.dto;

import com.google.gson.annotations.SerializedName;

public class TaskEffortDTO {

    @SerializedName("title")
    private String title;

    @SerializedName("calendar_effort")
    private Double calendarEffort;

    public TaskEffortDTO() {
    }

    public TaskEffortDTO(String title, Double calendarEffort) {
        this.title = title;
        this.calendarEffort = calendarEffort;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getCalendarEffort() {
        return calendarEffort;
    }

    public void setCalendarEffort(Double calendarEffort) {
        this.calendarEffort = calendarEffort;
    }
}
