package com.example.smartwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MusicPlayer extends AppCompatActivity {

    Button startbtn;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        //startbtn = (Button)findViewById(R.id.startbtn);


//        startbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (count%2==0)
//                {
//                    startbtn.setBackground(R.id.stop_btn);
//                }
//            }
//        });
    }
}
