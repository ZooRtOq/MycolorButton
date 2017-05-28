package com.jobfile.pc_n.mycolorbatton;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ilya on 28/5/17.
 */

public class NetworkUtils {

    public static String run(String url) throws IOException {
        Request request = new Request.Builder()
            .url(url)
            .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}