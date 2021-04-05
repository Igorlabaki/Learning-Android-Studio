package com.cursoandroid.componentesdeinterface;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private Switch          swicht;
    private CheckBox        checkBox;
    private ToggleButton    toggleSenha;
    private TextView        resultado;
    String  resultadoTxt    = "";

    //ProgressBar
    private ProgressBar horizontal;
    private ProgressBar circular;
    private int progresso = 0;

    //SeekBar

    private SeekBar seekBar;
    private TextView txtSeekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swicht          = findViewById(R.id.switchButton);
        checkBox        = findViewById(R.id.checkBox);
        toggleSenha     = findViewById(R.id.toggleButton);
        resultado       = findViewById(R.id.txtResultado);
        horizontal      = findViewById(R.id.progressBar);
        circular        = findViewById(R.id.progressBarCircular);
        seekBar         = findViewById(R.id.seekBar);
        txtSeekBar      = findViewById(R.id.resultadoSeekBar);

        circular.setVisibility(View.GONE);
        horizontal.setVisibility(View.GONE);

        adicionarListenerCheckBox();
        adicionarListenerSeekBar();

    }

    public void enviar(View view){
        if (swicht.isChecked()){
            resultadoTxt = resultadoTxt + " Swicth ligado\n";
            resultado.setText(resultadoTxt);
        }
        if (toggleSenha.isChecked()){
            resultadoTxt = resultadoTxt + " ToggleButton ligado\n";
            resultado.setText(resultadoTxt);
        }
        abrirToast(view);
    }

    public void adicionarListenerCheckBox(){
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                resultado.setText(resultadoTxt+"CheckBox ligado");
            }
        });
    }

    public void adicionarListenerSeekBar(){
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtSeekBar.setText("Progresso:" + progress + "/" + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void recuperarProgressoSeekBar(View view){

        txtSeekBar.setText("Progresso:" + seekBar.getProgress()+"/"+ seekBar.getMax());

    }

    public void abrirToast(View view){
        /*Toast.makeText(getApplicationContext(),"Toast aberto",Toast.LENGTH_SHORT).show();*/

        ImageView imagem = new ImageView(getApplicationContext());
        imagem.setImageResource(android.R.drawable.star_big_off);
        /*TextView textview = new TextView(getApplicationContext())
        * textView.setText("Ola Toast")*/
        Toast toast = new Toast(getApplicationContext());

        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(imagem);
        /*toast.setView(textview);*/
        toast.show();
    }

    public void alerta(View view){

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        dialog.setTitle("Titulo da dialog");
        dialog.setMessage("Mensagem dialog");

        //Configurar Cancelamento(obrigado respodner)
        dialog.setCancelable(false);

        //Cinfugrar um icone

        dialog.setIcon(android.R.drawable.ic_btn_speak_now);

        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Sim",
                        Toast.LENGTH_LONG).show();
            }
        });

        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Nao",
                        Toast.LENGTH_LONG).show();
            }
        });



        dialog.create().show();


    }

    public void carregarProgressBar(View view){

        //horizonta
        this.progresso = this.progresso + 10;
        horizontal.setVisibility(View.VISIBLE);
        horizontal.setProgress(this.progresso);

        //circular
        circular.setVisibility(View.VISIBLE);


        if(this.progresso == 100){
            circular.setVisibility(View.GONE);
            horizontal.setVisibility(View.GONE);
        }
    }

    }