package com.cursoandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private Button buttonIniciar;
    private Switch aSwitch;
    private Handler handler = new Handler();
    private int i;
    private boolean pararExecucao = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aSwitch         = findViewById(R.id.switch1);
        buttonIniciar   = findViewById(R.id.buttonIniciar);
    }

    public void iniciarThread(View view){
        //MyThread thread = new MyThread();
        //thread.start();

        pararExecucao = false;

        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable).start();
    }

    public void pararThread(View view){
        pararExecucao = true;
    }

    class MyRunnable implements Runnable{
        @Override
        public void run() {
                for(i=15;i<=30;i++){

                    if(pararExecucao) return;

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            buttonIniciar.setText("contador: " + i);
                        }
                    });

                    /*handler.post(new Runnable() {
                        @Override
                        public void run() {
                            buttonIniciar.setText("contador: " + i);
                        }
                    });*/
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
        }
    }

    class MyThread extends Thread{
        @Override
        public void run() {
            for(int i=0;i<=15;i++){

                Log.d("Thread", "contador: " + i);

                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}