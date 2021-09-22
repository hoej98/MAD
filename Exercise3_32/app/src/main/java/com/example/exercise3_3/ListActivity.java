package com.example.exercise3_3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }

    public ArrayList<PersonalInfo> personList = new ArrayList<PersonalInfo>();
    PersonalInfo mikkel = new PersonalInfo("Mikkel", "Stor dreng", 1);
}