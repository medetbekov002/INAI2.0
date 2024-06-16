package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences userPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
        checkAuth();
    }

    private void checkAuth() {
        boolean isAuthenticated = userPreferences.getBoolean("isAuthenticated", false);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();
        NavGraph navGraph = navController.getNavInflater().inflate(R.navigation.nav_graph);
        navGraph.setStartDestination(isAuthenticated ? R.id.mainFragment : R.id.onBoardFragment);
        navController.setGraph(navGraph);
    }

}
