package com.cursoandroid.sanckfloating;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button buttonAbrir,buttonFechar;
    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAbrir = findViewById(R.id.abrirSnackBar);
        buttonFechar = findViewById(R.id.snackBarFechar);

        buttonAbrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar = Snackbar.make(
                        v,
                        "Botao Pressionado",
                        Snackbar.LENGTH_INDEFINITE
                ).setAction("Confirmar", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        buttonAbrir.setText("Botao Abrir Alterado");
                    }
                }).setActionTextColor(getResources().getColor(R.color.white));
                snackbar.show();
            }
        });

        buttonFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
    }
}