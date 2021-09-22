package com.example.exercise3_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Person;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements PersonAdapter.IPersonItemClickedListener {

    public static final int NUM_ITEMS = 100;

    private RecyclerView rcvList;
    private PersonAdapter adapter;

    private ArrayList<PersonalInfo> persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new PersonAdapter(this);
        rcvList = findViewById(R.id.rcvPersons);
        rcvList.setLayoutManager(new LinearLayoutManager(this));
        rcvList.setAdapter(adapter);

        createData();
        adapter.updatePersonList(persons);
    }

    private void createData()
    {
        persons = new ArrayList<PersonalInfo>();
        Random r = new Random();
        for (int i = 0; i< NUM_ITEMS; i++)
        {
            persons.add(new PersonalInfo("Mikkel" + i, "Mikkel høj er høj", i, i));

            if(r.nextBoolean()) {persons.get(i).imageResourceId = 1;}
        }

    }

    @Override
    public void onPersonClicked(int index) {showDialogue(persons.get(index));}

    @Override
    public void sendInvite(PersonalInfo personClicked)
    {
        Toast.makeText(this, "description is: " + personClicked.getDescription(), Toast.LENGTH_SHORT).show();
    }

    private void showDialogue(PersonalInfo person)
    {
        int iconId = person.imageResourceId==0 ? R.drawable.android_circle : R.drawable.android_hex;

    androidx.appcompat.app.AlertDialog.Builder builder = new AlertDialog.Builder(this)
            .setIcon(iconId)
            .setMessage("You clicked on " + person.getName() + "\nWell done!" + "\nTheir description is:\n" + person.getDescription())
            .setTitle(person.getName());
        builder.create().show();
    }

    public void onClickChangeAcitivity(View view){
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }
}