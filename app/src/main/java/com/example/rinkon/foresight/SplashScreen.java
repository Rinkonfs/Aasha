package com.example.rinkon.foresight;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    ImageView ssIvIcsplash;
    TextView ssTvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ssIvIcsplash=findViewById(R.id.ssIvIcsplash);
        ssTvName=findViewById(R.id.ssTvName);

        ssIvIcsplash.animate().setStartDelay(1000).rotationBy(360).setDuration(1000);
        ssTvName.animate().setStartDelay(2000).alpha(1);
        int secondsDelayed = 3;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(SplashScreen.this, Homepage.class));
                finish();
            }
        }, secondsDelayed * 1000);


    }
}
