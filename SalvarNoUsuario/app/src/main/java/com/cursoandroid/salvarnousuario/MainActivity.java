package com.cursoandroid.salvarnousuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView                    txtResultado;
    private TextInputEditText           editNome;
    private Button                      buttonSalvar;
    private static final String         ARQUIVO_PREFERENCIA = "ArquivoPreferencia";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResultado = findViewById(R.id.txtResultado);
        editNome     = findViewById(R.id.editNome);
        buttonSalvar = findViewById(R.id.buttonSalvar);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
                SharedPreferences.Editor editor = preferences.edit();

                //Validar o nome
                if(editNome.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Preencha o nome",Toast.LENGTH_SHORT)
                            .show();
                }else{
                    String nome = editNome.getText().toString();
                    editor.putString("nome",nome);
                    editor.commit();
                    txtResultado.setText("Ola " + nome +"!" );
                }


            }
        });

        //Recuperar os dados SALVOS
        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);

        //Validar se temos o noe em preferencia
        if(preferences.contains("nome")){
            String nome = preferences.getString("nome","Usuario nao definido!");
            txtResultado.setText("Ola " + nome +"!" );
        }else {
            txtResultado.setText("Usuario nao definido!");
        }


    }
}