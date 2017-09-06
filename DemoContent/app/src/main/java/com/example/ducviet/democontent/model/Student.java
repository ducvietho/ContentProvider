package com.example.ducviet.democontent.model;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.ducviet.democontent.database.StudentContract;

/**
 * Created by ducviet on 06/09/2017.
 */

public class Student {
    private int id;
    private String name;
    private String phoneNumber;
    private String infor;

    public Student(int id, String name, String phoneNumber, String infor) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.infor = infor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInfor() {
        return infor;
    }

    public void setInfor(String infor) {
        this.infor = infor;
    }

    public Student(Cursor cursor) {
        id = cursor.getInt(cursor.getColumnIndex(StudentContract.StudentEntry._ID));
        name = cursor.getString(cursor.getColumnIndex(StudentContract.StudentEntry.NAME_COLUMN));
        phoneNumber = cursor.getString(cursor.getColumnIndex(StudentContract.StudentEntry.PHONE_COLUMN));
        infor = cursor.getString(cursor.getColumnIndex(StudentContract.StudentEntry.INFOR_COLUMN));

    }
    public ContentValues getContentValues(){
        ContentValues contentValues = new ContentValues();
        if (name!=null){
            contentValues.put(StudentContract.StudentEntry.NAME_COLUMN,name);
        }
        if (phoneNumber!=null){
            contentValues.put(StudentContract.StudentEntry.PHONE_COLUMN,phoneNumber);
        }
        if(infor!=null){
            contentValues.put(StudentContract.StudentEntry.INFOR_COLUMN,infor);
        }
        if (id!=0){
            contentValues.put(StudentContract.StudentEntry._ID,id);
        }
        return contentValues;
    }
}
