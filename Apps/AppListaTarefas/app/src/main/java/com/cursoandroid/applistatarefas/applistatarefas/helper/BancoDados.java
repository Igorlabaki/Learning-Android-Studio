package com.cursoandroid.applistatarefas.applistatarefas.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class BancoDados extends SQLiteOpenHelper {

    public static int VERSION               = 2;
    public static String NOME_DB            = "DB_TAREFAS";
    public static String TABELA_TAREFAS     = "tarefas";

    public BancoDados(Context context) {
        super(context, NOME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS "+ TABELA_TAREFAS
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " nome TEXT NOT NULL); ";
        try{
            db.execSQL(sql);
            Log.i("Info db", "Banco Criado");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE "+ TABELA_TAREFAS;
        try{
            db.execSQL(sql);
            onCreate(db);
            Log.i("Info db", "App atualizado");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
