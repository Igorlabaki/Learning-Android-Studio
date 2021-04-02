package com.cursoandroid.appgorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView txtGorjeta;
    private TextView txtTotal;

    private double porcetagem;

    // SeekBar
    private SeekBar  seekBar;
    private TextView txtSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor   = findViewById(R.id.valorConta);
        txtGorjeta  = findViewById(R.id.txtGorjeta);
        txtTotal    = findViewById(R.id.txtTotal);

        seekBar     = findViewById(R.id.seekBar);
        txtSeekBar  = findViewById(R.id.txtSeekBar);

        seekBarListener();
    }

    public void seekBarListener(){
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcetagem = progress;
                txtSeekBar.setText(Math.round(porcetagem) +"%");
                caucular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void caucular(){

        DecimalFormat df = new DecimalFormat("##.##");
        String valorRecuperado = editValor.getText().toString();
        if (valorRecuperado == null || valorRecuperado.equals("")) {
            Toast.makeText(getApplicationContext(), "Digite o valor da conta",
                    Toast.LENGTH_SHORT).show();
        }else{
            double valorDigitado    = Double.parseDouble(valorRecuperado);
            double gorjeta          = valorDigitado *(porcetagem/100);
            double total            = gorjeta + valorDigitado;

            txtGorjeta.setText("R$ " + df.format(gorjeta));
            txtTotal.setText("R$ " + df.format(total));

        }
    }
}