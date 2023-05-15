package com.example.lab8_9;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    private Context context;
    public static final String DATABASE_NAME = "Friends.db";
    public static final Integer DATABASE_VERSION = 1;

    public Database(@Nullable Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String friends = "create table friends (ID integer not null primary key autoincrement, Nume text not null, Telefon text not null)";
        sqLiteDatabase.execSQL(friends);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table friends");
        onCreate(sqLiteDatabase);
    }

    public void add(String nume, String telefon){
        if (nume.isEmpty() || telefon.isEmpty())
            Toast.makeText(context, "Completeaza datele Prietenului!", Toast.LENGTH_SHORT).show();
        else{
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("Nume", nume);
            contentValues.put("Telefon", telefon);
            long result = db.insert("friends", null, contentValues);
            if (result == -1)
                Toast.makeText(context, "Nu s-a putut insera Prietenul!", Toast.LENGTH_SHORT).show();
            else Toast.makeText(context, "Prieten adaugat cu success!", Toast.LENGTH_SHORT).show();
        }
    }

    public Cursor read(){
        String querry = "select * from friends";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null)
            cursor = db.rawQuery(querry, null);
        return cursor;
    }

    public void deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete("friends",null, null);
        if (result == -1)
            Toast.makeText(context, "Nu s-au putut sterge Prietenii!", Toast.LENGTH_SHORT).show();
        else Toast.makeText(context, "Prietenii au fost stersi cu success!", Toast.LENGTH_SHORT).show();
    }
}
