package com.cursoandroid.appcaracoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView buttonJogar;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonJogar = findViewById(R.id.buttonJogar);

        buttonJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),caraCoroa.class);

                Moeda moeda = new Moeda();
                Integer resultado = moeda.getResultados().get(random.nextInt(2));

                intent.putExtra("resultado",resultado);

                startActivity(intent);

            }
        });

    }
}