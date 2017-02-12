package com.example.jol.fedora.service;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

import static java.lang.System.in;

/**
 * Created by Jesper on 2017-02-12.
 */

public class FedoraClient extends AsyncTask<String, Void, String> {
    private final String mBaseUrl = "https://fedoras.herokuapp.com/api/";
    private final Context mContext;

    public FedoraClient(Context context){
        mContext = context;
    }

    @Override
    protected String doInBackground(String... params) {
        String response = "";
        try {
            response = POST(params[0]);
        }catch (Exception ex){
            Log.d("LOGIN FAILED", ex.getMessage());
        }

        return response;
    }

    public String POST(String resource) throws Exception {
        URL url = new URL(mBaseUrl + resource);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        addHttpHeaders(connection);

        String body =  "{\"username\":\"jeppeFrånAndroidApp\",\"password\":\"minmor321\",\"passwordConfirmation\":\"minmor321\",\"errors\":{\"username\":\"\"\n" +
                "},\"isLoading\":false,\"invalid\":false}";

        byte[] outputInBytes = body.getBytes("UTF-8");
        OutputStream os = connection.getOutputStream();
        os.write( outputInBytes );
        os.flush();
        os.close();

        BufferedReader br;
        if (200 <= connection.getResponseCode() && connection.getResponseCode() <= 299) {
            br = new BufferedReader(new InputStreamReader((connection.getInputStream())));
        } else {
            br = new BufferedReader(new InputStreamReader((connection.getErrorStream())));
        }

        StringBuilder out = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            out.append(line);
        }



        int responseCode = connection.getResponseCode();

        //connection.setDoOutput(true);

        return out.toString();
    }

    private void addHttpHeaders(HttpsURLConnection connection){
        connection.setRequestProperty("Accept", "application/json, text/plain, */*");
        connection.setRequestProperty("Accept-Language", "sv-SE,sv;q=0.8,en-US;q=0.5,en;q=0.3");
        connection.setRequestProperty("Content-Type","application/json;charset=utf-8");
        connection.setRequestProperty("Host", "fedoras.herokuapp.com");
        connection.setRequestProperty("Connection", "keep-alive");
        connection.setRequestProperty("Referer", "https://fedoras.herokuapp.com/signup");
    }
}
