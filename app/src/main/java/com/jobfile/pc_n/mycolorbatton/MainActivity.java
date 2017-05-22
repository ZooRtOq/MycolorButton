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
        if (buttonIsPurple == true) {

            v.setBackgroundResource(R.color.colorAccent);
            buttonIsPurple = false;
        } else {
            if (buttonIsPurple == false) {
                v.setBackgroundResource(R.color.colorPrimaryDark);
                buttonIsPurple=true;
            }
        }
    }
}