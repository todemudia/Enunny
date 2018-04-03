package com.example.triumph.enunny.ui.menu;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.triumph.enunny.MvpApp;
import com.example.triumph.enunny.R;
import com.example.triumph.enunny.data.DataManager;
import com.example.triumph.enunny.ui.base.BaseActivity;
import com.example.triumph.enunny.ui.base.BaseView;

public class MainMenuView extends BaseActivity implements MainMenuMvpView{

    MainMenuPresenter mMainMenuPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        DataManager dataManager = ((MvpApp) getApplication()).getDataManager();
        mMainMenuPresenter = new MainMenuPresenter(dataManager);
        mMainMenuPresenter.onAttach(this);
    }



    @Override
    public void openPlayMode() {
        //Todo 3 add play mode intent
    }
}
