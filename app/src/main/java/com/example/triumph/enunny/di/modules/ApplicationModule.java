package com.example.triumph.enunny.di.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.triumph.enunny.data.AppDataManager;
import com.example.triumph.enunny.data.DataManager;
import com.example.triumph.enunny.data.db.AppDatabaseHelper;
import com.example.triumph.enunny.data.db.DatabaseHelper;
import com.example.triumph.enunny.di.ApplicationContext;
import com.example.triumph.enunny.di.DatabaseInfo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application app) {
        mApplication = app;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return "enunny.db";
    }

    @Provides
    @DatabaseInfo
    Integer provideDatabaseVersion() {
        return 2;
    }

    @Provides
    SharedPreferences provideSharedPrefs() {
        return mApplication.getSharedPreferences("enunny_preferences", Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    DatabaseHelper provideDbHelper(AppDatabaseHelper appDatabaseHelper) {
        return appDatabaseHelper;
    }

}
