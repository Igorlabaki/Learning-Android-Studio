package com.cursoandroid.appingles.fragment;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cursoandroid.appingles.R;

public class AnimaisFragment extends Fragment implements View.OnClickListener{

    private ImageView buttonCao,buttonVaca,buttonOvelha,buttonMacaco,buttonGato,buttonLeao;

    private MediaPlayer mediaPlayer;


    public AnimaisFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_animais, container, false);

        buttonCao       = view.findViewById(R.id.buttonCao);
        buttonGato      = view.findViewById(R.id.buttonGato);
        buttonVaca      = view.findViewById(R.id.buttonVaca);
        buttonMacaco    = view.findViewById(R.id.buttonMacaco);
        buttonOvelha    = view.findViewById(R.id.buttonOvelha);
        buttonLeao      = view.findViewById(R.id.buttonLeao);

        //Aplica evento click
        buttonCao.setOnClickListener(this);
        buttonMacaco.setOnClickListener(this);
        buttonGato.setOnClickListener(this);
        buttonLeao.setOnClickListener(this);
        buttonOvelha.setOnClickListener(this);
        buttonVaca.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonCao:
                    mediaPlayer = MediaPlayer.create(getActivity(),R.raw.dog);
                    tocaSom();
                break;
            case R.id.buttonGato:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.cat);
                tocaSom();
                break;
            case R.id.buttonLeao:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.lion);
                tocaSom();
                break;
            case R.id.buttonVaca:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.cow);
                tocaSom();
                break;
            case R.id.buttonOvelha:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.sheep);
                tocaSom();
                break;
            case R.id.buttonMacaco:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.monkey);
                tocaSom();
                break;
        }
    }

    public void tocaSom(){
        if(mediaPlayer != null){
            mediaPlayer.start();
        }

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.release();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null){
            mediaPlayer.release();
        }
    }
}