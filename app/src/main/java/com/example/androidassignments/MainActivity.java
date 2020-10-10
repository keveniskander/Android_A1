package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;


public class MainActivity extends AppCompatActivity {


    protected static final String MainActivity = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(MainActivity, "In onCreate()");
    }

    public void onResume(){
        super.onResume();
        Log.i(MainActivity, "In onResume()");

    }

    public void onStart(){
        super.onStart();
        Log.i(MainActivity, "In onStart()");

    }

    public void onPause(){
        super.onPause();
        Log.i(MainActivity, "In onPause()");
    }

    public void onStop(){
        super.onStop();
        Log.i(MainActivity, "In onStop()");
    }

    public void onDestroy(){
        super.onDestroy();
        Log.i(MainActivity, "In onDestroy()");
    }




}