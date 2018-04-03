package com.example.triumph.enunny;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.triumph.enunny.data.DataManager;
import com.example.triumph.enunny.data.preferences.SharedPreferencesHelper;

public class MvpApp extends Application {

    DataManager dataManager;

    @Override
    public void onCreate() {
        super.onCreate();

        SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(getApplicationContext());
        dataManager = new DataManager(sharedPreferencesHelper);

    }

    public DataManager getDataManager() {
        return dataManager;
    }

}
