package com.example.triumph.enunny.data.db;

import android.content.Context;
import android.util.Log;

import com.example.triumph.enunny.data.db.model.DaoMaster;
import com.example.triumph.enunny.di.ApplicationContext;
import com.example.triumph.enunny.di.DatabaseInfo;

import org.greenrobot.greendao.database.Database;

import javax.inject.Inject;

public class DatabaseOpenHelper extends DaoMaster.OpenHelper {

    @Inject
    public DatabaseOpenHelper(@ApplicationContext Context context, @DatabaseInfo String name) {
        super(context, name);
    }
    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        Log.d("DEBUG", "DB_OLD_VERSION : " + oldVersion + ", DB_NEW_VERSION : " + newVersion);
        switch (oldVersion) {
            case 1:
            case 2:
        }
    }
}
