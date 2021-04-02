package com.cursoandroid.midias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.bach);

        seekBar = findViewById(R.id.seekBar);

        //configura o audio manager
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        // Recupera os valores de volume maximo e o vulume atual
        int volumeMaximo = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int volumeAtual = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        // configura os valores mximos para o seekbar
        seekBar.setMax(volumeMaximo);
        seekBar.setProgress(volumeAtual);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();//tira a musica memoria do cel
            mediaPlayer = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
    }

    public void executarSom(View view){
        if (mediaPlayer != null){
            mediaPlayer.start();
        }
    }

    public void pausarSom(View view){
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }

    public void PararSom(View view){
        if (mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
    }



}