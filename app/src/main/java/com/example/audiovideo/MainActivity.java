package com.example.audiovideo;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

    public class MainActivity extends AppCompatActivity
    {
        VideoView VideoPlayer;
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            VideoPlayer =  (VideoView)findViewById(R.id.videoView);
            Uri myVideoUri= Uri.parse( "android.resource://" + getPackageName() + "/" + R.raw.videoplayback);
            VideoPlayer.setVideoURI(myVideoUri);
            MediaController mediaController = new MediaController(this);
            VideoPlayer.setMediaController(mediaController);
            mediaController.setMediaPlayer(VideoPlayer);

            Button buttonStart = (Button) findViewById(R.id.buttonStart);
            Button buttonStop = (Button) findViewById(R.id.buttonStop);
            Button buttonPause = (Button) findViewById(R.id.buttonPause);

            buttonStart.setOnClickListener(view -> VideoPlayer.start());

            buttonStop.setOnClickListener(view -> {
                VideoPlayer.stopPlayback();
                VideoPlayer.resume();
            });

            buttonPause.setOnClickListener(view -> VideoPlayer.pause());

        }
    }