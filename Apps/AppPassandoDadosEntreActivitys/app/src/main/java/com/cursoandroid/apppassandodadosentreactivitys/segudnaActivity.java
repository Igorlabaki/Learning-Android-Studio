package com.cursoandroid.apppassandodadosentreactivitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class segudnaActivity extends AppCompatActivity {

    private TextView nome;
    private TextView idade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segudna);

        nome = findViewById(R.id.txtNome);
        idade = findViewById(R.id.txtIdade);

        //Recupera os dados enviados
        Bundle dados = getIntent().getExtras();

        Usuario usuarioRecuperado = (Usuario) dados.getSerializable("usuario");

        String      nomeRecuperdo    = dados.getString("nome");
        Integer     idadeRecuperada  = dados.getInt("idade");

        //nome.setText(nomeRecuperdo);
        //idade.setText(idadeRecuperada.toString());

        nome.setText(usuarioRecuperado.getNome());
        idade.setText(usuarioRecuperado.getIdade().toString());

    }
}