package com.example.triumph.enunny.ui.play;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.triumph.enunny.data.AppDataManager;
import com.example.triumph.enunny.data.DataManager;
import com.example.triumph.enunny.data.db.model.Animal;
import com.example.triumph.enunny.ui.base.BasePresenter;
import com.example.triumph.enunny.util.rx.SchedulerProvider;

import org.reactivestreams.Subscriber;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class PlayPresenter <V extends PlayMvpView> extends BasePresenter<V> implements PlayMvpPresenter<V> {

    @Inject
    public PlayPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
        }

        private List <Animal> mAnimalList;

    @Override
    public void onViewInitialized(int x) {
            getMvpView().changeText(mAnimalList.get(x).getName());
            getMvpView().changeImage(mAnimalList.get(x).getImgUrl());
            getMvpView().playSound(mAnimalList.get(x).getSoundUrl());
            getMvpView().changeSoundText(mAnimalList.get(x).getMakesSound());
    }

    @Override
    public void onAttach(@NonNull V mvpView) {
        super.onAttach(mvpView);

        getCompositeDisposable().add(getDataManager()
                .getAllAnimals()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<List<Animal>>() {
                    @Override
                    public void accept(List<Animal> animalList) throws Exception {
                        if(animalList.isEmpty()){
                            getMvpView().changeText("Error");
                        }
                        else {
                            mAnimalList = animalList;
                            onViewInitialized(0);
                        }
                    }
                }));

    }
}