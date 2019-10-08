package com.example.effortmanagement.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.effortmanagement.R;
import com.example.effortmanagement.adapter.ExpandableListAdapter;
import com.example.effortmanagement.adapter.ProjectAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TaskListFragment extends Fragment {

   // ///////////////
    SearchView searchView;
    ProjectAdapter projectAdapter;
    List<ProjectItem> mData;
    SearchView.OnQueryTextListener onQueryTextListener;
    ////////////////////////////////

    private ExpandableListAdapter listAdapter;
    private ExpandableListView expListView;
    private List<ProjectItem> listDataHeader;
    private List<List<String>> listDataChild;
    private Button btnAddTask;



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
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_task_list, container, false);

        // get the listview
        expListView = (ExpandableListView) view.findViewById(R.id.lvExp);

        // get the button add task
        btnAddTask = view.findViewById(R.id.btnAddTask);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(requireContext(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                groupPosition).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });


        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        return view;
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<ProjectItem>();
        listDataChild = new ArrayList<List<String>>();

        ProjectItem projectItem = new ProjectItem("aaa","aaa",5);
        ProjectItem projectItem1 = new ProjectItem("bbb","bbb",5);
        ProjectItem projectItem2 = new ProjectItem("ccc","ccc",5);
        listDataHeader.add(projectItem);
        listDataHeader.add(projectItem1);
        listDataHeader.add(projectItem2);


        // Adding child data
        List<String> project1 = new ArrayList<String>();
        project1.add("Task 1 1");
        project1.add("Task 1 2");
        project1.add("Task 1 3");
        project1.add("Task 1 4");
        project1.add("Task 1 5");
        project1.add("Task 1 6");

        List<String> project2 = new ArrayList<String>();
        project2.add("Task 2 1");
        project2.add("Task 2 2");


        List<String> project3 = new ArrayList<String>();
        project3.add("Task 3 1");
        project3.add("Task 3 2");
        project3.add("Task 3 3");

        // Adding child data
        listDataChild.add(project1);
        listDataChild.add(project2);
        listDataChild.add(project3);

        System.out.println("TEST: " + listDataChild.size());

//        listDataChild.put(listDataHeader.get(0).getProjectName(), project1); // Header, Child data
//        listDataChild.put(listDataHeader.get(1).getProjectName(), project2);
//        listDataChild.put(listDataHeader.get(2).getProjectName(), project3);
    }


    //////////////////////////////////////////////
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        //getMenuInflater().inflate(R.menu.toolbar_menu,menu);
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
        super.onCreateOptionsMenu(menu, inflater);
    }
}
