package com.example.effortmanagement.contract;

import com.example.effortmanagement.model.dto.EmployeeTaskListDTO;

import java.util.List;

public interface EmployeeTaskListContract {
    interface View{
        void getListTaskOfEmployeeByAccountNameSuccess(List<EmployeeTaskListDTO> employeeTaskListList);
        void getListTaskOfEmployeeByAccountNameFailure(String message);
    }

    interface Presenter{
        void getListTaskOfEmployeeByAccountName(String account_name, String token);
    }
}
