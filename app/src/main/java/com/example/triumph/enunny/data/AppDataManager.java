package com.example.triumph.enunny.data;

import android.content.Context;
import android.util.Log;

import com.example.triumph.enunny.data.db.DatabaseHelper;
import com.example.triumph.enunny.data.db.model.Animal;
import com.example.triumph.enunny.data.preferences.AppPreferencesHelper;
import com.example.triumph.enunny.di.ApplicationContext;
import com.example.triumph.enunny.util.GeneralUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.$Gson$Types;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

@Singleton
public class AppDataManager implements DataManager {

    private Context mContext;
    private DatabaseHelper mDatabaseHelper;
    private AppPreferencesHelper mPreferencesHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context, DatabaseHelper databaseHelper, AppPreferencesHelper appPreferencesHelper) {
        mContext = context;
        mDatabaseHelper = databaseHelper;
        mPreferencesHelper = appPreferencesHelper;
    }

    @Override
    public Observable<Boolean> isAnimalEmpty() {
        return mDatabaseHelper.isAnimalEmpty();
    }

    @Override
    public Observable<Boolean> saveAnimal(Animal animal) {
        return mDatabaseHelper.saveAnimal(animal);

    }

    @Override
    public Observable<List<Animal>> getAllAnimals() {
        return mDatabaseHelper.getAllAnimals();    }

    public Observable<Boolean> saveAnimalList(List<Animal> animalList) {
        return mDatabaseHelper.saveAnimalList(animalList);
    }
    @Override
    public Observable<Boolean> seedDatabaseAnimals() {

        GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();

        return mDatabaseHelper.isAnimalEmpty()
                .concatMap(new Function<Boolean, ObservableSource<? extends Boolean>>() {
                    @Override
                    public ObservableSource<? extends Boolean> apply(Boolean isEmpty)
                            throws Exception {
                        if (isEmpty) {
                            Type type = $Gson$Types
                                    .newParameterizedTypeWithOwner(null, List.class,
                                            Animal.class);
                            List<Animal> animalList = gson.fromJson(
                                    GeneralUtils.loadJSON(mContext,"animals.json"),
                                    type);

                            return saveAnimalList(animalList);

                        }
                        return Observable.just(false);

                    }
                });
    }

}