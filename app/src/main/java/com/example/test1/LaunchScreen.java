package com.example.test1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class LaunchScreen extends AppCompatActivity {

    private final int LANCHSCREEN_DISPLAY_LENGTH = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences prefs = getSharedPreferences("com.mycompany.myAppName", MODE_PRIVATE);
        setContentView(R.layout.launch_screen);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (prefs.getBoolean("firstrun", true)) {
                    Intent mainIntent = new Intent(LaunchScreen.this, SignUp.class);
                    LaunchScreen.this.startActivity(mainIntent);
                    LaunchScreen.this.finish();
                }
                prefs.edit().putBoolean("firstrun", false).commit();{
                    Intent mainIntent = new Intent(LaunchScreen.this, SignIn.class);
                    LaunchScreen.this.startActivity(mainIntent);
                    LaunchScreen.this.finish();
                }
            }
        }, LANCHSCREEN_DISPLAY_LENGTH);
    }
}