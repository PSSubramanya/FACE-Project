package com.example.smartwatch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StopWatch extends AppCompatActivity {

    Button btnStart, btnPause, btnLap;
    //Button btnReset;
    TextView txtTimer;
    Handler customHandler = new Handler();
    LinearLayout container;

    long startTime = 0L, timeInMilliseconds = 0L, timeSwapBuff = 0L, updateTime = 0L;


    Runnable updateTimeThread = new Runnable() {
        @Override
        public void run() {
            timeInMilliseconds =SystemClock.uptimeMillis()-startTime;
            updateTime = timeSwapBuff+timeInMilliseconds;
            int secs = (int)(updateTime/1000);
            int mins = secs/60;
            secs%=60;
            int milliseconds = (int)(updateTime%1000);
            txtTimer.setText(""+mins+":"+String.format("%2d",secs)+":"
                                        +String.format("%3d",milliseconds));

            customHandler.postDelayed(this,0);


        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        btnStart = (Button)findViewById(R.id.btnStart);
        btnPause = (Button)findViewById(R.id.btnPause);
        btnLap = (Button)findViewById(R.id.btnLap);
        //btnReset = (Button)findViewById(R.id.btnReset);
        txtTimer = (TextView)findViewById(R.id.timervalue);
        container = (LinearLayout)findViewById(R.id.container);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTime = SystemClock.uptimeMillis();

                customHandler.postDelayed(updateTimeThread,0);
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeSwapBuff+=timeInMilliseconds;
                customHandler.removeCallbacks(updateTimeThread);
            }
        });



        btnLap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View addView = inflater.inflate(R.layout.row,null);
                TextView txtValue = (TextView)addView.findViewById(R.id.textContent);
                txtValue.setText(txtTimer.getText());
                container.addView(addView);
            }
        });

//        btnReset.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                LayoutInflater inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
////                View addView = inflater.inflate(R.layout.row,null);
////                TextView txtValue = (TextView)addView.findViewById(R.id.textContent);
////                txtValue.setText(" ");
////                container.clearAnimation();
//                Fragment fragment = getSupportFragmentManager().findFragmentByTag();
//                getSupportFragmentManager().beginTransaction().remove()
//            }
//        });

    }
}
