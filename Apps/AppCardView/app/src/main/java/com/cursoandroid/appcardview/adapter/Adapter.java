package com.cursoandroid.appcardview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cursoandroid.appcardview.R;
import com.cursoandroid.appcardview.model.Postagem;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Postagem> postagens;

    public Adapter(List<Postagem> pontagens) {
        this.postagens = pontagens;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adaptercard,
                        parent,
                        false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Postagem postagem = postagens.get(position);

        holder.nome.setText(postagem.getNome());
        holder.postagem.setText(postagem.getPostagem());
        holder.imagem.setImageResource(postagem.getImagem());

    }

    @Override
    public int getItemCount() {
        return this.postagens.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView    nome;
        private TextView    postagem;
        private ImageView   imagem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nome        = itemView.findViewById(R.id.nomeTxt);
            postagem    = itemView.findViewById(R.id.txtPostagem);
            imagem      = itemView.findViewById(R.id.imagemPostagem);

        }
    }

}
