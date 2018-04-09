package com.example.triumph.enunny.ui.play;

import com.example.triumph.enunny.data.DataManager;
import com.example.triumph.enunny.ui.base.BasePresenter;

public class PlayPresenter <V extends PlayMvpView> extends BasePresenter<V> implements PlayMvpPresenter<V> {

    public PlayPresenter(DataManager dataManager) {
        super(dataManager);
    }


}