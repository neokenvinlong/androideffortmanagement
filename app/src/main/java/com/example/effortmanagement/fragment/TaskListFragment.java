package com.example.effortmanagement.fragment;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.effortmanagement.R;
import com.example.effortmanagement.adapter.ExpandableListAdapter;
import com.example.effortmanagement.contract.AccountInfoContract;
import com.example.effortmanagement.contract.ProjectInfoContract;
import com.example.effortmanagement.contract.TaskContract;
import com.example.effortmanagement.model.Task;
import com.example.effortmanagement.model.dto.AccountInfoDTO;
import com.example.effortmanagement.model.dto.ProjectByPMDTO;
import com.example.effortmanagement.presenter.AccountInfoPresenter;
import com.example.effortmanagement.presenter.ProjectInfoPresenter;
import com.example.effortmanagement.presenter.TaskPresenter;
import com.example.effortmanagement.view.ViewTaskActivity;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TaskListFragment extends Fragment implements ProjectInfoContract.View, AccountInfoContract.View, TaskContract.View {

    /////////////////
    SearchView searchView;
    //ProjectAdapter projectAdapter;
//    List<ProjectItem> mData;
    SearchView.OnQueryTextListener onQueryTextListener;
    ////////////////////////////////

    private List<List<Task>> allTaskList;
    private ExpandableListAdapter listAdapter;
    private ExpandableListView expListView;
    //private List<ProjectByPMDTO> listDataHeader;
    //private List<List<String>> listDataChild;
    private Button btnAddTask;

    private ProjectInfoPresenter projectInfoPresenter;
    private AccountInfoPresenter accountInfoPresenter;
    private TaskPresenter taskPresenter;
    public static int employeeID;
    public static int taskID;
    private String token;
    private AccountInfoDTO accountInfoDTO;
    private String accountName;

    public TaskListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_task_list, container, false);
        init();

        token = this.getActivity().getIntent().getStringExtra("token");

        accountName = this.getActivity().getIntent().getStringExtra("account");

        expListView = view.findViewById(R.id.expandableListView);
        btnAddTask = view.findViewById(R.id.btnAddTask);

        // preparing list data
        accountInfoPresenter.getAccountInfo(accountName,token);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        return view;
    }
    /*
     * Preparing the list data
     */
    private void prepareListData(final List<ProjectByPMDTO> listDataHeader,final List<List<Task>> listDataChild) {
        listAdapter = new ExpandableListAdapter(requireContext(), listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);
        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                return false;
            }
        });
        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
            }
        });
        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
            }
        });
        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                taskID = listDataChild.get(groupPosition).get(childPosition).getTask_id();
                Intent intent = new Intent(v.getContext(), ViewTaskActivity.class);
                startActivity(intent);
                return false;
            }
        });
    }


    //////////////////////////////////////////////
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        /*//getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        inflater.inflate(R.menu.toolbar_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        //SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        if (menuItem != null) {
            searchView = (SearchView) menuItem.getActionView();
        }
        if (menuItem != null) {
            //searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
            onQueryTextListener = new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    String userInput = newText.toLowerCase();
                    List<ProjectItem> projectItemList = new ArrayList<>();
                    for (ProjectItem projectItem : mData) {
                        if (projectItem.getProjectName().toLowerCase().contains(userInput)) {
                            projectItemList.add(projectItem);
                        } else if (projectItem.getProjectStatus().toLowerCase().contains(userInput)) {
                            projectItemList.add(projectItem);
                        }
                    }
                    projectAdapter.updateList(projectItemList);
//                    Fragment fragment = getFragmentManager().findFragmentById(R.id.project_list_fragment);
//                    fragment.getView().setBackgroundColor(R.drawable.bg);
                    return true;
                }
            };
            searchView.setOnQueryTextListener(onQueryTextListener);
        }
        super.onCreateOptionsMenu(menu, inflater);*/
    }


    private void init() {
        projectInfoPresenter = new ProjectInfoPresenter();
        projectInfoPresenter.setmView(this);

        accountInfoPresenter = new AccountInfoPresenter();
        accountInfoPresenter.setmView(this);

        taskPresenter = new TaskPresenter();
        taskPresenter.setmView(this);
    }

    @Override
    public void getProjectInfoSuccess(List<ProjectByPMDTO> projectByPMDTOList) {
        if(projectByPMDTOList != null) {
            allTaskList = new ArrayList<>();
            for (ProjectByPMDTO projectByPMDTO : projectByPMDTOList) {
                taskPresenter.getTaskInfo(projectByPMDTO.getProjectId(), token);
            }
            prepareListData(projectByPMDTOList, allTaskList);
        }
    }

    @Override
    public void getProjectInfoFailure(String message) {

    }

    @Override
    public void getAccountInfoSuccess(AccountInfoDTO accountInfoDTO) {
        employeeID = accountInfoDTO.getId();
        //System.out.println("id la"+employeeID);
        this.projectInfoPresenter.getProjectInfo(employeeID,token);
    }

    @Override
    public void getAccountInfoFailure(String message) {

    }

    @Override
    public void getTaskInfoSuccess(List<Task> tasks) {
        allTaskList.add(tasks);
    }

    @Override
    public void getTaskInfoFailure(String message) {

    }

    @Override
    public void onResume() {
        super.onResume();
        accountInfoPresenter.getAccountInfo(accountName,token);
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
