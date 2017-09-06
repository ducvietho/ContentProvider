package com.example.ducviet.democontent.manager;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.ducviet.democontent.database.DatabaseHelper;
import com.example.ducviet.democontent.database.StudentContract;

/**
 * Created by ducviet on 06/09/2017.
 */

public class StudentProvider extends ContentProvider{
    public static final String AUTHORITY = "ducviet.ContentProvider";
    public static final String SCHEME = "content://";
    public static final String URL_DATA = SCHEME + AUTHORITY + "/student";
    public static final Uri CONTENT_URI = Uri.parse(URL_DATA);
    private static final  int URI_STUDENT = 0;
    private static UriMatcher uriMatcher;
    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY,"student",URI_STUDENT);
    }
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase sqLiteDatabase;
    @Override
    public boolean onCreate() {
        databaseHelper = new DatabaseHelper(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        sqLiteDatabase = databaseHelper.getWritableDatabase();
        switch (uriMatcher.match(uri)){
            case URI_STUDENT :
                return sqLiteDatabase.query(StudentContract.StudentEntry.TABLE_NAME,
                        strings,s,strings1,s1,null,null);
            case UriMatcher.NO_MATCH :
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);

        }
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        long index ;
        sqLiteDatabase = databaseHelper.getWritableDatabase();
        switch (uriMatcher.match(uri)){
            case URI_STUDENT:
                Uri _uri = null;
                index = sqLiteDatabase.insert(StudentContract.StudentEntry.TABLE_NAME,null,contentValues);
                if(index > 0){
                    _uri = ContentUris.withAppendedId(CONTENT_URI,index);
                }
                return _uri;
            case UriMatcher.NO_MATCH :
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        sqLiteDatabase = databaseHelper.getWritableDatabase();
        switch (uriMatcher.match(uri)){
            case URI_STUDENT:
                return sqLiteDatabase.delete(StudentContract.StudentEntry.TABLE_NAME,s,strings);
            case UriMatcher.NO_MATCH :
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        switch (uriMatcher.match(uri)){
            case URI_STUDENT:
                return sqLiteDatabase.update(StudentContract.StudentEntry.TABLE_NAME,contentValues,
                        s,strings);
            case UriMatcher.NO_MATCH :
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
    }
}

