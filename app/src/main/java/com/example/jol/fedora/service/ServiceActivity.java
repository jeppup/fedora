package com.example.jol.fedora.service;

import android.icu.text.IDNA;
import android.support.v7.app.AppCompatActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by antonfluch on 2017-02-18.
 */

public class ServiceActivity<T> extends AppCompatActivity {
    public Class<T> mResponseClass;

    public ServiceActivity(Class<T> mClass){
        mResponseClass = mClass;
    }

    public void callback(T callbackObject){

    }

    public void deserializeAndCallback(String response){
        try{
            Gson gson = new GsonBuilder().create();
            T sup = gson.fromJson(response, mResponseClass);
            System.out.println("Här är sup " + sup.toString());
            callback(sup);
        }catch (Exception aliens){
            aliens.printStackTrace();
        }

    }
}
