package com.cursoandroid.appbookreaders.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.cursoandroid.appbookreaders.R;

public class FirstActivity extends AppCompatActivity {

    private Button buttonLogin,buttoNSingup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        buttonLogin = findViewById(R.id.buttonLogin);
        buttoNSingup = findViewById(R.id.buttonSingup);

        getSupportActionBar().hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //button
        buttonSingupClick();
        buttonLoginClick();

    }

    public void buttonSingupClick(){
        buttoNSingup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    public void buttonLoginClick(){
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}