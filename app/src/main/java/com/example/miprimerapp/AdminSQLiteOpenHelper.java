package com.example.miprimerapp;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {
        BaseDeDatos.execSQL("create table usuarios(codigo int primary key, nombre text, apaterno text, amaterno text, celular int, correo text, usuario text, contra int, dni int, fecha text)");
        BaseDeDatos.execSQL("create table reporte(codigo int primary key, nombre text, usuario text, fecha text, hora text, frecuencia text, estado text)");
        BaseDeDatos.execSQL("create table contacto(codigo int primary key, nombre text, usuario text, celular int)");




    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
