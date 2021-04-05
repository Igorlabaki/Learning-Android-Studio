package com.cursoandroid.appminhasanotacoes;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private AnotacaoPreferencias preferences;
    private EditText editAnotacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = new AnotacaoPreferencias(getApplicationContext());
        editAnotacao = findViewById(R.id.editText);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoRecuperado = editAnotacao.getText().toString();
                if (textoRecuperado.equals("")){
                    Snackbar.make(view,
                            "Texto nao inserido",
                            Snackbar.LENGTH_SHORT
                    ).show();
                }else{
                    preferences.salvarAnotacoes(textoRecuperado);
                    Snackbar.make(view,
                            "Anotacao salva com sucesso",
                            Snackbar.LENGTH_SHORT
                    ).show();        }
            }
        });

        //Recuperar anotacao
        String anotacao = preferences.recuperarAnotacoes();
        if(!anotacao.equals("")){
            editAnotacao.setText(anotacao);
        }
    }
}