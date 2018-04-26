package com.example.triumph.enunny.data.db;

import com.example.triumph.enunny.data.db.model.Animal;

import java.util.List;

import io.reactivex.Observable;

public interface DatabaseHelper {

        //Observable<Long> insertAnimal(final Animal animal);

        Observable<List<Animal>> getAllAnimals();

        Observable<Boolean> isAnimalEmpty();

        Observable<Boolean> saveAnimal(Animal animal);

        Observable<Boolean> saveAnimalList(List<Animal> AnimalList);

}
