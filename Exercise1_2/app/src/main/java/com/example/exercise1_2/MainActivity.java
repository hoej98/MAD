package com.example.exercise1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int value = 0;

    public void OnClickAddOne(View view) {
        TextView counterText = (TextView) findViewById(R.id.textView1);
        value++;
        counterText.setText(String.format("%d", value));
    }
}