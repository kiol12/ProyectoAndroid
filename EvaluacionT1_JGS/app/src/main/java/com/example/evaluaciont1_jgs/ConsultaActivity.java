package com.example.evaluaciont1_jgs;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.example.evaluaciont1_jgs.datos.ListadoResultados;
import com.example.evaluaciont1_jgs.datos.Resultado;

import java.util.ArrayList;

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
                        cargarFragments(pais);
                    }
                }
            }
    );

    ListadoResultados listForFragments;

    EditText etPais;
    Button btnSelec;

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


        btnSelec.setOnClickListener(view -> {

                Intent i = new Intent(ConsultaActivity.this, SeleccionActivity.class);
                i.putExtra("codigo", "C1");
                startActivityForResult.launch(i);

        });
    }


    private void cargarFragments(String pais) {

        listForFragments = new ListadoResultados();

        listForFragments.add(listForFragments.devolverPais(pais));


        System.out.println(listForFragments.size());


    }
}