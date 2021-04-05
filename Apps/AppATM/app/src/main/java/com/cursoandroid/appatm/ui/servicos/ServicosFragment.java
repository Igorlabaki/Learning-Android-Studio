package com.cursoandroid.appatm.ui.servicos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.cursoandroid.appatm.R;

public class ServicosFragment extends Fragment {

    private ServicosViewModel servicosViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        servicosViewModel =
                new ViewModelProvider(this).get(ServicosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_servicos, container, false);

        return root;
    }
}