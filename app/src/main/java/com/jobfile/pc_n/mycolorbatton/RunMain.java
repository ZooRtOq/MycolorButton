package com.jobfile.pc_n.mycolorbatton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class RunMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run_main);
    }

    public void back(View v) {
        finish();
    }
}