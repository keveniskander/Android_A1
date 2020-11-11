package com.example.androidassignments;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;


public class ChatDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Messages.db";
    private static final int VERSION_NUM = 1;
    public static final String TABLE_NAME = "tableOfMyItems";
    public static final String KEY_ID = "_id";
    public static final String KEY_MESSAGE = "";
    private static final String DATABASE_CREATE = "create table "
            + TABLE_NAME + "(" + KEY_ID
            + " integer primary key autoincrement, " + KEY_MESSAGE
            + " text not null);";

    @Override
    public void onCreate(SQLiteDatabase database) {
        ArrayList<String> MessageArray = new ArrayList<String>();
        database.execSQL(DATABASE_CREATE);
//        addTable (database) ;
        String[] columns = {ChatDatabaseHelper.KEY_MESSAGE};
        Cursor cursor = database.query(ChatDatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        while(!cursor.isAfterLast()){
            MessageArray.add(cursor.getString((cursor.getColumnIndex(ChatDatabaseHelper.KEY_MESSAGE))));
            Log.i("Chatwindow.java", "SQL MESSAGE" + cursor.getColumnIndex(ChatDatabaseHelper.KEY_MESSAGE));
            Log.i("Chatwindow.java", "Column count" + cursor.getColumnCount());
        }

        for (int i = 0; i < cursor.getColumnCount(); i++){
            cursor.getColumnName(i);
        }
    }

    public ChatDatabaseHelper(Context ctx) {
        super(ctx, DATABASE_NAME, null, VERSION_NUM);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(ChatDatabaseHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }



}
