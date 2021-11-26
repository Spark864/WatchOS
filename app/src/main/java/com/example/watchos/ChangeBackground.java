package com.example.watchos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.constraintlayout.widget.ConstraintLayout;

public class ChangeBackground extends Activity {
    String colorSelect = "noChange";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.background_function);

        Button button1, button2;
        final ConstraintLayout constraintLayout;

        button1 = findViewById(R.id.btn_blue);
        button2 = findViewById(R.id.btn_yellow);
        constraintLayout = findViewById(R.id.rlVar1);
        Intent intent = getIntent();
        String selectColor = intent.getStringExtra("SelectColor");

        colorSelect = selectColor;
        if (selectColor.equals("blue")){
            constraintLayout.setBackgroundResource(R.color.blue);
        }
        else if (selectColor.equals("yellow")) {
            constraintLayout.setBackgroundResource(R.color.yellow);
        }

        // Change background to blue
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                colorSelect = "blue";
                constraintLayout.setBackgroundResource(R.color.blue);
            }
        });

        // Change background to yellow
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                colorSelect = "yellow";
                constraintLayout.setBackgroundResource(R.color.yellow);
            }
        });
    }


    public void backfunction(View view){
        Intent intent = new Intent(ChangeBackground.this, MainActivity.class);
        intent.putExtra("SelectColor", colorSelect);
        startActivity(intent);
    }
}
