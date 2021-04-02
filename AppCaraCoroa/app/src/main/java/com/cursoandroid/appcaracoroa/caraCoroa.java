package com.cursoandroid.appcaracoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.List;
import java.util.Random;

public class caraCoroa extends AppCompatActivity {

    private ImageView buttonVoltar;
    private ImageView resultadoMoeda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cara_coroa);

        buttonVoltar    = findViewById(R.id.buttonVoltar);
        resultadoMoeda  = findViewById(R.id.resultadoMoeda);

        Bundle dados = getIntent().getExtras();

        Integer imagem = dados.getInt("resultado");

        resultadoMoeda.setImageResource(imagem);
        
        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}