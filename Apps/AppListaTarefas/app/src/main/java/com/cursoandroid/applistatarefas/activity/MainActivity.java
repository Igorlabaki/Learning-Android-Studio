package com.cursoandroid.applistatarefas.activity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.opengl.GLDebugHelper;
import android.os.Bundle;

import com.cursoandroid.applistatarefas.R;
import com.cursoandroid.applistatarefas.applistatarefas.adapter.AdapterTarefa;
import com.cursoandroid.applistatarefas.applistatarefas.helper.BancoDados;
import com.cursoandroid.applistatarefas.applistatarefas.helper.RecyclerItemClickListener;
import com.cursoandroid.applistatarefas.applistatarefas.helper.TarefaDAO;
import com.cursoandroid.applistatarefas.applistatarefas.model.Tarefa;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView  recyclerView;
    private AdapterTarefa adapterTarefa;
    private List<Tarefa>  listTarefa = new ArrayList<>();
    private Tarefa tarefaSelecioanda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewTarefas);


        //Adicionar evento de click
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //Recupera tarefa para edicao
                Tarefa tarefaSelecionada = listTarefa.get(position);

                //Envia tarefa para tela adicionar tarefa
                Intent intent = new Intent(MainActivity.this,AdicionarTarefaActivity.class);
                intent.putExtra("tarefaSelecioanda",tarefaSelecionada);
                startActivity(intent);

            }

            @Override
            public void onLongItemClick(View view, int position) {

                tarefaSelecioanda =  listTarefa.get(position);

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Confirmar a exclusao");
                dialog.setMessage("Deseja Excluir a tarefa " + tarefaSelecioanda.getNomeTarefa() +"?");

                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        TarefaDAO dao = new TarefaDAO(getApplicationContext());
                        dao.deletar(tarefaSelecioanda);
                        carregarListaTarefa();
                        Toast.makeText(getApplicationContext(),"Tarefa deletada",Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.setNegativeButton("Nao", null);

                dialog.create();
                dialog.show();

            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }
        ));

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(getApplicationContext(), AdicionarTarefaActivity.class);
               startActivity(intent);
            }
        });
    }

    public void carregarListaTarefa(){

        TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());

        listTarefa = tarefaDAO.listar();

        adapterTarefa =  new AdapterTarefa(listTarefa);

        RecyclerView.LayoutManager  layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        recyclerView.addItemDecoration( new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapterTarefa);
    }

    @Override
    protected void onStart() {
        carregarListaTarefa();
        super.onStart();
    }
}