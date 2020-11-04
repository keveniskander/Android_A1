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
import android.widget.Toast;

public class TestToolbar extends AppCompatActivity {

//    String snackbarString;

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
                Snackbar.make(view, "Test snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu m) {
        getMenuInflater().inflate(R.menu.menu_main, m);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        String snackbarString = "You selected option 1";
        FloatingActionButton fab = findViewById(R.id.fab);
        switch (id) {
            case (R.id.option1):
                Log.d("Toolbar", "Option 1 selected");
                Snackbar.make(fab, snackbarString, Snackbar.LENGTH_LONG).setAction(("Action"), null).show();
                break;

            case (R.id.option2):
                Log.d("Toolbar", "Option 2 selected");
                snackbarString = "You selected option 2";
                Snackbar.make(fab, snackbarString, Snackbar.LENGTH_LONG).setAction(("Action"), null).show();
                break;

            case (R.id.option3):
                Log.d("Toolbar", "Option 3 selected");
                snackbarString = "You selected option 3";
                Snackbar.make(fab, snackbarString, Snackbar.LENGTH_LONG).setAction(("Action"), null).show();
                break;
            case (R.id.settings):
                String messagePassed = "Version 1.0 by Keven Iskander";

                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(TestToolbar.this , messagePassed, duration); //this is the ListActivity
                toast.show(); //display your message box
                break;

        }

        //change from True to actual value
        return true;
    }
}
