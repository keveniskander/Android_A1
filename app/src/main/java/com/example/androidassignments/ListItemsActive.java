package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.LauncherActivity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class ListItemsActive extends AppCompatActivity {

    protected static final String ListItemsActive = "ListItemsActive";
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items_active);
        Log.i(ListItemsActive, "In onCreate()");
        Switch sw = (Switch) findViewById(R.id.myswitch);
        CheckBox ch = (CheckBox) findViewById(R.id.mycheckbox);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int text;
                int duration;

                if (isChecked) {
                    text = R.string.SwitchOnText;
                    duration = Toast.LENGTH_SHORT;
                }else{
                    text = R.string.SwitchOffText;
                    duration = Toast.LENGTH_LONG;
                }

                Toast toast = Toast.makeText(getApplicationContext() , text, duration); //this is the ListActivity
                toast.show(); //display your message box
            }
        });
        ch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListItemsActive.this);
                // 2. Chain together various setter methods to set the dialog characteristics
                builder.setMessage(R.string.dialog_message) //Add a dialog message to strings.xml

                        .setTitle(R.string.dialog_title)
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User clicked OK button
                                Intent resultIntent = new Intent(  );
                                resultIntent.putExtra("Response", "Here is my response");
                                setResult(Activity.RESULT_OK, resultIntent);
                                finish();

                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        })
                        .show();

            }
        }
        );
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

    public void onClickImage(View view){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e){
            // display error state to user
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ImageButton imageButton = (ImageButton)findViewById(R.id.image_button);
            imageButton.setImageBitmap(imageBitmap);
        }
    }

}