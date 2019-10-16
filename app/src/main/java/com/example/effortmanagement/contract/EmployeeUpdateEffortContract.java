package com.example.effortmanagement.contract;

import com.example.effortmanagement.model.dto.EmployeeUpdateEffortDTO;

public interface EmployeeUpdateEffortContract {

    interface Presenter{
        void updateEffort(EmployeeUpdateEffortDTO employeeUpdateEffortDTO, String token);
    }

    interface View{
        void updateEffortSuccess(String message);
        void updateEffortFailure(String message);
    }
}
