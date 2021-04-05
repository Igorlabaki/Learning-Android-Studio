package com.cursoandroid.alcoolgasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextView resultado;
    TextInputEditText editPrecoAlcool;
    TextInputEditText editPrecoGasolina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool     = findViewById(R.id.precoAlcool);
        editPrecoGasolina   = findViewById(R.id.precoGasolina);
        resultado           = findViewById(R.id.txtResultado);

    }

    public void calcular(View view){
        String precoAlcool      = editPrecoAlcool.getText().toString();
        String precoGasolina    = editPrecoGasolina.getText().toString();

        Boolean camposValidados = validarCampos(precoAlcool,precoGasolina);

        if(camposValidados){
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            if(valorAlcool/valorGasolina < 0.7){
                resultado.setText("Abasteca com alcool!");
            }else{
                resultado.setText("Abasteca com Gasolina!");
            }

        }else{
            resultado.setText("Preenchas todos os campos!");
        }
    }

    public Boolean validarCampos(String pAlcool, String pGasolina ){
        Boolean camposValidados = true;

        if(pAlcool == null || pAlcool.equals("")) {
            camposValidados = false;
        }

        if(pGasolina == null || pGasolina.equals("")){
            camposValidados = false;
        }

        return camposValidados;
    }
}