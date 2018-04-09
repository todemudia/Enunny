package com.example.triumph.enunny.ui.play;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.triumph.enunny.R;
import com.example.triumph.enunny.ui.base.BaseActivity;

public class PlayView extends BaseActivity implements PlayMvpView {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);

    }
}
