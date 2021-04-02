package com.cursoandroid.applistatarefas.applistatarefas.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.cursoandroid.applistatarefas.applistatarefas.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class TarefaDAO implements ITarefaDAO{

    private SQLiteDatabase escreve;
    private SQLiteDatabase le;

    public TarefaDAO(Context context) {
        BancoDados db   = new BancoDados(context);
        escreve         = db.getWritableDatabase();
        le              = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(Tarefa tarefa) {

        ContentValues cv = new ContentValues();
        cv.put("nome",tarefa.getNomeTarefa());

        try {
            escreve.insert(BancoDados.TABELA_TAREFAS,null,cv);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean atualizar(Tarefa tarefa) {

        ContentValues cv = new ContentValues();
        cv.put("nome",tarefa.getNomeTarefa());

        try {
            String[] args = {tarefa.getId().toString()};
            escreve.update(BancoDados.TABELA_TAREFAS,cv,"id=?",args);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }


        return true;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {

        try {
            String[] args = {tarefa.getId().toString()};
            escreve.delete(BancoDados.TABELA_TAREFAS,"id=?", args);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    public List<Tarefa> listar() {

        List<Tarefa> listaTarefas =  new ArrayList<>();

        String sql = "SELECT * FROM " + BancoDados.TABELA_TAREFAS + ";";

        Cursor cursor = le.rawQuery(sql,null);

        while(cursor.moveToNext()){
            Tarefa tarefa = new Tarefa();
            Long    id   = cursor.getLong(cursor.getColumnIndex("id"));
            String  nome = cursor.getString(cursor.getColumnIndex("nome"));
            tarefa.setId(id);
            tarefa.setNomeTarefa(nome);
            listaTarefas.add(tarefa);
        }

        return listaTarefas;
    }
}
