package com.example.evaluaciont1_jgs;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.example.evaluaciont1_jgs.datos.ListadoResultados;
import com.example.evaluaciont1_jgs.datos.Resultado;

import java.util.ArrayList;
import java.util.Objects;

public class ConsultaActivity extends AppCompatActivity {
    String pais;

    ActivityResultLauncher<Intent> startActivityForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == SeleccionActivity.CODIGO_C1) {
                        etPais.setText(result.getData().getStringExtra(SeleccionActivity.PAIS));
                        pais=etPais.getText().toString();

                        btnSelec.setText(R.string.limpiarConsulta);
                        textoBoton = btnSelec.getText().toString();

                        cargarFragments(pais);
                    }
                }
            }
    );

    ListadoResultados listForFragments;
    Resultado resultado;

    ArrayList<Resultado> resultadosPais = new ArrayList<Resultado>();

    EditText etPais;
    Button btnSelec;

    String textoBoton;

    FrameLayout frmL1;
    FrameLayout frmL2;
    FrameLayout frmL3;
    FrameLayout frmL4;
    FrameLayout frmL5;
    FrameLayout frmL6;
    FrameLayout frmL7;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        etPais = findViewById(R.id.etIntroducePais);
        btnSelec = findViewById(R.id.btnSeleccionar);

        frmL1 = findViewById(R.id.frameLay1);
        frmL2 = findViewById(R.id.frameLay2);
        frmL3 = findViewById(R.id.frameLay3);
        frmL4 = findViewById(R.id.frameLay4);
        frmL5 = findViewById(R.id.frameLay5);
        frmL6 = findViewById(R.id.frameLay6);
        frmL7 = findViewById(R.id.frameLay7);

        textoBoton = btnSelec.getText().toString();

        btnSelec.setOnClickListener(view -> comprobarBoton());
    }

    private void comprobarBoton() {
        textoBoton = btnSelec.getText().toString();
        System.out.println(textoBoton);
        if (textoBoton.equals("LIMPIAR DATOS")){
            limpiarDatos();
        }else if(textoBoton.equals("SELECCIONAR")){
            Intent i = new Intent(ConsultaActivity.this, SeleccionActivity.class);
            i.putExtra("codigo", "C1");
            startActivityForResult.launch(i);
        }
    }

    private void limpiarDatos() {

        etPais.setText("");
        btnSelec.setText(R.string.seleccionar);


        for(int i = 0; i < resultadosPais.size();i++) {


            if(i == 0){
                getSupportFragmentManager().beginTransaction().remove(Objects.requireNonNull(getSupportFragmentManager().findFragmentById(R.id.frameLay1))).commit();
            }
            else if(i == 1){
                getSupportFragmentManager().beginTransaction().remove(Objects.requireNonNull(getSupportFragmentManager().findFragmentById(R.id.frameLay2))).commit();
            }
            else if(i == 2){
                getSupportFragmentManager().beginTransaction().remove(Objects.requireNonNull(getSupportFragmentManager().findFragmentById(R.id.frameLay3))).commit();
            }
            else if(i == 3){
                getSupportFragmentManager().beginTransaction().remove(Objects.requireNonNull(getSupportFragmentManager().findFragmentById(R.id.frameLay4))).commit();
            }
            else if(i == 4){
                getSupportFragmentManager().beginTransaction().remove(Objects.requireNonNull(getSupportFragmentManager().findFragmentById(R.id.frameLay5))).commit();
            }
            else if(i == 5){
                getSupportFragmentManager().beginTransaction().remove(Objects.requireNonNull(getSupportFragmentManager().findFragmentById(R.id.frameLay6))).commit();
            }
            else if(i == 6){
                getSupportFragmentManager().beginTransaction().remove(Objects.requireNonNull(getSupportFragmentManager().findFragmentById(R.id.frameLay7))).commit();
            }

        }
    }


    private void cargarFragments(String pais) {

        listForFragments = new ListadoResultados();

        resultadosPais = (listForFragments.devolverPais(pais));

        System.out.println(resultadosPais.size());


        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        for(int i = 0; i < resultadosPais.size();i++) {


            if(i == 0){
                ft.add(R.id.frameLay1, PartidoFragment.newInstance(resultadosPais.get(i).getFecha(), resultadosPais.get(i).getFase(), resultadosPais.get(i).getEquipo1(),
                        resultadosPais.get(i).getGoles1(), resultadosPais.get(i).getEquipo2(), resultadosPais.get(i).getGoles2()));
                ft.addToBackStack(null);

            }
            else if(i == 1){
                ft.add(R.id.frameLay2, PartidoFragment.newInstance(resultadosPais.get(i).getFecha(), resultadosPais.get(i).getFase(), resultadosPais.get(i).getEquipo1(),
                        resultadosPais.get(i).getGoles1(), resultadosPais.get(i).getEquipo2(), resultadosPais.get(i).getGoles2()));

                ft.addToBackStack(null);

            }
            else if(i == 2){
                ft.add(R.id.frameLay3, PartidoFragment.newInstance(resultadosPais.get(i).getFecha(), resultadosPais.get(i).getFase(), resultadosPais.get(i).getEquipo1(),
                        resultadosPais.get(i).getGoles1(), resultadosPais.get(i).getEquipo2(), resultadosPais.get(i).getGoles2()));

                ft.addToBackStack(null);

            }
            else if(i == 3){
                ft.add(R.id.frameLay4, PartidoFragment.newInstance(resultadosPais.get(i).getFecha(), resultadosPais.get(i).getFase(), resultadosPais.get(i).getEquipo1(),
                        resultadosPais.get(i).getGoles1(), resultadosPais.get(i).getEquipo2(), resultadosPais.get(i).getGoles2()));


                ft.addToBackStack(null);

            }
            else if(i == 4){
                ft.add(R.id.frameLay5, PartidoFragment.newInstance(resultadosPais.get(i).getFecha(), resultadosPais.get(i).getFase(), resultadosPais.get(i).getEquipo1(),
                        resultadosPais.get(i).getGoles1(), resultadosPais.get(i).getEquipo2(), resultadosPais.get(i).getGoles2()));

                ft.addToBackStack(null);

            }
            else if(i == 5){
                ft.add(R.id.frameLay6, PartidoFragment.newInstance(resultadosPais.get(i).getFecha(), resultadosPais.get(i).getFase(), resultadosPais.get(i).getEquipo1(),
                        resultadosPais.get(i).getGoles1(), resultadosPais.get(i).getEquipo2(), resultadosPais.get(i).getGoles2()));

                ft.addToBackStack(null);

            }
            else if(i == 6){
                ft.add(R.id.frameLay7, PartidoFragment.newInstance(resultadosPais.get(i).getFecha(), resultadosPais.get(i).getFase(), resultadosPais.get(i).getEquipo1(),
                        resultadosPais.get(i).getGoles1(), resultadosPais.get(i).getEquipo2(), resultadosPais.get(i).getGoles2()));
                ft.addToBackStack(null);

            }

        }
            ft.commit();

        }




        }

