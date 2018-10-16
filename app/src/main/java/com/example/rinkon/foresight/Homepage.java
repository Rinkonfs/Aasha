package com.example.rinkon.foresight;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class Homepage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FloatingActionButton fabcreate;
    FloatingActionButton fabadd;
    FloatingActionButton fabtorch;
    FloatingActionButton fabcompass;
    boolean click=false;
    boolean torchclick=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fabcreate =findViewById(R.id.fabcreate);
        fabadd =findViewById(R.id.fabadd);
        fabtorch =findViewById(R.id.fabtorch);
        fabcompass =findViewById(R.id.fabcompass);
        fabtorch.setBackgroundTintList(fabtorch.getResources().getColorStateList(R.color.red));


        fabadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!click){
                    fabadd.animate().rotation(135).setStartDelay(100);
                    fabcreate.animate().translationY(-200).setStartDelay(100);
                    fabtorch.animate().translationX(-200).setStartDelay(100);
                    fabcompass.animate().translationX(-400).setStartDelay(100);
                    click=true;
                }else
                {
                    fabadd.animate().rotation(0).setStartDelay(100);
                    fabcreate.animate().translationY(0).setStartDelay(100);
                    fabtorch.animate().translationX(0).setStartDelay(100);
                    fabcompass.animate().translationX(0).setStartDelay(100);
                    click=false;
                }

            }
        });

        fabtorch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!torchclick){
                    fabtorch.setBackgroundTintList(fabtorch.getResources().getColorStateList(R.color.green));
                    torchclick=true;
                }else
                {
                    fabtorch.setBackgroundTintList(fabtorch.getResources().getColorStateList(R.color.red));
                    torchclick=false;
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.homepage, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_earthquakes) {
            // Handle the camera action
        } else if (id == R.id.nav_floods) {

        } else if (id == R.id.nav_wildfires) {

        } else if (id == R.id.nav_hurricanes) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
