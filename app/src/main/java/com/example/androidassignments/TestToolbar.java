package com.example.androidassignments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TestToolbar extends AppCompatActivity {

//    String snackbarString;
    String snackBarText = "You selected option 1";
    EditText newMessageText;
//    View view;

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
//        String snackbarString = "You selected option 1";
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        FloatingActionButton fab = findViewById(R.id.fab);
        switch (id) {
            case (R.id.option1):
                Log.d("Toolbar", "Option 1 selected");
                Snackbar.make(fab, snackBarText, Snackbar.LENGTH_LONG).setAction(("Action"), null).show();
                break;

            case (R.id.option2):
                Log.d("Toolbar", "Option 2 selected");
                snackBarText= "You selected option 2";
                Snackbar.make(fab, snackBarText, Snackbar.LENGTH_LONG).setAction(("Action"), null).show();


                builder.setTitle(R.string.go_back_message);
                    // Add the buttons
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });
                builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
                    // Create the AlertDialog
                AlertDialog dialog = builder.create();
                dialog.show();
                break;

            case (R.id.option3):
                Log.d("Toolbar", "Option 3 selected");
                LayoutInflater inflater = this.getLayoutInflater();
                final View v = inflater.inflate(R.layout.message_window, null);

                builder.setTitle(("SetMessage"));


                builder.setView(v);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        newMessageText = v.findViewById(R.id.custom_message);
                        snackBarText = newMessageText.getText().toString();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
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
