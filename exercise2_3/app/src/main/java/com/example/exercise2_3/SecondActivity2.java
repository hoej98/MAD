package com.example.exercise2_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SecondActivity2 extends AppCompatActivity {

    private static final String MESSAGE_KEY = "MessageKey";
    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
    }

    public void sendMessage(View view) {
        EditText message_text = (EditText) findViewById(R.id.EditText1);
        String message = message_text.getText().toString();
        Intent intent = new Intent (this, MainActivity.class);
        intent.putExtra(MESSAGE_KEY, message);
        startActivity(intent);
        Log.d(TAG, message);
        Log.d(TAG, "sendmessage virker");
    }

    public void cancelMessage(View view) {
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }

}