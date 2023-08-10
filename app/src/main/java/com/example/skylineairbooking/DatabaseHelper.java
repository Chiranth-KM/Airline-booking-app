package com.example.skylineairbooking;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {


    public DatabaseHelper(@Nullable Context context) {
        super(context, "log.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDatabase) {
        MyDatabase.execSQL("create Table details(email TEXT primary key, password TEXT,name TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists details");
    }

    public Boolean insertData(String email, String password,String name) {
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("name",name);
        long result = MyDatabase.insert("details", null, contentValues);

        return result != -1;
    }

    public Boolean checkEmailPassword(String email, String password)
    {
        SQLiteDatabase MyDatabase=this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor= MyDatabase.rawQuery("select * from details where email=? and password=?", new String[]{email,password});

        return cursor.getCount() > 0;
    }
}
