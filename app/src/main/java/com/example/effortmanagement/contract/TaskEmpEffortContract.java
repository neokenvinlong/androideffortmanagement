package com.example.effortmanagement.contract;

import com.example.effortmanagement.model.dto.TaskEmpEffortDTO;

import java.util.List;

public interface TaskEmpEffortContract {
    interface Presenter{
        void getTaskEmpEffortChart(int employeeID, String token);
    }
    interface View{
        void getTaskEmpEffortChartSuccess(List<TaskEmpEffortDTO> listDTO);
        void getTaskEmpEffortChartFailure(String message);
    }
}
