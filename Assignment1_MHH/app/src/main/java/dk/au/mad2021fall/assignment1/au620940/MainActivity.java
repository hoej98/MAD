package dk.au.mad2021fall.assignment1.au620940;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickChangeActivityToList(View view)
    {
    Intent intent = new Intent(this, ListActivity.class);
    startActivity(intent);
    }
}