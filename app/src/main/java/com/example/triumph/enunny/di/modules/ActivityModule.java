package com.example.triumph.enunny.di.modules;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.example.triumph.enunny.di.ActivityContext;
import com.example.triumph.enunny.di.PerActivity;
import com.example.triumph.enunny.ui.menu.MainMenuMvpPresenter;
import com.example.triumph.enunny.ui.menu.MainMenuMvpView;
import com.example.triumph.enunny.ui.menu.MainMenuPresenter;
import com.example.triumph.enunny.ui.play.PlayMvpPresenter;
import com.example.triumph.enunny.ui.play.PlayMvpView;
import com.example.triumph.enunny.ui.play.PlayPresenter;
import com.example.triumph.enunny.util.rx.AppSchedulerProvider;
import com.example.triumph.enunny.util.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    @PerActivity
    PlayMvpPresenter<PlayMvpView> providePlayPresenter(
            PlayPresenter<PlayMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMenuMvpPresenter<MainMenuMvpView> provideMainMenuPresenter(
            MainMenuPresenter<MainMenuMvpView> presenter) {
        return presenter;
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }


    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }
}
