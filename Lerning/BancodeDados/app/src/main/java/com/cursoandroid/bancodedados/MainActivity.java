package com.cursoandroid.bancodedados;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import java.sql.SQLData;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            // Criar banco de dados
            SQLiteDatabase bancoDados =  openOrCreateDatabase("app", MODE_PRIVATE,
                    null);

            //Criar Tabela
            //bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas " +
            //        "(nome VARCHAR, IDADE INT(3))");

            //bancoDados.execSQL("DROP TABLE pessoas ");

            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT,nome VARCHAR, idade INT(3))");

            //Inserir dados
            //bancoDados.execSQL("INSERT INTO pessoas (nome, idade)" +
            //          "VALUES('Igor',30)");
            //bancoDados.execSQL("INSERT INTO pessoas (nome, idade)" +
            //          "VALUES('Erika',27)");

            //Update
            //bancoDados.execSQL("UPDATE pessoas SET idade = 30 WHERE idade = 19 ");

            //Recuperar os Dados
            Cursor cursor = bancoDados.rawQuery("SELECT * FROM pessoas",null);

            //Deletar dados
            //bancoDados.execSQL("DELETE FROM pessoas WHERE id = 2");

            //Indices da tabela
            int indiceNome  = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");
            int indiceId    = cursor.getColumnIndex("id");

            cursor.moveToFirst();
            while(cursor != null){
                Log.i("Resultado - nome",   cursor.getString(indiceNome));
                Log.i("Resultado - idade",  cursor.getString(indiceIdade));
                Log.i("Resultado - id",     cursor.getString(indiceId));
                cursor.moveToNext();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}