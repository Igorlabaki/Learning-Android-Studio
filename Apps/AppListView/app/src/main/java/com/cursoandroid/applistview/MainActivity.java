package com.cursoandroid.applistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listLocais;
    private String [] itens = {
            "Angra dos Reis","Caldas novas",
            "Sao Paulo", "Rio de Janeiro",
            "Sao Sebastiao", "Guaruja",
            "Nova York", "Caribe"
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listLocais = findViewById(R.id.listaLocais);

        //Criar adaptador
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itens);

        //Adiciona o adaptador para a lista
        listLocais.setAdapter(adaptador);

        // Adiciona clique na lista
        listLocais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String valorSelecionado = listLocais.getItemAtPosition(position).toString();

                Toast.makeText(getApplicationContext(),
                                valorSelecionado,
                                Toast.LENGTH_SHORT)
                                .show();
            }
        });
    }
}