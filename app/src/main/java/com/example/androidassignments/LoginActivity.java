package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    protected static final String LoginActivity = "LoginActivity";

    private Object DefaultEmail;
    private Button BtnLogin;
    private EditText EmailAddress;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences shared = getSharedPreferences("Login", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit=shared.edit();
        edit.putString("DefaultEmail", "email@domain.com");
        edit.commit();


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

    public void saveEmail(View view){
        SharedPreferences shared = getSharedPreferences("Login", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit=shared.edit();
        EditText text = (EditText)findViewById(R.id.login);
        edit.putString("userEmail", text.getText().toString());
        edit.commit();

        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }
}