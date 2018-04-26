package com.example.triumph.enunny.ui.menu;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.triumph.enunny.data.AppDataManager;
import com.example.triumph.enunny.data.DataManager;
import com.example.triumph.enunny.ui.base.BasePresenter;
import com.example.triumph.enunny.util.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class MainMenuPresenter<V extends MainMenuMvpView> extends BasePresenter<V> implements MainMenuMvpPresenter<V> {

    @Inject
    public MainMenuPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);    }


    @Override
    public void onAttach(@NonNull V mvpView) {
        super.onAttach(mvpView);
        getCompositeDisposable().add(getDataManager()
                .seedDatabaseAnimals()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .concatMap(new Function<Boolean, ObservableSource<Boolean>>() {
                    @Override
                    public ObservableSource<Boolean> apply(Boolean aBoolean) throws Exception {
                        return getDataManager().seedDatabaseAnimals();
                    }
                })
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (!isAttached()) {
                            Log.v("MainMenu","View isnt attached");
                            return;
                        }
                    }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            if (!isAttached()) {
                                Log.v("MainMenu","View isnt attached");

                                return;
                            }
                    }
                }));

    }
}