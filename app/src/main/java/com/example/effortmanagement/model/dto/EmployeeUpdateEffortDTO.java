package com.example.effortmanagement.model.dto;

import com.google.gson.annotations.SerializedName;

public class EmployeeUpdateEffortDTO {
    @SerializedName("effort")
    private Double effort;
    @SerializedName("task_id")
    private Integer task_id;

    public EmployeeUpdateEffortDTO(Double effort, Integer task_id) {
        this.effort = effort;
        this.task_id = task_id;
    }

    public Double getEffort() {
        return effort;
    }

    public void setEffort(Double effort) {
        this.effort = effort;
    }

    public Integer getTask_id() {
        return task_id;
    }

    public void setTask_id(Integer task_id) {
        this.task_id = task_id;
    }
}
