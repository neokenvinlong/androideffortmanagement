package com.example.effortmanagement.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.effortmanagement.fragment.EmployeeListFragment;
import com.example.effortmanagement.fragment.ProjectListFragment;
import com.example.effortmanagement.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bot);

        //control the item of the BottomNavigationView
        setUpNavigation();
    }

//    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
//            new BottomNavigationView.OnNavigationItemSelectedListener() {
//                @Override
//                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                    Fragment selectedFragment = null;
//
//                    switch (menuItem.getItemId()) {
//                        case R.id.nav_emp:
//                            selectedFragment = new EmployeeListFragment();
//                            break;
//                        case R.id.nav_project:
//                            selectedFragment = new ProjectListFragment();
//                            break;
//                    }
//                    getSupportFragmentManager().beginTransaction().replace(R.id.project_list_fragment, selectedFragment).commit();
//                    return true;
//                }
//            };

    public void setUpNavigation() {
        bottomNavigationView = findViewById(R.id.nav_bot);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navHostFragment.getNavController());
    }
}
