package com.example.effortmanagement.model.dto;

import com.google.gson.annotations.SerializedName;

public class NotificationDetailDTO {

    @SerializedName("id")
    private int effortID;

    @SerializedName("title")
    private String title;

    @SerializedName("account_name")
    private String accountName;

    @SerializedName("calendar_effort")
    private double calendarEffort;

    @SerializedName("effort")
    private double actualEffort;

    public NotificationDetailDTO() {
    }

    public NotificationDetailDTO(int effortID, String title, String accountName, double calendarEffort, double actualEffort) {
        this.effortID = effortID;
        this.title = title;
        this.accountName = accountName;
        this.calendarEffort = calendarEffort;
        this.actualEffort = actualEffort;
    }

    public int getEffortID() {
        return effortID;
    }

    public void setEffortID(int effortID) {
        this.effortID = effortID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getCalendarEffort() {
        return calendarEffort;
    }

    public void setCalendarEffort(double calendarEffort) {
        this.calendarEffort = calendarEffort;
    }

    public double getActualEffort() {
        return actualEffort;
    }

    public void setActualEffort(double actualEffort) {
        this.actualEffort = actualEffort;
    }
}
