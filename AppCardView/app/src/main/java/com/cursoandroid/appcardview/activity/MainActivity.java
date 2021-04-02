package com.cursoandroid.appcardview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.cursoandroid.appcardview.R;
import com.cursoandroid.appcardview.adapter.Adapter;
import com.cursoandroid.appcardview.model.Postagem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Postagem> postagens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =  findViewById(R.id.recyclerView);



        //Define um layaout
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        // define adapter
        this.prepararPostagem();
        Adapter adapter = new Adapter(postagens);
        recyclerView.setAdapter(adapter);
    }

    public void prepararPostagem(){
       Postagem p1 = new Postagem("Igor Augusto Labaki", "#tbt Viagem Legal", R.drawable.imagem1);
       Postagem p2 = new Postagem("Igor Augusto Labaki", "#tbt Viagem Legal", R.drawable.imagem2);
       Postagem p3 = new Postagem("Igor Augusto Labaki", "#tbt Viagem Legal", R.drawable.imagem3);
       Postagem p4 = new Postagem("Igor Augusto Labaki", "#tbt Viagem Legal", R.drawable.imagem4);
       this.postagens.add(p1);
       this.postagens.add(p2);
       this.postagens.add(p3);
       this.postagens.add(p4);
    }

}