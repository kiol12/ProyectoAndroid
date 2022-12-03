package com.example.evaluaciont1_jgs;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityResultLauncher<Intent> startActivityForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == SeleccionActivity.CODIGO_R1) {
                        etEquipo1.setText(result.getData().getStringExtra(SeleccionActivity.PAIS));
                    } else if (result.getResultCode() == SeleccionActivity.CODIGO_R2) {
                        etEquipo2.setText(result.getData().getStringExtra(SeleccionActivity.PAIS));
                    }
                }
            }
    );


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
        btnLimpiarDatos.setOnClickListener(view -> LimpiarDatos());
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btnGuardarDatos){

            if(comprobarCampos()){
              //  if(comprobarFecha()) {
                    if (comprobarFase()) {
                        if (!etEquipo1.getText().toString().equals(etEquipo2.getText().toString())) {
                            Toast.makeText(this, "Datos guardados exitosamente", Toast.LENGTH_LONG).show();

                            LimpiarDatos();
                        } else if (etEquipo1.getText().toString().equals(etEquipo2.getText().toString())) {
                            Toast.makeText(this, "Un pais no puede jugar contra si mismo", Toast.LENGTH_LONG).show();
                        }
                    }

                    else if (!comprobarFase()) {
                        Toast.makeText(this, "Debe introducir una fase correcta", Toast.LENGTH_SHORT).show();
                    }
                //}
               // else if(!comprobarFecha()) {
                 //   Toast.makeText(this, "Debe introducir una fecha correcta", Toast.LENGTH_SHORT).show();
                //}

            }
           else if(!comprobarCampos()){
                    Toast.makeText(this, "Debe introducir todos los datos", Toast.LENGTH_SHORT).show();
                }

        }
        else if(v.getId() == R.id.btnLimpiarDatos){
            LimpiarDatos();
        }
        else if(v.getId() == R.id.btnSelecPaisUno){
            Intent i = new Intent(RegistroActivity.this,SeleccionActivity.class);
            i.putExtra("codigo","R1");
            startActivityForResult.launch(i);
          }
        else if(v.getId() == R.id.btnSelecPaisDos){
            Intent i = new Intent(RegistroActivity.this,SeleccionActivity.class);
            i.putExtra("codigo","R2");
            startActivityForResult.launch(i);
        }
    }
/*
    private boolean comprobarFecha() {

        String regexFecha = "(0[1-9]|[12][0-9]|[3][01])/(0[1-9]|1[012])/\\d{4}";

        String fecha = etFecha.getText().toString();

        if (fecha.matches(regexFecha)) {
            return true;
        }
        else{
            return false;
        }
    }

 */

    private void LimpiarDatos() {

        etFecha.setText("");
        etFase.setText("");
        etGolesEquipo2.setText("");
        etGolesEquipo1.setText("");
        etEquipo1.setText("");
        etEquipo2.setText("");

    }

    private boolean comprobarCampos() {

        if (etFase.length() != 0 &&
                etFase.length() != 0 &&
                etEquipo2.length() != 0 &&
                etEquipo1.length() != 0 &&
                etGolesEquipo1.length() != 0 &&
                etGolesEquipo2.length() != 0
        ) {
            return true;
        } else {
            return false;
        }
    }

    private boolean comprobarFase() {

        String fase = etFase.getText().toString();

        if(fase.equals("Fase de grupos")
                || fase.equals("Octavos")
                || fase.equals("Cuartos")
                ||fase.equals("Semifinales")
                ||fase.equals("Tercer puesto")
                || fase.equals("Final")) {
            return true;
        }
        else
            return false;
    }

}