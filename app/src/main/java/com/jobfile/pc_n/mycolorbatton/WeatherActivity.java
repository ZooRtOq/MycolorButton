package com.jobfile.pc_n.mycolorbatton;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class WeatherActivity extends AppCompatActivity {

    public static final String RETRIEVE_WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?q=Moskov,Ru&APPID=92c07848422f27c0f91cabdae2f1db2f";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        new DownloadFilesTask().execute(RETRIEVE_WEATHER_URL);
    }

    private void showResult(String weather) {
        TextView uiText = (TextView) findViewById(R.id.temperature);
        TextView ut = (TextView) findViewById(R.id.description);
        ImageView uiIcon = (ImageView) findViewById(R.id.icon);
        try {
            JSONObject weatherJson = new JSONObject(weather);

            JSONObject main = weatherJson.getJSONObject("main");//массив main спарсили температуру погоды

            String temp = main.getString("temp");
            String icon = weatherJson.getJSONArray("weather").getJSONObject(0).getString("icon");
            String url = "http://openweathermap.org/img/w/" + icon + ".png";
            String mainWeather = weatherJson.getJSONArray("weather").getJSONObject(0).getString("main");
            uiText.setText(mainWeather);
            ut.setText(temp);//вывили на экран температуру погоды
            Glide.with(this).load(url).into(uiIcon);
        } catch (JSONException e) {
            Toast.makeText(this, "Ошибка при парсе json", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
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
