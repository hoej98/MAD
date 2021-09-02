package com.example.excercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickChange(View view)
    {
        TextView helloworldText = (TextView)findViewById(R.id.textView1);
        if (helloworldText.getText().toString().equals("Hej verden"))
        {helloworldText.setText("Farvel verden");}
        else {helloworldText.setText(("Hej verden"));}
    }

    public void onClickExit(View view)
    {
        System.exit(0);
    }
}