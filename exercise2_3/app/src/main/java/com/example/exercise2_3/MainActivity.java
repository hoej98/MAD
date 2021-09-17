package com.example.exercise2_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private static final String MESSAGE_KEY = "MessageKey";
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String message = intent.getStringExtra("MessageKey");
        if(message == null) {
            message = "VIRK NU";
        }

        TextView textView = findViewById(R.id.textView1);
        textView.setText(message);
    }

    public void OnClickChangeActivity(View view) {
        Intent myIntent = new Intent(this, SecondActivity2.class);
        startActivity(myIntent);
    }

}