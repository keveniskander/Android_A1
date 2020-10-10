package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.app.LauncherActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class ListItemsActive extends AppCompatActivity {

    protected static final String ListItemsActive = "ListItemsActive";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items_active);
        Log.i(ListItemsActive, "In onCreate()");
    }

    public void onResume(){
        super.onResume();
        Log.i(ListItemsActive, "In onResume()");
    }

    public void onStart(){
        super.onStart();
        Log.i(ListItemsActive, "In onStart()");
    }

    public void onPause(){
        super.onPause();
        Log.i(ListItemsActive, "In onPause()");
    }

    public void onStop(){
        super.onStop();
        Log.i(ListItemsActive, "In onPause()");
    }

    public void onDestroy(){
        super.onDestroy();
        Log.i(ListItemsActive, "In onDestroy()");
    }
}