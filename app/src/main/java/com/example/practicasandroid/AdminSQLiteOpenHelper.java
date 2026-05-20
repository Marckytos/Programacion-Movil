package com.example.practicasandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(Context contexto,
                                 String nombre,
                                 SQLiteDatabase.CursorFactory factory,
                                 int version) {

        super(contexto,nombre,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "create table articulos(" +
                        "codigo int primary key," +
                        "descripcion text," +
                        "precio real)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}