package com.example.veterinaria1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class Login extends AppCompatActivity {

    private ProgressBar pb;

    Button btn_Iniciar;

    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Iniciar = findViewById(R.id.btn_Iniciar);
        pb = findViewById(R.id.pb);







        btn_Iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pb.setVisibility(View.VISIBLE);

                Timer timer = new Timer();
                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {

                        counter++;

                        pb.setProgress(counter);
                        if (counter ==50) {
                            timer.cancel();

                            Intent Iniciar = new Intent(Login.this,Sesion.class);
                            startActivity(Iniciar);
                        }

                    }
                };
                timer.schedule(timerTask,50,50);

            }
        });
    }
}