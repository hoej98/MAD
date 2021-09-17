package com.example.exercise_3_0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class EditTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        Intent intent = getIntent();
    }

    public static final String EXTRA_NAME = "PickerActivity2_Name";
    public static final String EXTRA_PHONE = "PickerActivity2_Phone";
    public static final String EXTRA_EMAIL = "PickerActivity2_Email";
    public static final String EXTRA_PASSWORD = "PickerActivity2_Password";

    public void setValues(View view) {
        Intent intent = new Intent(this, MainActivity.class);

        TextView textviewName = (TextView) findViewById(R.id.editTextName);
        String tempName = textviewName.getText().toString();
        intent.putExtra(EXTRA_NAME,tempName);

        TextView textviewPhone = (TextView) findViewById(R.id.editTextPhone);
        String tempPhone = textviewPhone.getText().toString();
        intent.putExtra(EXTRA_PHONE, tempPhone );

        TextView textviewEmail = (TextView) findViewById(R.id.editTextTextEmailAddress);
        String tempEmail = textviewEmail.getText().toString();
        intent.putExtra(EXTRA_EMAIL, tempEmail );

        TextView textviewPassword = (TextView) findViewById(R.id.editTextTextPassword);
        String tempPassword = textviewPassword.getText().toString();
        intent.putExtra(EXTRA_PASSWORD, tempPassword );

        startActivity(intent);
    }

    public void cancelValues(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}