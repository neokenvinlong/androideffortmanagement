package com.example.effortmanagement.contract;

import com.example.effortmanagement.model.dto.EmployeeProDTO;
import com.example.effortmanagement.model.dto.ProjectByPMDTO;

import java.util.List;

public interface EmployeeProContract {
    interface Presenter{
        void getEmployeeProInfo(int projectId, String token);
    }

    interface View{
        void getEmployeeProInfoSuccess(List<EmployeeProDTO> listDTO);
        void getEmployeeProInfoFailure(String message);
    }
}
