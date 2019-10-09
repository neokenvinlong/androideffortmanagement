package com.example.effortmanagement.model.dto;

import com.google.gson.annotations.SerializedName;

public class ProjectByPMDTO {

    @SerializedName("id")
    private int projectId;

    @SerializedName("name")
    private String projectName;

    @SerializedName("status")
    private String status;

    public ProjectByPMDTO() {
    }

    public ProjectByPMDTO(int projectId, String projectName, String status) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.status = status;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
