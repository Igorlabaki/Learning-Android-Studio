package com.cursoandroid.appatm.ui.servicos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ServicosViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ServicosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}