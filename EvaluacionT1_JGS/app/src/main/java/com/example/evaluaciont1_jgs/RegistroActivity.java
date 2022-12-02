package com.example.evaluaciont1_jgs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {


    static String SELECCIONAR_PAIS_UNO = "R1";
    static String SELECCIONAR_PAIS_DOS = "R2";

    EditText  etFecha;
    EditText  etFase;
    EditText  etEquipo1;
    EditText  etEquipo2;
    EditText  etGolesEquipo1;
    EditText  etGolesEquipo2;

    
    Button btnSeleccionar1;
    Button btnSeleccionar2;
    Button btnGuardarResultados;
    Button btnLimpiarDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnGuardarResultados = findViewById(R.id.btnGuardarDatos);
        btnLimpiarDatos = findViewById(R.id.btnLimpiarDatos);
        btnSeleccionar1 = findViewById(R.id.btnSelecPaisUno);
        btnSeleccionar2 = findViewById(R.id.btnSelecPaisDos);

        etFecha = findViewById(R.id.etFechaHora);
        etFase = findViewById(R.id.etFaseTorneo);
        etEquipo1= findViewById(R.id.etPaisUno);
        etEquipo2 = findViewById(R.id.etPaisDos);
        etGolesEquipo1 = findViewById(R.id.etNumGolesPaisUno);
        etGolesEquipo2 = findViewById(R.id.etNumGolesPaisDos);

        btnSeleccionar1.setOnClickListener(this);
        btnSeleccionar2.setOnClickListener(this);
        btnGuardarResultados.setOnClickListener(this);
        btnLimpiarDatos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btnGuardarDatos){

            if(comprobarCampos()){
                Toast.makeText(this,"Datos guardados exitosamente",Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(this, "Debe introducir todos los datos", Toast.LENGTH_SHORT).show();
            }

        }
        else if(v.getId() == R.id.btnLimpiarDatos){
            btnLimpiarDatos();
        }
        else if(v.getId() == R.id.btnSelecPaisUno){
            Intent i = new Intent(RegistroActivity.this,SeleccionActivity.class);
            i.putExtra("StringSeleccion",SELECCIONAR_PAIS_UNO);
          }
        else if(v.getId() == R.id.btnSelecPaisDos){
            Intent i = new Intent(RegistroActivity.this,SeleccionActivity.class);
            i.putExtra("StringSeleccion",SELECCIONAR_PAIS_DOS);
        }
    }

    private void btnLimpiarDatos() {

        etFecha.setText("");
        etFase.setText("");
        etGolesEquipo2.setText("");
        etGolesEquipo1.setText("");
        etEquipo1.setText("");
        etEquipo2.setText("");

    }

    private boolean comprobarCampos() {


        if(etFase.length() != 0 &&
                etFase.length() != 0 &&
                etEquipo2.length() != 0 &&
                etEquipo1.length() != 0 &&
                etGolesEquipo1.length() != 0 &&
                etGolesEquipo2.length() != 0
        )
        {
            return  true;
        }
        else{
            return false;
        }
    }

}