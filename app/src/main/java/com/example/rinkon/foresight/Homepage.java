package com.example.rinkon.foresight;


import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class Homepage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private FloatingActionButton fabcreate;
    private FloatingActionButton fabadd;
    private FloatingActionButton fabtorch;
    private FloatingActionButton fabcompass;
    DrawerLayout drawer;
    private Camera camera;
    boolean deviceHasFlash;
    private Camera.Parameters parameter;
    private boolean isFlashLightOn = false;
    private boolean click=false;
    TextView abTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MessageFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_earthquakes);
        }
        fabcreate =findViewById(R.id.fabcreate);
        fabadd =findViewById(R.id.fabadd);
        fabtorch =findViewById(R.id.fabtorch);
//        abTitle =findViewById(R.id.abTitle);
        fabcompass =findViewById(R.id.fabcompass);
        fabtorch.setBackgroundTintList(fabtorch.getResources().getColorStateList(R.color.red));
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MessageFragment()).commit();
        /*deviceHasFlash=getApplication().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);*/
        /*if(!deviceHasFlash){
            Log.w("1","no camera");
            Toast.makeText(Homepage.this, "Sorry, you device does not have any camera", Toast.LENGTH_LONG).show();
            return;
        }
        else{
            this.camera = Camera.open();
            parameter = this.camera.getParameters();
        }*/

/*-------------------Floating button START---------------------------------------------------------*/
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
            /*Torch Button start*/
        fabtorch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if(!isFlashLightOn){
                    turnOnTheFlash();
                }else{
                    turnOffTheFlash();
                }*/
            }
        });
/* -----------------------Floating button END-------------------------------------------*/


        /*ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
*/
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MessageFragment()).commit();

    }
    /*private void turnOffTheFlash() {
        parameter.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        this.camera.setParameters(parameter);
        *//*this.camera.stopPreview();*//*
        isFlashLightOn = false;
        fabtorch.setBackgroundTintList(fabtorch.getResources().getColorStateList(R.color.green));
    }

    private void turnOnTheFlash() {
        if(this.camera != null){
            parameter = this.camera.getParameters();
            parameter.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            this.camera.setParameters(parameter);
            *//*this.camera.startPreview();*//*
            isFlashLightOn = true;
            fabtorch.setBackgroundTintList(fabtorch.getResources().getColorStateList(R.color.red));
        }
    }*/
    /*private void getCamera() {
        if (camera == null) {
            try {
                camera = Camera.open();
                parameter = camera.getParameters();
            } catch (RuntimeException e) {
                System.out.println("Error: Failed to Open: " + e.getMessage());
            }
        }
    }*/

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_earthquakes) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MessageFragment()).commit();
        } else if (id == R.id.nav_floods) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new TornadoFragment()).commit();
        } else if (id == R.id.nav_wildfires) {

        } else if (id == R.id.nav_hurricanes) {

        } else if (id == R.id.nav_compass) {

        } else if (id == R.id.nav_torch) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        /*DrawerLayout drawer =findViewById(R.id.drawer_layout);*/
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    navigationView.*/

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.homepage, menu);
        return true;
    }*/

    /*@Override
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
    }*/

    /*@Override
    protected void onStop() {
        super.onStop();
//        this.camera.release();
        *//*if(this.camera != null){
            this.camera.release();
            this.camera = null;
        }*//*
    }
    @Override
    protected void onPause() {
        super.onPause();
        *//*turnOffTheFlash();*//*
    }
    @Override
    protected void onResume() {
        super.onResume();
        *//*if(deviceHasFlash){
            turnOffTheFlash();
        }*//*
    }

    @Override
    protected void onStart() {
        super.onStart();
        *//*getCamera();*//*
    }*/
}

