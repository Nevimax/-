package com.nevimax.nmynotes.BD;

import android.app.Application;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Employee.class}, version = 2)

public abstract class AppDatabase extends RoomDatabase {

    public abstract EmployeeDao employeeDao();

    public static class App extends Application {
        private static final String DATABASE_NAME = "NotesDatabase.db";
        private static AppDatabase instance;

        public static AppDatabase getInstance(Context context){
            if(instance == null)
                instance = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                        .fallbackToDestructiveMigration() // чистка базы на обновляшку базы
                        .allowMainThreadQueries()//разрешаем делать запросы к бд
                        .build();
            return instance;

        }


    //    public static App instance;
    //
    //    private AppDatabase database;
    //
    //    @Override
    //    public void onCreate() {
    //        super.onCreate();
    //        instance = this;
    //        database = Room.databaseBuilder(this, AppDatabase.class, "database")
    //                .allowMainThreadQueries() //разрешаем делать запросы к бд
    //                .build();
    //    }
    //
    //    public static App getInstance() {
    //        return instance;
    //    }
    //
    //    public AppDatabase getDatabase() {
    //        return database;
    //    }
    }
}
