package com.example.triumph.enunny.ui.menu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.triumph.enunny.MvpApp;
import com.example.triumph.enunny.R;
import com.example.triumph.enunny.data.DataManager;
import com.example.triumph.enunny.ui.base.BaseActivity;
import com.example.triumph.enunny.ui.base.BaseView;
import com.example.triumph.enunny.ui.play.PlayView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainMenuView extends BaseActivity implements MainMenuMvpView{

    MainMenuPresenter mMainMenuPresenter;

    // Find the View that shows the next button Address Activity
    Button mPlayButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        DataManager dataManager = ((MvpApp) getApplication()).getDataManager();
        mMainMenuPresenter = new MainMenuPresenter(dataManager);
        mMainMenuPresenter.onAttach(this);

        openPlayMode();
    }



    @Override
    public void openPlayMode() {

    mPlayButton =  findViewById(R.id.play_button_main_menu);
        final Context context;
        context = this.getApplicationContext();

        // Set a click listener on that View
        mPlayButton.setOnClickListener(new View.OnClickListener(){
            // The code in this method will be executed when the next button is clicked on.
            @Override
            public void onClick(View view) {
                Intent confirmIntent = new Intent(context, PlayView.class);
                startActivity(confirmIntent);
            }
        });
    }


}
