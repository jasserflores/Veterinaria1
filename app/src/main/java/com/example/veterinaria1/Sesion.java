package com.example.veterinaria1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sesion extends AppCompatActivity {
    daoRegistro dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion);

        Button btn_Ingreso = findViewById(R.id.btn_Ingreso);
        Button btn_Locali = findViewById(R.id.btn_Locali);
        dao = new daoRegistro(Sesion.this);


        btn_Locali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Sesion.this,Mapa.class));

            }
        });

        btn_Ingreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sesion.this,Menu.class));
            }
        });
    }
}