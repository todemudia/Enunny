package com.example.triumph.enunny;

import android.app.Application;
import android.content.Context;

import com.example.triumph.enunny.data.AppDataManager;
import com.example.triumph.enunny.data.DataManager;
import com.example.triumph.enunny.di.components.DaggerApplicationComponent;
import com.example.triumph.enunny.di.modules.ApplicationModule;
import com.example.triumph.enunny.di.components.ApplicationComponent;

import javax.inject.Inject;

public class MvpApp extends Application {
    protected ApplicationComponent applicationComponent;

    @Inject
    DataManager dataManager;

    public static MvpApp get(Context context) {
        return (MvpApp) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }
}


