package com.example.rohitmapakshi.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.MenuInflater;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.rohitmapakshi.myapplication.Utils.tab;
import com.example.rohitmapakshi.myapplication.rightnav.events;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FragmentManager mFragmentManager;
    Fragment fragment;
    ViewPager viewPager;
    TabHost tabhost;
    Toolbar toolbar;
    private boolean isStartup = true;




    //ParallaxImageView mBackground = (ParallaxImageView) findViewById(R.id.image);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_main, new main());
        transaction.addToBackStack(null);
        transaction.commit();

        init_navigation();


    }


    private void init_navigation() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.pec);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.pec);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        ActionBarDrawerToggle toggle1 = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        drawer.setDrawerListener(toggle1);
        toggle1.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        NavigationView navigationView2 = (NavigationView) findViewById(R.id.nav_view2);
        navigationView2.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.abouticon:
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_main, new main());
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case R.id.cam:
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.openDrawer(GravityCompat.END, true);
                break;

        }
        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.departments) {
            Toast.makeText(getApplicationContext(), "Departments", Toast.LENGTH_SHORT).show();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.content_main, new tab());
            transaction.addToBackStack(null);
            transaction.commit();
            item.setChecked(true);

        } else if (id == R.id.course) {
            Toast.makeText(getApplicationContext(), "Course", Toast.LENGTH_SHORT).show();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.content_main, new course());
            transaction.addToBackStack(null);
            transaction.commit();
            item.setChecked(true);
            Toast.makeText(getApplicationContext(), "Course", Toast.LENGTH_SHORT).show();

            //mBackground.registerSensorManager();

        } else if (id == R.id.admin) {
            Toast.makeText(getApplicationContext(), "admin", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.Placements) {
            Toast.makeText(getApplicationContext(), "Placements", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.events) {
            Toast.makeText(getApplicationContext(), "events", Toast.LENGTH_SHORT).show();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.content_main, new events());
            transaction.addToBackStack(null);
            transaction.commit();
            item.setChecked(true);


        } else if (id == R.id.clubs) {
            Toast.makeText(getApplicationContext(), "Clubs", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.facilities) {
            Toast.makeText(getApplicationContext(), "Facilities", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.vt) {
            Toast.makeText(getApplicationContext(), "virtual tour", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        drawer.closeDrawer(GravityCompat.END);

        return true;
    }
}

