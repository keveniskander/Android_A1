package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatWindow extends AppCompatActivity {
    public ArrayList<String> messages= new ArrayList<>();
    public EditText message;
    public ListView chat;
    public Button sendButton;
    public ChatAdapter messageAdapter;
    private ChatDatabaseHelper dbOpen;
    private SQLiteDatabase db;
    private String[] columns = {
            ChatDatabaseHelper.KEY_MESSAGE};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);
        chat= findViewById(R.id.chatView);

        message= findViewById(R.id.sendText);
        sendButton =findViewById(R.id.sendButton);

        messageAdapter= new ChatAdapter(this);
        chat.setAdapter(messageAdapter);

        dbOpen = new ChatDatabaseHelper(this);
        db = dbOpen.getWritableDatabase();

        ArrayList<String> MessageArray = new ArrayList<String>();

        Cursor cursor = db.query(ChatDatabaseHelper.TABLE_NAME,
                columns, null, null,
                null, null, null);

        cursor.moveToFirst();
        Log.i("OUTER", "OUTSIDE LOOP");
        while(!cursor.isAfterLast()){
            MessageArray.add(cursor.getString((cursor.getColumnIndex(ChatDatabaseHelper.KEY_MESSAGE))));
            Log.i("Chatwindow.java", "SQL MESSAGE" + cursor.getColumnIndex(ChatDatabaseHelper.KEY_MESSAGE));

            Log.i("Chatwindow.java", "Column count" + cursor.getColumnCount());
        }

        for (int i = 0; i < cursor.getColumnCount(); i++){
            Log.i("INNER", "INSIDE FOR LOOP");
            cursor.getColumnName(i);
        }
        cursor.close();


    }

    public void sendMessage(View view){

        messages.add(message.getText().toString());
        messageAdapter.notifyDataSetChanged();

        message.setText("");

    }
    private class ChatAdapter extends ArrayAdapter<String>{


        public ChatAdapter(Context ctx){
            super(ctx,0);
        }

        public int getCount(){

            return messages.size();
        }

        public String getItem(int position){
            return messages.get(position);
        }

        public View getView (int position, View convertView, ViewGroup parent){
            LayoutInflater inflater= ChatWindow.this.getLayoutInflater();
            View result=null;
            if (position%2==0){
                result=inflater.inflate(R.layout.chat_row_incoming,null);

            }else{
                result=inflater.inflate(R.layout.chat_row_outgoing,null);

            }
            TextView message=(TextView)result.findViewById(R.id.message_text);
            message.setText(getItem(position));

            return result;

        }
    }

}

