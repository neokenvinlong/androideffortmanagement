package com.example.effortmanagement.contract;

import com.example.effortmanagement.model.dto.TaskEffortDTO;

import java.util.List;

public interface TaskEffortContract {
    interface Presenter{
        void getTaskEffortChart(int projectID, String token);
    }

    interface View{
        void getTaskEffortChartSuccess(List<TaskEffortDTO> dtoList);
        void getTaskEffortChartFailure(String message);
    }
}
