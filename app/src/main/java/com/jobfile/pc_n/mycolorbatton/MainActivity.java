package com.jobfile.pc_n.mycolorbatton;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private boolean buttonIsPurple = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void str(View v) {
        if (buttonIsPurple) {
            v.setBackgroundResource(R.color.colorAccent);
            buttonIsPurple = false;
        } else {
            v.setBackgroundResource(R.color.colorPrimaryDark);
            buttonIsPurple = true;
        }
    }

    public void next(View v) {
        Intent intent = new Intent(this, RunMain.class);
        startActivity(intent);
    }

    public void showWeather(View view) {
        Intent intent = new Intent(this, WeatherActivity.class);
        startActivity(intent);
    }
}