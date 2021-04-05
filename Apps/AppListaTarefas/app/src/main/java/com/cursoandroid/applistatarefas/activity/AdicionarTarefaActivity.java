package com.cursoandroid.applistatarefas.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.cursoandroid.applistatarefas.R;
import com.cursoandroid.applistatarefas.applistatarefas.helper.TarefaDAO;
import com.cursoandroid.applistatarefas.applistatarefas.model.Tarefa;
import com.google.android.material.textfield.TextInputEditText;

public class AdicionarTarefaActivity extends AppCompatActivity {

    private TextInputEditText editText;
    private Tarefa tarefaAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);

        editText = findViewById(R.id.txtTarefa);

        //Recuperar tarefa caso seja edicao
        tarefaAtual = (Tarefa) getIntent().getSerializableExtra("tarefaSelecioanda");

        //Configurar a na caixa de texto
        if(tarefaAtual != null){
            editText.setText(tarefaAtual.getNomeTarefa());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_salvar) {

            //Executa acao para o item salvar
            TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());

            String nomeTarefa = editText.getText().toString();

            if(tarefaAtual != null){
                if(!nomeTarefa.isEmpty()){
                    tarefaAtual.setNomeTarefa(nomeTarefa);
                    tarefaDAO.atualizar(tarefaAtual);
                    finish();
                    Toast.makeText(getApplicationContext(),"Tarefa editada",Toast.LENGTH_SHORT).show();
                }
            }else{
                Tarefa tarefa = new Tarefa();
                if(!nomeTarefa.isEmpty()){
                    tarefa.setNomeTarefa(nomeTarefa);
                    tarefaDAO.salvar(tarefa);
                    finish();
                    Toast.makeText(getApplicationContext(),"Tarefa salva",Toast.LENGTH_SHORT).show();
                }
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}