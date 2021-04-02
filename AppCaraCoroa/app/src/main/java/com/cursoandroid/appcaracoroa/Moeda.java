package com.cursoandroid.appcaracoroa;

import java.util.ArrayList;
import java.util.List;

public class Moeda {

    private int id;
    private List<Integer> resultados = new ArrayList<>();

    public Moeda() {
        this.resultados.add(R.drawable.moeda_cara);
        this.resultados.add(R.drawable.moeda_coroa);
    }

    public List<Integer> getResultados() {
        return resultados;
    }

    public void setResultados(List<Integer> resultados) {
        this.resultados = resultados;
    }


}
