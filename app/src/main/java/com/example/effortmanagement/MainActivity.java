package com.example.effortmanagement;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    RecyclerView projectRecyclerView;
    ProjectAdapter projectAdapter;
    List<ProjectItem> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tool bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //ini view
        projectRecyclerView = findViewById(R.id.recycler_view);
        mData = new ArrayList<>();

        mData.add(new ProjectItem("Project A","Not Started",12));
        mData.add(new ProjectItem("Project B","On process",5));
        mData.add(new ProjectItem("Project C","Not Started",6));
        mData.add(new ProjectItem("Project D","Banning",5));
        mData.add(new ProjectItem("Project E","On process",5));
        mData.add(new ProjectItem("Project F","Not Started",40));
        mData.add(new ProjectItem("Project G","Not Started",5));
        mData.add(new ProjectItem("Project H","Not Started",5));
        mData.add(new ProjectItem("Project Ithanh","Not Started",5));

        //adapter ini and setup

        projectAdapter = new ProjectAdapter(this, mData);
        projectRecyclerView.setAdapter(projectAdapter);
        projectRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu,menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        //android.widget.SearchView searchView = (android.widget.SearchView) menuItem.getActionView();
        //SearchView searchView = (SearchView) menuItem.getActionView();
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        String userInput = newText.toLowerCase();
        List<ProjectItem> projectItemList = new ArrayList<>();
        for(ProjectItem projectItem : mData){
            if(projectItem.getProjectName().toLowerCase().contains(userInput)){
                projectItemList.add(projectItem);
            }else if(projectItem.getProjectStatus().toLowerCase().contains(userInput)){
                projectItemList.add(projectItem);
            }
        }
        projectAdapter.updateList(projectItemList);
        return true;
    }
}
