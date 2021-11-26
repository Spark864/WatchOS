package com.example.watchos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextClock;
import android.widget.TextView;

import com.example.watchos.databinding.ActivityMainBinding;

import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends Activity {

    private TextView mTextView;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        TextClock textClock = new TextClock(MainActivity.this);
        //get time
        //set alarm for time
        //or set phone time to time
    }

    // Goto the stopwatch function
    public void stopwatchfunction(View view){
        Intent intent = new Intent(MainActivity.this, StopWatch.class);
        startActivity(intent);
    }

}