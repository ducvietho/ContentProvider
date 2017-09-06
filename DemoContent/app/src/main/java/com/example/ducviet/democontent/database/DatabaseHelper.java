package com.example.ducviet.democontent.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ducviet.democontent.model.Student;

/**
 * Created by ducviet on 06/09/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Student.db";
    private static final  String SQL_CREATE_STUDENTS = " CREATE TABLE "
            +StudentContract.StudentEntry.TABLE_NAME
            +"("
            +StudentContract.StudentEntry._ID
            +" INTEGER PRIMARY KEY,"
            +StudentContract.StudentEntry.NAME_COLUMN
            +" TEXT,"
            +StudentContract.StudentEntry.PHONE_COLUMN
            +" TEXT,"
            + StudentContract.StudentEntry.INFOR_COLUMN
            +" TEXT"
            +")";
    private static final String SQL_DROP_STUDENTS =
            "DROP TABLE IF EXISTS " + StudentContract.StudentEntry.TABLE_NAME;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_STUDENTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DROP_STUDENTS);
        sqLiteDatabase.execSQL(SQL_CREATE_STUDENTS);
    }
}
