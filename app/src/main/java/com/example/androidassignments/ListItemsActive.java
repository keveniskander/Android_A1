package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.app.LauncherActivity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.List;

public class ListItemsActive extends AppCompatActivity {

    protected static final String ListItemsActive = "ListItemsActive";
    static final int REQUEST_IMAGE_CAPTURE = 1;

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