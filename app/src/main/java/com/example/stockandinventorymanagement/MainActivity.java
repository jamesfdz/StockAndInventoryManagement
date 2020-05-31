package com.example.stockandinventorymanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findView
        Toolbar toolbar = findViewById(R.id.toolbar);
        DrawerLayout drawer = findViewById(R.id.drawerLayout);
        NavigationView navView = findViewById(R.id.nav_view);

        setSupportActionBar(toolbar);

        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_home, R.id.nav_setting)
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this,R.id.nav_host_fragment);

        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        
        NavigationUI.setupWithNavController(navView, navController);

    }

    //this is for 3 dots on top
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.drawer_menu, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        NavController navController = Navigation.findNavController(this,R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration) || super.onSupportNavigateUp();
    }
}
