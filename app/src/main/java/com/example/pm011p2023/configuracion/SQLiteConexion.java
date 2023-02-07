package com.example.pm011p2023.configuracion;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

import com.example.pm011p2023.transacciones.Transacciones;

public class SQLiteConexion extends SQLiteOpenHelper
{
    //Constructor de clase con parametros
    public SQLiteConexion(Context context, String dbname, SQLiteDatabase.CursorFactory factory, int version){
        super(context, dbname, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //lista de tablas a crear
        sqLiteDatabase.execSQL(Transacciones.CreateTBPersonas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(Transacciones.DropTablePersonas);
    }
}
