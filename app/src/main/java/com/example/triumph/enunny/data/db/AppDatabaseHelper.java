package com.example.triumph.enunny.data.db;


import com.example.triumph.enunny.data.db.model.Animal;
import com.example.triumph.enunny.data.db.model.DaoMaster;
import com.example.triumph.enunny.data.db.model.DaoSession;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class AppDatabaseHelper implements DatabaseHelper {
     private final DaoSession mDaoSession;

        @Inject
        public AppDatabaseHelper(DatabaseOpenHelper dbOpenHelper) {
            mDaoSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
        }


        //Edit and use for custom images
//    @Override
//    public Observable<Long> insertAnimal(final Animal animal) {
//        return Observable.fromCallable(new Callable<Long>() {
//            @Override
//            public Long call() throws Exception {
//                return mDaoSession.getAnimalDao().insert(animal);
//            }
//        });
//    }

    @Override
    public Observable<List<Animal>> getAllAnimals() {
        return Observable.fromCallable(new Callable<List<Animal>>() {
            @Override
            public List<Animal> call() throws Exception {
                return mDaoSession.getAnimalDao().loadAll();
            }
        });
    }

    @Override
    public Observable<Boolean> isAnimalEmpty() {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return !(mDaoSession.getAnimalDao().count() > 0);
            }
        });
    }

    @Override
    public Observable<Boolean> saveAnimalList(final List<Animal> animalList) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getAnimalDao().insertInTx(animalList);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> saveAnimal(final Animal animal) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getAnimalDao().insert(animal);
                return true;
            }
        });
    }

}
