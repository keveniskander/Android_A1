package com.example.androidassignments;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;



public class ChatDatabaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_Of_My_ITEMS = "tableOfMyItems";
    public static final String Item_ID = "_id";
    public static final String ITEM_NAME = "itemName";
    public static final String DATABASE_NAME = "myPersonalDatabase.db";
    private static final int VERSION_NUM = 2;

    private static final String DATABASE_CREATE = "create table "
            + TABLE_Of_My_ITEMS + "(" + Item_ID
            + " integer primary key autoincrement, " + ITEM_NAME
            + " text not null);";

    public ChatDatabaseHelper(Context ctx) {
        super(ctx, DATABASE_NAME, null, VERSION_NUM);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(ChatDatabaseHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Of_My_ITEMS);
        onCreate(db);
    }

    public void onDowngrade (SQLiteDatabase database, int oldVersion, int newVersion) {
        Log.w(ChatDatabaseHelper.class.getName(),
                "Downgrading database from version " + newVersion + " to "
                        + oldVersion);
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_Of_My_ITEMS);
        onCreate(database);
    }

    public long count(SQLiteDatabase database) {
        long count = 0;
        database.execSQL("select count(*) " + " from " + "  TABLE_Of_My_ITEMS");
        return count;
    }

    public void addTable (SQLiteDatabase database) {
        database.execSQL("DROP TABLE IF EXISTS " + "contact");

        // Table/Database creation statement
        final String contact_table = "create table "
                + "contacts" + " ( " +
                "firstName" + " text primary key , " +
                "lastName"  + " text , " +
                "email"    + " text , " +
                " phoneNumber" + " number " +
                ");";

        database.execSQL(contact_table);

        ContentValues values = new ContentValues();
        values.put( "firstName", "Abdul-Rahman");
        values.put( "lastName", "Mawlood-Yunis");
        values.put( "email", "abdulrahman@mawloodyunis.com");
        values.put("phoneNumber", "1234567890");
        long insertId = database.insert("contacts", null,
                values);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
        addTable (database) ;
    }


}
