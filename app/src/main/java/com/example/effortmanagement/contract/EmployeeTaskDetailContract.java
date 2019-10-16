package com.example.effortmanagement.contract;

import com.example.effortmanagement.model.dto.EmployeeTaskDetailDTO;

public interface EmployeeTaskDetailContract {

    interface Presenter{
        void getInfoOfTaskByTaskId(int task_id, String token);
    }

    interface View{
        void getInfoOfTaskByTaskIdSuccess(EmployeeTaskDetailDTO employeeTaskDetailDTO);
        void getInfoOfTaskByTaskIdFailure(String message);
    }
}
