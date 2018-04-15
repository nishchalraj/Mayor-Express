package com.android.root.mayorexpress;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class navigation extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_navigation);

            Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //this will make services screen appear as user opens
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new services()).commit();
        navigationView.setCheckedItem(R.id.nav_services);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId())
        {
            case R.id.nav_services:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new services()).commit();
                break;
            case R.id.nav_calls:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new myCalls()).commit();
                break;
            case R.id.nav_lang:
                Toast.makeText(getApplicationContext(),"Language Changed",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_about:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new about()).commit();
                break;
            case R.id.nav_support:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new support()).commit();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
            super.onBackPressed();
    }
}
