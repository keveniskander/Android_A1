package com.example.androidassignments;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class TestToolbar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_toolbar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
            public boolean onCreateOptionsMenu (Menu m){
                getMenuInflater().inflate(R.menu.menu_main, m );
                return true;

            }
            public boolean onOptionsItemSelected(MenuItem item){
//                item.getItemId();
                switch (item.getItemId()) {
                    case R.id.option1:
                        Log.d("Toolbar", "Option 1selected");
                        break;
                    case R.id.option2:
                        //Start an activity…
                        break;
                }
                return true;

            }
        });
    }
}