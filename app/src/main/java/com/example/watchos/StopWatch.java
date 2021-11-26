package com.example.watchos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Locale;

public class StopWatch extends Activity {

    private int seconds = 0;
    private boolean running;
    private boolean wasRunning;
    String colorSelect;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stop_watch);

        //Get and set background color
        Intent intent = getIntent();
        String selectColor = intent.getStringExtra("SelectColor");
        final ConstraintLayout constraintLayout;
        constraintLayout = findViewById(R.id.rlVar1);
        colorSelect = selectColor;

        if (selectColor.equals("blue")){
            constraintLayout.setBackgroundResource(R.color.blue);
        }
        else if (selectColor.equals("yellow")) {
            constraintLayout.setBackgroundResource(R.color.yellow);
        }
        if (savedInstanceState != null) {

            // Get the previous state of the stopwatch
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }

        runTimer();

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putBoolean("wasRunning", wasRunning);
    }

    // If the activity is paused, stop the stopwatch.
    @Override
    protected void onPause()
    {
        super.onPause();
        wasRunning = running;
        running = false;
    }

    // If the activity is resumed, continue the stopwatch
    @Override
    protected void onResume()
    {
        super.onResume();
        if (wasRunning) {
            running = true;
        }
    }

    // Start the stopwatch running when the Start button is clicked.
    public void onClickStart(View view)
    {
        running = true;
    }

    // Stop the stopwatch running when the Stop button is clicked.
    public void onClickStop(View view)
    {
        running = false;
    }

    // Reset the stopwatch when the Reset button is clicked.
    public void onClickReset(View view)
    {
        running = false;
        seconds = 0;
    }

    // Increment the seconds and update the text view.
    private void runTimer()
    {

        // Get the text view.
        final TextView timeView
                = (TextView)findViewById(
                R.id.timeView);

        // Creates a new Handler.
        final Handler handler
                = new Handler();

        // Process message in runnable objects using handler.
        handler.post(new Runnable() {
            @Override

            public void run()
            {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                // Format the second to hours, minutes and second.
                String time = String.format(Locale.getDefault(),"%d:%02d:%02d", hours, minutes, secs);

                // Set the text View.
                timeView.setText(time);

                // If running is true, increment the seconds variable.
                if (running) {
                    seconds++;
                }

                // Post the code again.
                handler.postDelayed(this, 1000);
            }
        });
    }

    // Back to main activity.
    public void backfunction(View view){
        Intent intent = new Intent(StopWatch.this, MainActivity.class);
        intent.putExtra("SelectColor", colorSelect);
        startActivity(intent);
    }

}
