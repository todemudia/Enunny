package com.example.triumph.enunny.di.components;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.triumph.enunny.MvpApp;
import com.example.triumph.enunny.data.DataManager;
import com.example.triumph.enunny.data.db.DatabaseHelper;
import com.example.triumph.enunny.di.ApplicationContext;
import com.example.triumph.enunny.di.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MvpApp mMvpApp);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

}
