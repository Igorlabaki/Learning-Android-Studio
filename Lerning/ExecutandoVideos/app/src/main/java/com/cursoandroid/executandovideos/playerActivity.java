package com.cursoandroid.executandovideos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class playerActivity extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        videoView = findViewById(R.id.videoView);

        //Esconde statusBar e barra de anvegacao
        View decore = getWindow().getDecorView();
        int uiOpcoes = View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;

        decore.setSystemUiVisibility(uiOpcoes);

        //Esconder AcitonBar
        getSupportActionBar().hide();

        //Configra os controles
        videoView.setMediaController(new MediaController(this));
        videoView.setVideoPath("android.resource" + getPackageName() + "/" + R.raw.video);
        videoView.start();

    }
}