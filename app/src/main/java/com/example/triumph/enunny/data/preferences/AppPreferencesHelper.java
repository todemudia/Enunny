package com.example.triumph.enunny.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

import static android.content.Context.MODE_PRIVATE;

@Singleton
public class AppPreferencesHelper {


    private SharedPreferences mSharedPreferences;

    @Inject
    public AppPreferencesHelper(SharedPreferences sharedPreferences) {
        mSharedPreferences = sharedPreferences;
    }


}

