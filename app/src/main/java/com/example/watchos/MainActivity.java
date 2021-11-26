package com.example.watchos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import android.widget.TextView;

import com.example.watchos.databinding.ActivityMainBinding;

import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends Activity {

    private TextView mTextView;
    private ActivityMainBinding binding;
    String colorSelect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Get and set background color
        Intent intent = getIntent();
        String selectColor = intent.getStringExtra("SelectColor");
        final RelativeLayout relativeLayout;
        relativeLayout = findViewById(R.id.rlVar1);
        if (selectColor == null){
            colorSelect = "noChange";
        }
        else {
            colorSelect = selectColor;
        }

        if (colorSelect.equals("blue")){
            relativeLayout.setBackgroundResource(R.color.blue);
        }
        else if (colorSelect.equals("yellow")) {
            relativeLayout.setBackgroundResource(R.color.yellow);
        }

    }

    // Goto the stopwatch function
    public void stopwatchfunction(View view){
        Intent intent = new Intent(MainActivity.this, StopWatch.class);
        intent.putExtra("SelectColor", colorSelect);
        startActivity(intent);
    }

    //Goto the background function
    public void backgroundfunction(View view){
        Intent intent = new Intent(MainActivity.this, ChangeBackground.class);
        intent.putExtra("SelectColor", colorSelect);
        startActivity(intent);
    }

}