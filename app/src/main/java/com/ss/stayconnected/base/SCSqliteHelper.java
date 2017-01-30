package com.ss.stayconnected.base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ss.stayconnected.model.ProfileInfo;

/**
 * Created by sowmi on 07/01/17.
 */
public class SCSqliteHelper extends SQLiteOpenHelper {

    public static final String _ID = "_ID";
    private static final String SQL_CREATE_PROFILEINFO_ENTRIES =
            "CREATE TABLE " + ProfileInfo.TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY," +
                    ProfileInfo.COLUMN_NAME_NAME + " TEXT," +
                    ProfileInfo.COLUMN_NAME_LASTUPDATEDLOCATION + " TEXT," +
                    ProfileInfo.COLUMN_NAME_PROFILEPICURI + " TEXT," +
                    ProfileInfo.COLUMN_NAME_LASTUPDATEDTIME + " TEXT)";

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "sc_profilepic2.db";
    private static SCSqliteHelper scSqliteHelper;


    public static SCSqliteHelper getInstance(Context context) {

        if (scSqliteHelper == null) {
            scSqliteHelper = new SCSqliteHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        return scSqliteHelper;
    }


    public SCSqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_PROFILEINFO_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
