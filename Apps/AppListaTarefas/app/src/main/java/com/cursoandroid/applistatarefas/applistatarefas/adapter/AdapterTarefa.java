package com.cursoandroid.applistatarefas.applistatarefas.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cursoandroid.applistatarefas.R;
import com.cursoandroid.applistatarefas.applistatarefas.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class AdapterTarefa extends RecyclerView.Adapter<AdapterTarefa.MyViewHolder> {

    List<Tarefa> listaTarefa;

    public AdapterTarefa(List<Tarefa> listaTarefa) {
        this.listaTarefa = listaTarefa;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.listatarefa
        ,parent,false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Tarefa tarefa = listaTarefa.get(position);
        holder.tarefa.setText(tarefa.getNomeTarefa());
    }

    @Override
    public int getItemCount() {
        return this.listaTarefa.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tarefa;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tarefa = itemView.findViewById(R.id.tarefa);
        }
    }

}
