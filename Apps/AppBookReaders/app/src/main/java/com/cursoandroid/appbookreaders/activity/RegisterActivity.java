package com.cursoandroid.appbookreaders.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cursoandroid.appbookreaders.R;
import com.cursoandroid.appbookreaders.data.UserDAO;
import com.cursoandroid.appbookreaders.model.User;

public class RegisterActivity extends AppCompatActivity {

    private EditText    username,email,password,confirmPassword;
    private Button      singup;
    private TextView    accountExists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username        = findViewById(R.id.userRegister);
        email           = findViewById(R.id.emailRegister);
        password        = findViewById(R.id.passwordRegister);
        confirmPassword = findViewById(R.id.passwordConfirmRegister);
        singup          = findViewById(R.id.buttonSingup);
        accountExists   = findViewById(R.id.accountButton);

        getSupportActionBar().hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    public void setAccountExists(View view){
        accountExists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    public void singup(View view){
        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUser(view);
            }
        });
    }

    public void saveUser(View view) {
        String sUsername    = username.getText().toString();
        String sPassword    = password.getText().toString();
        String sPasswordC   = confirmPassword.getText().toString();
        String sEmail       = email.getText().toString();

        if(sUsername.isEmpty() || sPassword.isEmpty() || sEmail.isEmpty()){
            Toast.makeText(getApplicationContext(),"Please fill all the fields",Toast.LENGTH_SHORT).show();
        }else if(sPassword.equals(sPasswordC)){
            User user = new User(sUsername,sEmail,sPassword);
            UserDAO userDAO = new UserDAO(getApplicationContext());
            userDAO.save(user);
            Toast.makeText(getApplicationContext(),"Register succeed",Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
        }else{
            password.setText("");
            confirmPassword.setText("");
            Toast.makeText(getApplicationContext(),"Password didnt match",Toast.LENGTH_SHORT).show();
        }
    }
}
