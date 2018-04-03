package com.example.triumph.enunny.ui.menu;

import com.example.triumph.enunny.data.DataManager;
import com.example.triumph.enunny.ui.base.BasePresenter;

public class MainMenuPresenter<V extends MainMenuMvpView> extends BasePresenter<V> implements MainMenuMvpPresenter<V> {

    public MainMenuPresenter(DataManager dataManager) {
        super(dataManager);
    }


}