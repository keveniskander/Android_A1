package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatWindow extends AppCompatActivity {

    private ListView chatList;
    private EditText chatText;
    private Button chatButton;
    private ArrayList<String> chatMessage = new ArrayList<String>();
    public ChatAdapter messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);
        ListView chatList = (ListView) findViewById(R.id.chatList);
        final EditText chatText = (EditText) findViewById(R.id.sendText);
        Button chatButton = (Button) findViewById(R.id.sendButton);

        //in this case, “this” is the ChatWindow, which is-A Context object
        messageAdapter =new ChatAdapter( this );
        chatList.setAdapter (messageAdapter);



//        chatButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                String chatString = chatText.getText().toString();
//                chatMessage.add(chatString);
//
//            }
//        });
    }

    public void saveMessage(View view){

        chatMessage.add(chatText.getText().toString());
        messageAdapter.notifyDataSetChanged();

        chatText.setText("");

    }


    private class ChatAdapter extends ArrayAdapter<String> {


        public ChatAdapter(Context ctx) {
            super(ctx, 0);
        }
        public int getCount(){
            return chatMessage.size();
        }
        public String getItem(int position){
            return chatMessage.get(position);
        }
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = ChatWindow.this.getLayoutInflater();
            View result = null;
            if(position %2 == 0){
                result = inflater.inflate(R.layout.chat_row_incoming, null);
            }else{
                result = inflater.inflate(R.layout.chat_row_outgoing, null);
            }
            TextView message = (TextView)result.findViewById(R.id.sendText);
            message.setText(   getItem(position)  ); // get the string at position
            return result;

        }


    }

}