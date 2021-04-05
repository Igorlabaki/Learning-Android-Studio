package com.cursoandroid.appatm;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                enviarEmail();

            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);


        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_principal, R.id.nav_servicos, R.id.nav_clientes,R.id.nav_contato,
                R.id.nav_sobre)
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    private void enviarEmail() {

        String  celular = "tel:11996545330";
        String  imagem = "https://i.pinimg.com/originals/d8/44/01/d84401daf737344e65090880a7e8bac0.jpg";
        String  googleMaps = "https://www.google.com/maps/place/Guaec%C3%A1,+S%C3%A3o+Sebasti%C3%A3o+-+SP,+Brasil/" +
                "data=!4m2!3m1!1s0x94d2852fe523a231:0x62c25e987e72e052?sa=X&ved=2ahUKEwj9xau7xrLvAhVIQUEAHb6LDhAQ8gEwA" +
                "HoECAYQAQ";

        Intent intentCel = new Intent(Intent.ACTION_DIAL, Uri.parse(celular));
        Intent intentImag = new Intent(Intent.ACTION_VIEW, Uri.parse(imagem));
        Intent intentEndereco = new Intent(Intent.ACTION_VIEW, Uri.parse(googleMaps));
        Intent intentSend = new Intent(Intent.ACTION_SEND);

        intentSend.putExtra(Intent.EXTRA_EMAIL, new String[] {"igorlabakig@gmail.com"});
        intentSend.putExtra(Intent.EXTRA_SUBJECT, new String[] {"Contato Pelo App"});
        intentSend.putExtra(Intent.EXTRA_TEXT, new String[] {"Mensagem Automatica"});

        // pesquisa no google minetypes
        //intentSend.setType("message/rfc822");
        //intentSend.setType("text/plain");
        //intentSend.setType("image/*");
        intentSend.setType("application/pdf");

        startActivity(Intent.createChooser(intentSend,"Compartilhar"));



        startActivity(intentSend);

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}