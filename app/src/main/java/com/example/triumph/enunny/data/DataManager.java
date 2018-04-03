package com.example.triumph.enunny.data;

import com.example.triumph.enunny.data.preferences.SharedPreferencesHelper;

public class DataManager {

    SharedPreferencesHelper mSharedPreferencesHelper;

    public DataManager(SharedPreferencesHelper sharedPreferencesHelper) {
        mSharedPreferencesHelper = sharedPreferencesHelper;
    }

    public void clear() {
        mSharedPreferencesHelper.clear();
    }

    public void saveEmailId(String email) {
        mSharedPreferencesHelper.putEmail(email);
    }

    public String getEmailId() {
        return mSharedPreferencesHelper.getEmail();
    }

    public void setLoggedIn() {
        mSharedPreferencesHelper.setLoggedInMode(true);
    }

    public Boolean getLoggedInMode() {
        return mSharedPreferencesHelper.getLoggedInMode();
    }
}