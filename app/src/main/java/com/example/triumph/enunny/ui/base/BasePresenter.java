package com.example.triumph.enunny.ui.base;

import android.support.annotation.NonNull;

import com.example.triumph.enunny.data.AppDataManager;
import com.example.triumph.enunny.data.DataManager;
import com.example.triumph.enunny.util.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class BasePresenter<V extends BaseView> implements BaseMvpPresenter<V> {

    private V mMvpView;

    private final DataManager mDataManager;
    private final SchedulerProvider mSchedulerProvider;
    private final CompositeDisposable mCompositeDisposable;





    @Inject
    public BasePresenter(DataManager dataManager, SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        this.mDataManager = dataManager;
        this.mSchedulerProvider = schedulerProvider;
        this.mCompositeDisposable = compositeDisposable;
    }

    @Override
    public void onAttach(@NonNull V mvpView) {
        mMvpView = mvpView;
    }


    @Override
    public void onDetach() {
        //Todo 1 build onDetach
    }

    @Override
    public boolean isAttached() {
        return mMvpView != null;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }


}