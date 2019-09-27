package com.example.smartwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.zip.DataFormatException;

public class MainActivity extends AppCompatActivity {

    Button msg, music, stopwatch;
    TextView systemtime,systemdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msg = (Button)findViewById(R.id.msg);
        music = (Button)findViewById(R.id.music);
        stopwatch = (Button)findViewById(R.id.stopwatch);

        systemdate = (TextView)findViewById(R.id.systemdate);


        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm");
//        String datetime = simpleDateFormat.format(calendar.getTime());
//        systemtime.setText(datetime);

        systemdate.setText(currentDate);

        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MessageActivity.class);
                startActivity(intent);
            }
        });

        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MusicPlayer.class);
                startActivity(intent);
            }
        });

        stopwatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,StopWatch.class);
                startActivity(intent);
            }
        });

    }
}
