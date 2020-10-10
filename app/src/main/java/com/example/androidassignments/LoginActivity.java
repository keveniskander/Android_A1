package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    protected static final String LoginActivity = "LoginActivity";
    private Button login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(LoginActivity, "In onCreate()");
    }
    public void onResume(){
        super.onResume();
        Log.i(LoginActivity, "In onResume()");

    }

    public void onStart(){
        super.onStart();
        Log.i(LoginActivity, "In onStart()");

    }

    public void onPause(){
        super.onPause();
        Log.i(LoginActivity, "In onPause()");
    }

    public void onStop(){
        super.onStop();
        Log.i(LoginActivity, "In onStop()");
    }

    public void onDestroy(){
        super.onDestroy();
        Log.i(LoginActivity, "In onDestroy()");
    }
}