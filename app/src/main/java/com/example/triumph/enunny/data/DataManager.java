package com.example.triumph.enunny.data;

import com.example.triumph.enunny.data.db.DatabaseHelper;
import com.example.triumph.enunny.data.preferences.PreferenceHelper;

import io.reactivex.Observable;

public interface DataManager extends DatabaseHelper, PreferenceHelper {


    Observable<Boolean> seedDatabaseAnimals();


}
