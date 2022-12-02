package com.example.evaluaciont1_jgs;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SeleccionActivity extends AppCompatActivity {

    static String codigoAcceso = "";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1){
            codigoAcceso = "R1";
        }
        else if(requestCode == 2){
            codigoAcceso = "R2";
        }
        else if(requestCode == 3){
            codigoAcceso = "C1";
        }
    }

    Button btnAceptar;
    Button btnCancelar;
    EditText etPais;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);

        btnAceptar = findViewById(R.id.btnAceptar);
        btnCancelar = findViewById(R.id.btnCancelar);
        etPais = findViewById(R.id.etSeleccPaisSelec);

        System.out.println(  " **********************"+ codigoAcceso + " *****************************");
        btnAceptar.setOnClickListener(view -> comprobarSelecPais());

        btnCancelar.setOnClickListener(view -> finish());


        //btnLimpiarDatos.setOnClickListener(view -> btnLimpiarDatos());


    }

    private void comprobarSelecPais() {
        if(etPais.length() != 0){
            if (codigoAcceso.equals("R1")) {
                Intent i = new Intent(this,RegistroActivity.class );

                startActivity(i);
            }
            else if(codigoAcceso.equals("R2")){
                Intent i = new Intent(this,RegistroActivity.class );

                startActivity(i);
            }
            else if (codigoAcceso.equals("C1")){
                Intent i = new Intent(this,ConsultaActivity.class );

                startActivity(i);
            }

        }
        else Toast.makeText(this, "Debe introudcir el pais seleccionado", Toast.LENGTH_SHORT).show();
    }
}