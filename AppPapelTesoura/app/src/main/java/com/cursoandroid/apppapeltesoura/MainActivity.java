package com.cursoandroid.apppapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView escolhaApp;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void escolhaPedra(View view){
        this.opcaoSelecionada(1);
    }

    public void escolhaTesoura(View view){
        this.opcaoSelecionada(2);
    }

    public void escolhaPapel(View view){
        this.opcaoSelecionada(3);
    }

    public void opcaoSelecionada(int opcaoSelecionada){
        int numero = new Random().nextInt(3);
        Integer[] opcoes = {1,2,3};
        Integer opcaoApp = opcoes[numero];
        escolhaApp = findViewById(R.id.escolhaApp);
        resultado = findViewById(R.id.txtResultado);

        switch (opcaoApp){
            case 1:
                escolhaApp.setImageResource(R.drawable.pedra);
                break;
            case 2:
                escolhaApp.setImageResource(R.drawable.tesoura);
                break;
            case 3:
                escolhaApp.setImageResource(R.drawable.papel);
                break;
        }

        if (
                (opcaoApp == 2 && opcaoSelecionada == 3)||
                (opcaoApp == 1 && opcaoSelecionada == 2)||
                (opcaoApp == 3 && opcaoSelecionada == 1)
        ) { resultado.setText("Voce perdeu!");
        } else if(
                (opcaoSelecionada == 1 && opcaoApp == 2)||
                (opcaoSelecionada == 2 && opcaoApp == 3)||
                (opcaoSelecionada == 3 && opcaoApp == 1)
        ){
            resultado.setText("Voce ganhou!");
        }else{
            resultado.setText("Empate!");
        }
    }
}