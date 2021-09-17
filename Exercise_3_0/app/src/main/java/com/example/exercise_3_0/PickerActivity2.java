package com.example.exercise_3_0;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.exercise_3_0.databinding.ActivityPickerBinding;

public class PickerActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker2);

        Intent intent = getIntent();
    }
    public static final String EXTRA_NUMBER = "PickerActivity2_Number";
    Integer number;

    public void setSlideText(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar1);
        Integer tempNumber = seekBar.getProgress();
        String textedNumber = String.format("%d", tempNumber);
        intent.putExtra(EXTRA_NUMBER, textedNumber);
        startActivity(intent);
    }

    public void cancelSlide(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}