package com.example.effortmanagement.fragment;

public class ProjectItem {
    String projectName,projectStatus;
    int totalTask;

    public ProjectItem() {
    }

    public ProjectItem(String projectName, String projectStatus, int totalTask) {
        this.projectName = projectName;
        this.projectStatus = projectStatus;
        this.totalTask = totalTask;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public int getTotalTask() {
        return totalTask;
    }

    public void setTotalTask(int totalTask) {
        this.totalTask = totalTask;
    }
}
