package com.example.evaluaciont1_jgs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    Button btnRegistrar;
    Button btnConsultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnConsultar = findViewById(R.id.btnConsultar);

        btnConsultar.setOnClickListener(this);

        btnRegistrar.setOnClickListener(this);

    }

    public void onClick(View view) {

        if(view.getId() == R.id.btnConsultar)
            startActivity(new Intent(MainActivity.this,ConsultaActivity.class));
        else if(view.getId() == R.id.btnRegistrar)
            startActivity(new Intent(MainActivity.this,RegistroActivity.class));
        }
    }
