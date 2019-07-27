package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchActivity extends AppCompatActivity {
     Button btnstart,btnStop;
     ImageView icanchor;
     Animation roundingAlone;
     Chronometer timerHere;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        btnstart = (Button)findViewById(R.id.btnstart);
        btnStop = (Button)findViewById(R.id.btnstop);
        icanchor = (ImageView)findViewById(R.id.icanchor);
        timerHere = (Chronometer)findViewById(R.id.timer);
        // Optional Animation
           btnStop.setAlpha(0);

        // loading animations
        roundingAlone = AnimationUtils.loadAnimation(this , R.anim.rounding_alone);

        // setting up fonts

        Typeface MMedium = Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");
        btnstart.setTypeface(MMedium);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                icanchor.startAnimation(roundingAlone);
                btnStop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnstart.animate().alpha(0).setDuration(300).start();

                // starting time here

                timerHere.setBase(SystemClock.elapsedRealtime());
                timerHere.start();
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timerHere.stop();
                icanchor.clearAnimation();
            }
        });


    }
}
