package com.example.effortmanagement.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.effortmanagement.R;
import com.example.effortmanagement.adapter.EmployeeTaskListAdapter;
import com.example.effortmanagement.contract.EmployeeTaskListContract;
import com.example.effortmanagement.model.dto.EmployeeTaskListDTO;
import com.example.effortmanagement.presenter.EmployeeTaskListPresenter;
import com.example.effortmanagement.view.EmployeeTaskDetailActivity;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class EmployeeListFragment extends Fragment implements EmployeeTaskListContract.View, EmployeeTaskListAdapter.OnTaskListener {


    RecyclerView employeeTaskListRecyclerView;
    LinearLayout employeeTaskListRecyclerViewLayout;
    EmployeeTaskListAdapter employeeTaskListAdapter;
    private EmployeeTaskListPresenter employeeTaskListPresenter;
    private String token, account_name;

    // EmployeeTaskListItem nam trong model
    List<EmployeeTaskListDTO> employeeTaskList;


    public EmployeeListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_employee_list, container, false);

        init();

        //adapter ini and setup
        employeeTaskListRecyclerView = view.findViewById(R.id.recycler_view_employee_task);
        employeeTaskListRecyclerViewLayout = view.findViewById(R.id.employeeTaskListRecyclerViewLayout);

        account_name = this.getActivity().getIntent().getStringExtra("account");
        token = this.getActivity().getIntent().getStringExtra("token");
        employeeTaskListPresenter.getListTaskOfEmployeeByAccountName(account_name, token);
//        eData = new ArrayList<>();
//
//        eData.add(new EmployeeTaskListItem("Task A", "Not Started", 1000.0));
//        eData.add(new EmployeeTaskListItem("Task B", "Done", 45.0));
//        eData.add(new EmployeeTaskListItem("Task C", "Doing", 7.0));
//        eData.add(new EmployeeTaskListItem("Task D", "Doing", 34.0));
//        eData.add(new EmployeeTaskListItem("Task E", "Not Started", 24.0));
//        eData.add(new EmployeeTaskListItem("Task F", "Doing", 588.0));
//        eData.add(new EmployeeTaskListItem("Task G", "Done", 200.0));

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        return view;

    }

    private void init(){
        employeeTaskListPresenter = new EmployeeTaskListPresenter();
        employeeTaskListPresenter.seteView(this);
    }

    private void getEmployeeTaskList(List<EmployeeTaskListDTO> employeeTaskListList){
        this.employeeTaskList = employeeTaskListList;
    }

    @Override
    public void getListTaskOfEmployeeByAccountNameSuccess(List<EmployeeTaskListDTO> employeeTaskListList) {

        //projectRecyclerView.setHasFixedSize(true);

        employeeTaskListAdapter = new EmployeeTaskListAdapter(getActivity(), employeeTaskListList, this);

        employeeTaskListRecyclerView.setAdapter(employeeTaskListAdapter);
        employeeTaskListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        getEmployeeTaskList(employeeTaskListList);
    }

    @Override
    public void getListTaskOfEmployeeByAccountNameFailure(String message) {
        Toast.makeText(this.getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTaskClick(int position) {
        int task_id = this.employeeTaskList.get(position).getTask_id();
        Intent intent = new Intent(this.getActivity().getBaseContext(), EmployeeTaskDetailActivity.class);
        intent.putExtra("TASK_ID", task_id+"");
        startActivity(intent);
    }
}
