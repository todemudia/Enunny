package com.example.triumph.enunny.ui.base;

import com.example.triumph.enunny.data.DataManager;

public class BasePresenter<V extends BaseView> implements BaseMvpPresenter<V> {

    private V mMvpView;

    DataManager mDataManager;


    public BasePresenter(DataManager dataManager){
        mDataManager = dataManager;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        //Todo 1 build onDetach
    }

    @Override
    public boolean isAttached() {
        //Todo 2 build isAttached
        return false;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public DataManager getDataManager() {
        return mDataManager;
    }
}