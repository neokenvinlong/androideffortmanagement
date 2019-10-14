package com.example.effortmanagement.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.effortmanagement.R;
import com.example.effortmanagement.adapter.EmployeeTaskListAdapter;
import com.example.effortmanagement.model.dto.EmployeeTaskListItem;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class EmployeeListFragment extends Fragment {


    RecyclerView employeeTaskListRecyclerView;
    LinearLayout employeeTaskListRecyclerViewLayout;
    EmployeeTaskListAdapter employeeTaskListAdapter;

    // EmployeeTaskListItem nam trong model
    List<EmployeeTaskListItem> eData;


    public EmployeeListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_employee_list, container, false);


        eData = new ArrayList<>();

        eData.add(new EmployeeTaskListItem("Task A", "Not Started", 1000));
        eData.add(new EmployeeTaskListItem("Task B", "Done", 45));
        eData.add(new EmployeeTaskListItem("Task C", "Doing", 7));
        eData.add(new EmployeeTaskListItem("Task D", "Doing", 34));
        eData.add(new EmployeeTaskListItem("Task E", "Not Started", 24));
        eData.add(new EmployeeTaskListItem("Task F", "Doing", 588));
        eData.add(new EmployeeTaskListItem("Task G", "Done", 200));

        //adapter ini and setup
        employeeTaskListRecyclerView = view.findViewById(R.id.recycler_view_employee_task);
        employeeTaskListRecyclerViewLayout = view.findViewById(R.id.employeeTaskListRecyclerViewLayout);
        //projectRecyclerView.setHasFixedSize(true);

        employeeTaskListAdapter = new EmployeeTaskListAdapter(getActivity(), eData);


        employeeTaskListRecyclerView.setAdapter(employeeTaskListAdapter);
        employeeTaskListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        return view;

    }

}
