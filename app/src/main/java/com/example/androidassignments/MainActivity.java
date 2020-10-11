package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    protected static final String MainActivity = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(MainActivity, "In onCreate()");

        Button button = (Button)findViewById(R.id.button);
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

    public void startActivityForResult(View view) {


        Intent intent = new Intent(MainActivity.this, ListItemsActive.class);
        startActivityForResult(intent, 10);

    }

    public void onActivityResult(int requestCode, int responseCode, Intent data) {
        super.onActivityResult(requestCode, responseCode, data);
        if (requestCode == 10) {
            Log.i(MainActivity, "Returned to MainActivity.onActivityResult");
        }
        if (responseCode == Activity.RESULT_OK){
            String messagePassed = data.getStringExtra("Response");

            int duration = Toast.LENGTH_LONG;


            Toast toast = Toast.makeText(MainActivity.this , messagePassed, duration); //this is the ListActivity
            toast.show(); //display your message box
        }
    }

}
