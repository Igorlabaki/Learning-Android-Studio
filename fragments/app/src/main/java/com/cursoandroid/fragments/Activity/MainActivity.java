package com.cursoandroid.fragments.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cursoandroid.fragments.Fragment.ContatosFragment;
import com.cursoandroid.fragments.Fragment.ConversasFragment;
import com.cursoandroid.fragments.R;

public class MainActivity extends AppCompatActivity {

    private Button buttonConversa, buttonContatos;
    private ConversasFragment conversasFragment;
    private ContatosFragment contatosFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonConversa = findViewById(R.id.buttonConversa);
        buttonContatos = findViewById(R.id.buttonContato);

        //Remover sombra AcitonBar
        getSupportActionBar().setElevation(0);

        // Fragments intancia
        conversasFragment =  new ConversasFragment();


        // Configurar objeto para Fragmento
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameConteudo, conversasFragment);
        transaction.commit();

        buttonContatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                contatosFragment =  new ContatosFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, contatosFragment);
                transaction.commit();
            }
        });

        buttonConversa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conversasFragment =  new ConversasFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, conversasFragment);
                transaction.commit();
            }
        });

    }
}