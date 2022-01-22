package com.example.media_player;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView songName;
    Button play;
    Button pause;
    Button forward;
    Button rewind;
    Button stop;
    Button restart;
    int startTime = 0;
    int stopTime = 0;
    int seek = 5000;
    MediaPlayer currMediaPlayer, newMediaPlayer;
    public MediaPlayer func(){
        newMediaPlayer = MediaPlayer.create(this, R.raw.habibi_song);
        return newMediaPlayer;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currMediaPlayer = func();
        songName = findViewById(R.id.songName);
        songName.setText("Habibi_song");
        play  = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        forward = findViewById(R.id.forward);
        rewind = findViewById(R.id.rewind);
        stop = findViewById(R.id.stop);
        restart = findViewById(R.id.restart);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Playing Song", Toast.LENGTH_SHORT).show();
                currMediaPlayer.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Song Paused", Toast.LENGTH_SHORT).show();
                currMediaPlayer.pause();
            }
        });
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Forwarded 5 sec", Toast.LENGTH_SHORT).show();
                int currPos = currMediaPlayer.getCurrentPosition();
                stopTime = currMediaPlayer.getDuration();
                if(currPos + seek <= stopTime){
                    currMediaPlayer.seekTo(currPos + seek);
                    currMediaPlayer.start();
                }
            }
        });
        rewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Rewinded 5 sec", Toast.LENGTH_SHORT).show();
                int currPos = currMediaPlayer.getCurrentPosition();
                if(currPos - seek >= startTime){
                    currMediaPlayer.seekTo(currPos - seek);
                    currMediaPlayer.start();
                }
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Stopping Song", Toast.LENGTH_SHORT).show();
                currMediaPlayer.stop();
                currMediaPlayer = func();
            }
        });
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Restarting Song", Toast.LENGTH_SHORT).show();
                currMediaPlayer.seekTo(0);
                currMediaPlayer.start();
            }
        });
    }
}