package com.cursoandroid.tarefasassincronas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
    }

    public void iniciarAssincTask(View view){
        MyAssincTask myAssincTask = new MyAssincTask();
        myAssincTask.execute(10);
    }

    /*
    1 -> Parametro a ser passado para a classe
    2 -> Tipo de valor que sera utilizado para o progresso da tarefa
    3 -> Retorno apos tarefa finalizada
     */

    class MyAssincTask extends AsyncTask<Integer,Integer,String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(Integer... integers) {
            int numero = integers[0];
            for(int i=0;i<numero;i++){
                onProgressUpdate(i);
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            return "Finalizado";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            progressBar.setProgress(0);
            progressBar.setVisibility(View.INVISIBLE);
        }
    }
}