package com.example.postcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Audio mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPlayer = new Audio();

        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                mPlayer.stop();
            }
        });

        ImageView i = (ImageView) findViewById(R.id.imageView);
        i.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                mPlayer.play(MainActivity.this);
            }
        });

    }

class Audio {
    private MediaPlayer mPlayer;
    public void play(Context context) {
        stop();
        mPlayer = MediaPlayer.create(context, R.raw.music );
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){


            @Override
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });
        mPlayer.start();
    }
    public void stop(){
        if (mPlayer != null)
        {
            mPlayer.release();
            mPlayer = null;
        }
    }
}}