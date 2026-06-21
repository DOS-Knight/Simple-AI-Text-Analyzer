package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, "analysis_db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE analysis (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "text TEXT," +
                "emotion TEXT," +
                "topic TEXT," +
                "keywords TEXT," +
                "summary TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS analysis");
        onCreate(db);
    }

    // ذخیره تحلیل
    public void insertAnalysis(String text, String emotion, String topic, String keywords, String summary) {

        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("INSERT INTO analysis(text, emotion, topic, keywords, summary) VALUES(?,?,?,?,?)",
                new Object[]{text, emotion, topic, keywords, summary});

        db.close();
    }

    // گرفتن کل تاریخچه
    public ArrayList<AnalysisModel> getAllAnalysis() {

        ArrayList<AnalysisModel> list = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM analysis ORDER BY id DESC", null);

        if (cursor.moveToFirst()) {
            do {

                String text = cursor.getString(1);
                String emotion = cursor.getString(2);
                String topic = cursor.getString(3);
                String keywords = cursor.getString(4);
                String summary = cursor.getString(5);

                list.add(new AnalysisModel(text, emotion, topic, keywords, summary));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return list;
    }
}