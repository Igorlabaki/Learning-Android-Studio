package com.cursoandroid.appbookreaders.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
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
import com.google.android.material.textfield.TextInputEditText;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LoginActivity extends AppCompatActivity {

    private Button      buttonLogin;
    private EditText    username,password;
    private TextView    forgotButton;
    private List<User>  userList = new ArrayList<User>();


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttonLogin  = findViewById(R.id.buttonLogin);
        username     = findViewById(R.id.usernameInput);
        password     = findViewById(R.id.passwordInput);
        forgotButton = findViewById(R.id.forgotButton);

        getSupportActionBar().hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    public void forgotAccount(View view){

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void login(String username, String password){
        UserDAO userDAO = new UserDAO(getApplicationContext());

        User user = userDAO.search(username);

        if(user != null){
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            intent.putExtra("user", (Serializable) user);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(),"Username or password are wrong",Toast.LENGTH_SHORT).show();
        }
    }
}