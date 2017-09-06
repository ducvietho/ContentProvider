package com.example.ducviet.democontent.database;

import android.provider.BaseColumns;

/**
 * Created by ducviet on 06/09/2017.
 */

public class StudentContract {
    public StudentContract() {

    }

    public static class StudentEntry implements BaseColumns {
        public static final String TABLE_NAME = "student";
        public static final String NAME_COLUMN = "name";
        public static final String PHONE_COLUMN = "phone";
        public static final String INFOR_COLUMN = "infor";
    }
}
