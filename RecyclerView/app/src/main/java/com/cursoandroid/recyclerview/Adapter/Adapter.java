package com.cursoandroid.recyclerview.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cursoandroid.recyclerview.R;
import com.cursoandroid.recyclerview.model.Filme;

import org.w3c.dom.Text;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{

    private List<Filme> listaFilmes;

    public Adapter(List<Filme> listaFilmes) {

        this.listaFilmes = listaFilmes;

    }

    @NonNull
    @Override//criar as visualizacoes
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista,parent,false);

        return new MyViewHolder(itemLista);
    }

    @Override//exibe os elementos
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            Filme filme = listaFilmes.get(position);

            holder.titulo.setText(filme.getTituloFilme());
            holder.genero.setText(filme.getGenero());
            holder.ano.setText(filme.getAno());
    }

    @Override
    public int getItemCount() {
        return listaFilmes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titulo;
        TextView ano;
        TextView genero;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo  = itemView.findViewById(R.id.txtTitulo);
            ano     = itemView.findViewById(R.id.txtAno);
            genero  = itemView.findViewById(R.id.txtGenero);
        }
    }

}
