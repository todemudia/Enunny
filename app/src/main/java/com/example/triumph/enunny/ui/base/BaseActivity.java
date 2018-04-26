package com.example.triumph.enunny.ui.base;

/**
 * Created by triumph on 25/03/2018.
 */
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.triumph.enunny.MvpApp;
import com.example.triumph.enunny.di.components.ActivityComponent;
import com.example.triumph.enunny.di.components.DaggerActivityComponent;
import com.example.triumph.enunny.di.modules.ActivityModule;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    private ActivityComponent mActivityComponent;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((MvpApp) getApplication()).getApplicationComponent())
                .build();

    }


    //Used to supply dependencies for View and Presenter
    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }



}