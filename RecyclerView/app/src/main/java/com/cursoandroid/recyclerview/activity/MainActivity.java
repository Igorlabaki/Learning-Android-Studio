package com.cursoandroid.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.cursoandroid.recyclerview.Adapter.Adapter;
import com.cursoandroid.recyclerview.ClickListener;
import com.cursoandroid.recyclerview.R;
import com.cursoandroid.recyclerview.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView    recyclerView;
    private List<Filme>     listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Listagem Itens
        criarFilmes();

        // Configurar o adapter
        Adapter adapter = new Adapter(listaFilmes);

        // Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.hasFixedSize();
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //EVENTO CLICK
        recyclerView.addOnItemTouchListener(
                new ClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new ClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(getApplicationContext(),
                                                filme.getTituloFilme(),
                                                Toast.LENGTH_SHORT
                                        ).show();

                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );
    }

    public void criarFilmes(){
        Filme filme = new Filme("Home-Aranha - De volta ao Lar","Acao","2018" );
        this.listaFilmes.add(filme);

        Filme filme2 = new Filme("Home-Aranha - De volta ao Lar","Acao","2018" );
        this.listaFilmes.add(filme);

        Filme filme3 = new Filme("Home-Aranha - De volta ao Lar","Acao","2018" );
        this.listaFilmes.add(filme);

        Filme filme5 = new Filme("Home-Aranha - De volta ao Lar","Acao","2018" );
        this.listaFilmes.add(filme);

        Filme filme12 = new Filme("Home-Aranha - De volta ao Lar","Acao","2018" );
        this.listaFilmes.add(filme);

        Filme filme6 = new Filme("Home-Aranha - De volta ao Lar","Acao","2018" );
        this.listaFilmes.add(filme);
        Filme filme7 = new Filme("Home-Aranha - De volta ao Lar","Acao","2018" );
        this.listaFilmes.add(filme);
        Filme filme8 = new Filme("Home-Aranha - De volta ao Lar","Acao","2018" );
        this.listaFilmes.add(filme);
        Filme filme9 = new Filme("Home-Aranha - De volta ao Lar","Acao","2018" );
        this.listaFilmes.add(filme);
        Filme filme10 = new Filme("Home-Aranha - De volta ao Lar","Acao","2018" );
        this.listaFilmes.add(filme);
        Filme filme11 = new Filme("Home-Aranha - De volta ao Lar","Acao","2018" );
        this.listaFilmes.add(filme);

    }
}