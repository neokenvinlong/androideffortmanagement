package com.example.effortmanagement.contract;

import com.example.effortmanagement.model.dto.ProjectByPMDTO;

import java.util.List;

public interface ProjectInfoContract {
    interface Presenter{
        void getProjectInfo(int id, String token);
    }

    interface View{
        void getProjectInfoSuccess(List<ProjectByPMDTO> projectByPMDTOList);
        void getProjectInfoFailure(String message);
    }
}
