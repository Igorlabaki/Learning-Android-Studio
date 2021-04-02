package com.cursoandroid.appatm.ui.clientes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.cursoandroid.appatm.R;

public class ClientesFragment extends Fragment {

    private ClientesViewModel clientesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        clientesViewModel =
                new ViewModelProvider(this).get(ClientesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_clientes, container, false);

        return root;
    }
}