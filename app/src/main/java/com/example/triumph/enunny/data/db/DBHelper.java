//package com.example.triumph.enunny.data.db;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.content.res.Resources;
//import android.database.Cursor;
//import android.database.SQLException;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import com.example.triumph.enunny.data.db.model.Animal;
//import com.example.triumph.enunny.di.ApplicationContext;
//import com.example.triumph.enunny.di.DatabaseInfo;
//
//import javax.inject.Inject;
//import javax.inject.Singleton;
//
//public class DBHelper {
//    @Singleton
//    public class DbHelper extends SQLiteOpenHelper {
//
//        //USER TABLE
//        public static final String USER_TABLE_NAME = "users";
//        public static final String USER_COLUMN_USER_ID = "id";
//        public static final String USER_COLUMN_USER_NAME = "usr_name";
//        public static final String USER_COLUMN_USER_ADDRESS = "usr_add";
//        public static final String USER_COLUMN_USER_CREATED_AT = "created_at";
//        public static final String USER_COLUMN_USER_UPDATED_AT = "updated_at";
//
//        @Inject
//        public DbHelper(@ApplicationContext Context context,
//                        @DatabaseInfo String dbName,
//                        @DatabaseInfo Integer version) {
//            super(context, dbName, null, version);
//        }
//
//        @Override
//        public void onCreate(SQLiteDatabase db) {
//            tableCreateStatements(db);
//        }
//
//        @Override
//        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//            db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE_NAME);
//            onCreate(db);
//        }
//
//        private void tableCreateStatements(SQLiteDatabase db) {
//            try {
//                db.execSQL(
//                        "CREATE TABLE IF NOT EXISTS "
//                                + USER_TABLE_NAME + "("
//                                + USER_COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
//                                + USER_COLUMN_USER_NAME + " VARCHAR(20), "
//                                + USER_COLUMN_USER_ADDRESS + " VARCHAR(50), "
//                                + USER_COLUMN_USER_CREATED_AT + " VARCHAR(10) DEFAULT " + getCurrentTimeStamp() + ", "
//                                + USER_COLUMN_USER_UPDATED_AT + " VARCHAR(10) DEFAULT " + getCurrentTimeStamp() + ")"
//                );
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        protected Animal getAnimal(Long userId) throws Resources.NotFoundException, NullPointerException {
//            Cursor cursor = null;
//            try {
//                SQLiteDatabase db = this.getReadableDatabase();
//                cursor = db.rawQuery(
//                        "SELECT * FROM "
//                                + USER_TABLE_NAME
//                                + " WHERE "
//                                + USER_COLUMN_USER_ID
//                                + " = ? ",
//                        new String[]{userId + ""});
//
//                if (cursor.getCount() > 0) {
//                    cursor.moveToFirst();
//                    Animal animal = new Animal();
//                    animal.setId(cursor.getLong(cursor.getColumnIndex(USER_COLUMN_USER_ID)));
//                    animal.setName(cursor.getString(cursor.getColumnIndex(USER_COLUMN_USER_NAME)));
//                    animal.setCreatedAt(cursor.getString(cursor.getColumnIndex(USER_COLUMN_USER_CREATED_AT)));
//                    animal.setUpdatedAt(cursor.getString(cursor.getColumnIndex(USER_COLUMN_USER_UPDATED_AT)));
//                    return animal;
//                } else {
//                    throw new Resources.NotFoundException("Ani with id " + userId + " does not exists");
//                }
//            } catch (NullPointerException e) {
//                e.printStackTrace();
//                throw e;
//            } finally {
//                if (cursor != null)
//                    cursor.close();
//            }
//        }
//
//        protected Long insertAnimal(Animal animal) throws Exception {
//            try {
//                SQLiteDatabase db = this.getWritableDatabase();
//                ContentValues contentValues = new ContentValues();
//                contentValues.put(Animal_COLUMN_Animal_NAME, animal.getName());
//                return db.insert(Animal_TABLE_NAME, null, contentValues);
//            } catch (Exception e) {
//                e.printStackTrace();
//                throw e;
//            }
//        }
//
//        private String getCurrentTimeStamp() {
//            return String.valueOf(System.currentTimeMillis() / 1000);
//        }
//    }
//}
