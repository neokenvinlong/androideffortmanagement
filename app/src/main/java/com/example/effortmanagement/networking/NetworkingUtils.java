package com.example.effortmanagement.networking;

import com.example.effortmanagement.adapter.RetrofitAdapter;
import com.example.effortmanagement.networking.API.AccountInfoService;
import com.example.effortmanagement.networking.API.AccountService;
import com.example.effortmanagement.networking.API.EmployeeProService;
import com.example.effortmanagement.networking.API.ProjectByPMService;
import com.example.effortmanagement.networking.API.RoleService;
import com.example.effortmanagement.networking.API.TaskCreService;
import com.example.effortmanagement.networking.API.TaskEffortService;
import com.example.effortmanagement.networking.API.TaskEmpEffortService;
import com.example.effortmanagement.networking.API.TaskService;

public class NetworkingUtils {
    private static AccountService accountService;
    private static RoleService roleService;
    private static AccountInfoService accountInfoService;
    private static ProjectByPMService projectByPMService;
    private static TaskService taskService;
    private static TaskCreService taskCreService;
    private static EmployeeProService employeeProService;
    private static TaskEffortService taskEffortService;
    private static TaskEmpEffortService taskEmpEffortService;

    public static AccountService getUserApiInstance() {
        if (accountService == null)
            accountService = RetrofitAdapter.getInstance().create(AccountService.class);

        return accountService;
    }

    public static RoleService getRoleApiInstance() {
        if (roleService == null)
            roleService = RetrofitAdapter.getInstance().create(RoleService.class);

        return roleService;
    }

    public static AccountInfoService getInfoByAccountApiInstance() {
        if (accountInfoService == null)
            accountInfoService = RetrofitAdapter.getInstance().create(AccountInfoService.class);
        return accountInfoService;
    }

    public static ProjectByPMService getProjectInfoByPMApiInstance(){
        if(projectByPMService == null){
            projectByPMService = RetrofitAdapter.getInstance().create(ProjectByPMService.class);
        }
        return projectByPMService;
    }

    public static TaskService getTaskApiInstance(){
        if(taskService == null){
            taskService = RetrofitAdapter.getInstance().create(TaskService.class);
        }
        return taskService;
    }

    public static TaskCreService getTaskCreApiInstance(){
        if (taskCreService == null){
            taskCreService = RetrofitAdapter.getInstance().create(TaskCreService.class);
        }
        return taskCreService;
    }

    public static EmployeeProService getEmployeeProApiInstance(){
        if (employeeProService == null){
            employeeProService = RetrofitAdapter.getInstance().create(EmployeeProService.class);
        }
        return employeeProService;
    }

    public static TaskEffortService getTaskEffortApiInstance(){
        if (taskEffortService == null){
            taskEffortService = RetrofitAdapter.getInstance().create(TaskEffortService.class);
        }
        return taskEffortService;
    }

    public static TaskEmpEffortService getTaskEmpEffortApiInstance(){
        if (taskEmpEffortService == null){
            taskEmpEffortService = RetrofitAdapter.getInstance().create(TaskEmpEffortService.class);
        }
        return taskEmpEffortService;
    }
}
