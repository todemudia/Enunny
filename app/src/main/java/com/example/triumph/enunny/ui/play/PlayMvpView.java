package com.example.triumph.enunny.ui.play;

import android.media.MediaPlayer;

import com.example.triumph.enunny.data.db.model.Animal;
import com.example.triumph.enunny.ui.base.BaseView;

import java.util.ArrayList;
import java.util.List;

public interface PlayMvpView extends BaseView {

    void loadAnimalList(List<Animal> questionList);

    void changeText(String name);
    void changeImage(String url);
    void playSound(String url);
    void changeSoundText(String name);


}
