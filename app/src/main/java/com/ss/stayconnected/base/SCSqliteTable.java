package com.ss.stayconnected.base;

import android.content.Context;
import android.database.Cursor;

/**
 * Created by sowmi on 07/01/17.
 */
public abstract class SCSqliteTable implements ISCSqliteTable{


    public long save(Context context){
        return SCSqliteHelper.getInstance(context).getWritableDatabase().insert(this.getClass().getSimpleName() , null , getContentValues());
    }

    public static long deleteAll(Context context, Class clazz){
        return SCSqliteHelper.getInstance(context).getWritableDatabase().delete(clazz.getSimpleName() , null , null);
    }

    public static long delete(Context context, Class clazz, String whereClause, String[] whereArgs){
        return SCSqliteHelper.getInstance(context).getWritableDatabase().delete(clazz.getSimpleName() , whereClause , whereArgs);
    }

    public static Cursor retriveAll(Context context , Class clazz){
        return SCSqliteHelper.getInstance(context).getWritableDatabase().rawQuery( "SELECT * FROM " + clazz.getSimpleName() , null);
    }

    public static Cursor find(Context context, Class clazz, String[] columns, String selection, String[] selectionArgs){
        return SCSqliteHelper.getInstance(context).getWritableDatabase().query(clazz.getSimpleName(), columns, selection, selectionArgs, null, null, null) ;
    }

}
