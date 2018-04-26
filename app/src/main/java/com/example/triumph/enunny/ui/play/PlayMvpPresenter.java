package com.example.triumph.enunny.ui.play;

import com.example.triumph.enunny.data.db.model.Animal;
import com.example.triumph.enunny.ui.base.BaseMvpPresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public interface PlayMvpPresenter <V extends PlayMvpView> extends BaseMvpPresenter<V>{


    void onViewInitialized(int x);
}
