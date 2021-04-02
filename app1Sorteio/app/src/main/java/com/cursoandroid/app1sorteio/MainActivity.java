package com.cursoandroid.app1sorteio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sorteiaNumero(View view){

        TextView txtSorteio = findViewById(R.id.numeroSorteado);

        int numeroAleatorio = new Random().nextInt(5);

        txtSorteio.setText("Numero sorteado foi: " + numeroAleatorio);
    }
}