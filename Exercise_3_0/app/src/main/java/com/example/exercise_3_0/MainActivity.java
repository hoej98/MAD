package com.example.exercise_3_0;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ComponentActivity;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.app_bar_search1:
                showDialog();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void showDialog() {
    AlertDialog alertDialog = new AlertDialog.Builder(this)
//set icon
            .setIcon(android.R.drawable.ic_dialog_alert)
//set title
            .setTitle("Are you sure to Exit")
//set message
            .setMessage("Exiting will call finish() method")
//set positive button
            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //set what would happen when positive button is clicked
                    finish();
                }
            })
//set negative button
            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //set what should happen when negative button is clicked
                    Toast.makeText(getApplicationContext(),"Nothing Happened",Toast.LENGTH_LONG).show();
                }
            })
            .show();
    }

    //public void searchForStuff() {
    //    Toast.makeText(getContext(), "sut din mor", Toast.LENGTH_LONG).show();
    //}

    public Context getContext() {
        Context context = getApplicationContext();
        return context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent tempIntent = getIntent();
        TextView textView = (TextView) findViewById(R.id.DemoText0);
        String number = tempIntent.getStringExtra(PickerActivity2.EXTRA_NUMBER);
        textView.setText(number);

        TextView textView1 = (TextView) findViewById(R.id.DemoText);
        String name = tempIntent.getStringExtra(EditTextActivity.EXTRA_NAME);
        textView1.setText(name);

        TextView textView2 = (TextView) findViewById(R.id.DemoText2);
        String email = tempIntent.getStringExtra(EditTextActivity.EXTRA_EMAIL);
        textView2.setText(email);

        TextView textView3 = (TextView) findViewById(R.id.DemoText3);
        String phone = tempIntent.getStringExtra(EditTextActivity.EXTRA_PHONE);
        textView3.setText(phone);

        TextView textView4 = (TextView) findViewById(R.id.DemoText4);
        String password = tempIntent.getStringExtra(EditTextActivity.EXTRA_PASSWORD);
        textView4.setText(password);


    }

    public void onClickNewActivity1(View view) {
        Intent intent1 = new Intent(this, PickerActivity2.class);
        startActivity(intent1);
    }

    public void onCLickNewActivity2(View view){
        Intent intent2 = new Intent(this, EditTextActivity.class);
        startActivity(intent2);
    }
}