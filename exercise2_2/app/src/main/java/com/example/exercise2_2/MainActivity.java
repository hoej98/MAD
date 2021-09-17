package com.example.exercise2_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.exercise2_2.R;

import org.w3c.dom.Text;

import java.security.Key;

public class MainActivity extends AppCompatActivity {



    private static final String keyValue = "countvalue";

    private ClickerViewModel cvm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");

       /* if(savedInstanceState != null)
        {
            value = savedInstanceState.getInt(keyValue);
        }
        TextView counterText = (TextView) findViewById(R.id.textView1);
        counterText.setText(String.format("%d", value));*/

        cvm = new ViewModelProvider(this).get(ClickerViewModel.class);
        cvm.getCount().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer newCount) {
                TextView counterText = (TextView) findViewById(R.id.textView1);
                counterText.setText(String.format("%d", newCount));
            }
        });
    }

/*    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(keyValue, cvm.count);
        Log.d(TAG, "autist");
    }*/

    //int value = 0;

    public void OnClickAddOne(View view) {
    cvm.countUpByValue(1);
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }
}