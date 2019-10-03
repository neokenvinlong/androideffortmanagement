package com.example.effortmanagement;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;


public class ProjectListFragment extends Fragment{

    RecyclerView projectRecyclerView;
    LinearLayout projectRecyclerViewLayout;
    ProjectAdapter projectAdapter;
    List<ProjectItem> mData;
    SearchView searchView;
    SearchView.OnQueryTextListener onQueryTextListener;

    public ProjectListFragment() {
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_project_list, container, false);

        //tool bar
//        Toolbar toolbar = getView().findViewById(R.id.toolbar);
//        AppCompatActivity activity = (AppCompatActivity) getActivity();
//        activity.setSupportActionBar(toolbar);
//        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
//        AppCompatActivity activity = (AppCompatActivity) getActivity();
//        activity.getSupportActionBar(toolbar);


        //ini view

        mData = new ArrayList<>();

        mData.add(new ProjectItem("Project A", "Not Started", 12));
        mData.add(new ProjectItem("Project B", "On process", 5));
        mData.add(new ProjectItem("Project C", "Not Started", 6));
        mData.add(new ProjectItem("Project D", "Banning", 5));
        mData.add(new ProjectItem("Project E", "On process", 5));
        mData.add(new ProjectItem("Project F", "Not Started", 40));
        mData.add(new ProjectItem("Project G", "Not Started", 5));
        mData.add(new ProjectItem("Project H", "Not Started", 5));
        mData.add(new ProjectItem("Project I", "Not Started", 5));

        //adapter ini and setup
        projectRecyclerView = view.findViewById(R.id.recycler_view);
        projectRecyclerViewLayout = view.findViewById(R.id.projectRecyclerViewLayout);
        //projectRecyclerView.setHasFixedSize(true);

        projectAdapter = new ProjectAdapter(getActivity(), mData);


        projectRecyclerView.setAdapter(projectAdapter);
        projectRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

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
