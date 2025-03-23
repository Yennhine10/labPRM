package com.example.nhithuchanh;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.nhithuchanh.model.Book;

@Database(entities = { Book.class }, version = 3)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public abstract BookDAO bookDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "ce172006")
                    .fallbackToDestructiveMigration() // Xóa database cũ khi thay đổi schema
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}