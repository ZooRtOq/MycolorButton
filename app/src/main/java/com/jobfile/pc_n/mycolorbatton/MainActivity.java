package com.jobfile.pc_n.mycolorbatton;


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
            v.setBackgroundResource(R.color.colorPrimaryDark);
        } else {
            v.setBackgroundResource(R.color.colorAccent);
            if (buttonIsPurple == false) {
                v.setBackgroundResource(R.color.colorPrimaryDark);
            }
        }
    }
}