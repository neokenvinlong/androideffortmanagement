package com.example.effortmanagement.networking;

import com.example.effortmanagement.adapter.RetrofitAdapter;
import com.example.effortmanagement.networking.API.AccountInfoService;
import com.example.effortmanagement.networking.API.AccountService;
import com.example.effortmanagement.networking.API.EmployeeProService;
import com.example.effortmanagement.networking.API.EmployeeTaskDetailService;
import com.example.effortmanagement.networking.API.EmployeeTaskListService;
import com.example.effortmanagement.networking.API.EmployeeUpdateEffortService;
import com.example.effortmanagement.networking.API.ProjectByPMService;
import com.example.effortmanagement.networking.API.RoleService;
import com.example.effortmanagement.networking.API.TaskCreService;
import com.example.effortmanagement.networking.API.TaskEffortService;
import com.example.effortmanagement.networking.API.TaskEmpEffortService;
import com.example.effortmanagement.networking.API.TaskInfoService;
import com.example.effortmanagement.networking.API.TaskService;
import com.example.effortmanagement.networking.API.TaskUpdateService;
import com.example.effortmanagement.presenter.TaskUpdatePresenter;

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
    private static TaskInfoService taskInfoService;
    private static TaskUpdateService taskUpdateService;
    private static EmployeeTaskListService employeeTaskListService;
    private static EmployeeTaskDetailService employeeTaskDetailService;
    public static EmployeeUpdateEffortService employeeUpdateEffortService;


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
    public static TaskInfoService getTaskInfoApiInstance(){
        if(taskInfoService == null){
            taskInfoService = RetrofitAdapter.getInstance().create(TaskInfoService.class);
        }
        return taskInfoService;
    }
    public static TaskUpdateService getTaskUpdateApiInstance(){
        if(taskUpdateService == null){
            taskUpdateService = RetrofitAdapter.getInstance().create(TaskUpdateService.class);
        }
        return taskUpdateService;
    }
    public static EmployeeTaskListService getListTaskOfEmployeeByAccountNameInstance(){
        if (employeeTaskListService == null){
            employeeTaskListService = RetrofitAdapter.getInstance().create(EmployeeTaskListService.class);
        }
        return employeeTaskListService;
    }

    public static EmployeeTaskDetailService getInfoOfTaskByTaskIdInstance(){
        if (employeeTaskDetailService == null){
            employeeTaskDetailService = RetrofitAdapter.getInstance().create(EmployeeTaskDetailService.class);
        }
        return employeeTaskDetailService;
    }

    public static EmployeeUpdateEffortService updateEffortInstance(){
        if (employeeUpdateEffortService == null){
            employeeUpdateEffortService = RetrofitAdapter.getInstance().create(EmployeeUpdateEffortService.class);
        }
        return employeeUpdateEffortService;
    }
}
