package com.example.triumph.enunny.ui.play;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.triumph.enunny.R;
import com.example.triumph.enunny.data.db.model.Animal;
import com.example.triumph.enunny.ui.base.BaseActivity;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

public class PlayView extends BaseActivity implements PlayMvpView {
    @Inject
    PlayMvpPresenter<PlayMvpView> mPresenter;

    TextView animalNameTextView;
    TextView makesSoundTextView;
    ImageView animalImage;
    ImageView mBackgroundImageView;
    int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);
        animalNameTextView = findViewById(R.id.card_name_text_view);
        animalImage = findViewById(R.id.card_image_view);
        makesSoundTextView = findViewById(R.id.makes_sound_textView_1);
        mBackgroundImageView = findViewById(R.id.backgroud_image_id);

        getActivityComponent().inject(this);
        mPresenter.onAttach(PlayView.this);
        updateView();
    }

    @Override
    public void loadAnimalList(List<Animal> animalList) {

    }

    public void changeText(String name){
        animalNameTextView.setText(name);
    }

    public void changeSoundText(String name){
        makesSoundTextView.setText(name);
    }

    @Override
    public void changeImage(String url) {
        Glide.with(this)
                .load(url)
                .into(animalImage);
    }

    public void updateView(){
        mBackgroundImageView.setOnClickListener(new View.OnClickListener(){
            // The code in this method will be executed when the next button is clicked on.
            @Override
            public void onClick(View view) {
                count++;
                if (count < 0 || count > 12) {count = 0;}

                    mPresenter.onViewInitialized(count);
            }
            });

        }
    public void playSound(String url) {
        animalImage = findViewById(R.id.card_image_view);

        final MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepareAsync();
        } catch (IOException e) {
            Toast.makeText(this, "mp3 not found", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

        // Set a click listener on that View
        animalImage.setOnClickListener(new View.OnClickListener(){
            // The code in this method will be executed when the next button is clicked on.
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });
    }
}
