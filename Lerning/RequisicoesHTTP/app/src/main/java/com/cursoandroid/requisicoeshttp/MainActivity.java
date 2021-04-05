package com.cursoandroid.requisicoeshttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cursoandroid.requisicoeshttp.api.CEPService;
import com.cursoandroid.requisicoeshttp.model.CEP;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Button      botaoRecuperar;
    private TextView    textoResultado;
    private EditText    editText;
    private Retrofit    retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoRecuperar  = findViewById(R.id.button);
        textoResultado  = findViewById(R.id.resultado);
        editText        = findViewById(R.id.cepDigitado);

        String cepDigitado = editText.getText().toString();
        String urlCep   = "https://viacep.com.br/ws/";

        retrofit = new Retrofit.Builder()
                .baseUrl(urlCep)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        botaoRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recuperarCEPRetrofit(cepDigitado);
            }
        });
    }

    private void recuperarCEPRetrofit(String cepDigitado) {

        CEPService cepService =  retrofit.create(CEPService.class);
        Call<CEP> call =  cepService.recuperarCEP(cepDigitado);

        call.enqueue(new Callback<CEP>() {
            @Override
            public void onResponse(Call<CEP> call, Response<CEP> response) {
                if(response.isSuccessful()){
                    CEP cep =  response.body();
                    textoResultado.setText(cep.getCep() + "-"
                    + cep.getLogradouro()+ "-" + cep.getBairro());
                };
            }
            @Override
            public void onFailure(Call<CEP> call, Throwable t) {
            }
        });
    }
}