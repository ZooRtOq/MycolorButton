package com.jobfile.pc_n.mycolorbatton;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.IOException;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        new DownloadFilesTask().execute("https://example.com/");
    }

    private void showResult(String weather) {
        TextView uiText = (TextView) findViewById(R.id.weather_data);
        uiText.setText(weather);
    }

    private class DownloadFilesTask extends AsyncTask<String, Void, String> {

        @Override protected String doInBackground(String... params) {
            try {
                return NetworkUtils.run(params[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "error";
        }

        @Override protected void onPostExecute(String result) {
            showResult(result);
        }
    }
}
