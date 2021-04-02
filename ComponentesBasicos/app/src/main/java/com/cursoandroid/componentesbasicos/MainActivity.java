package com.cursoandroid.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText            campoNome;
    private EditText            campoSenha;
    private TextInputEditText   campoEmail;
    private TextView            textoResultado;

    private String textoCheckBox = "Selecionado: ";
    private CheckBox respBoxVermelho,respBoxAzul,respBoxRosa;

    private RadioButton sexoMasculino,sexoFeminino;
    private RadioGroup  opcaosexo;
    private String      txtSexo = "Sexo: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoNome       = findViewById(R.id.nomeBox);
        campoSenha      = findViewById(R.id.passwordBox);
        campoEmail      = findViewById(R.id.emailBox);
        textoResultado  = findViewById(R.id.resultado);

        //CheckBox
        respBoxRosa         = findViewById(R.id.checkBoxRosa);
        respBoxAzul         = findViewById(R.id.checkBoxAzul);
        respBoxVermelho     = findViewById(R.id.checkBoxVermelho);

        //RadioButton
        sexoFeminino    = findViewById(R.id.radioButtonFeminino);
        sexoMasculino   = findViewById(R.id.radioButtonMasculino);

        //RadioGroup
        opcaosexo = findViewById(R.id.radiogroupId);
    }

    public void enviar(View view){
        String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();
        String senha = campoSenha.getText().toString();

        checkBox(respBoxAzul);
        checkBox(respBoxRosa);
        checkBox(respBoxVermelho);
        
        //radioButton(sexoFeminino);
        //radioButton(sexoMasculino);

       radioGroup(opcaosexo);

        textoResultado.setText(String.format("Nome: %s\n Password: %s\n Email:  %s\n %s\n %s",
                nome,senha,email,textoCheckBox,txtSexo));
        limpar(view);
    }

    public void limpar(View view){
        campoSenha.setText("");
        campoNome.setText("");
        campoEmail.setText("");
    }

    public void checkBox(CheckBox checkBox){
        if(checkBox.isChecked()){
            textoCheckBox = textoCheckBox + " " + checkBox.getText();
        }
    }

    public void radioButton(RadioButton radioButton){
        if(radioButton.isChecked()){
            textoCheckBox = textoCheckBox + " " + radioButton.getText();
        }
    }

    public void radioGroup(RadioGroup radioGroup){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioButtonMasculino){
                    txtSexo = txtSexo + sexoMasculino.getText().toString();
                }else{
                    txtSexo = txtSexo + sexoFeminino.getText().toString();
                }
            }
        });
    }
}