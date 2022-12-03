package com.example.evaluaciont1_jgs;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SeleccionActivity extends AppCompatActivity {

    public static final int CODIGO_R1= 1;
    public static final int CODIGO_R2 = 2;
    public static final int CODIGO_C1 = 3;
    public static final String PAIS = "PAIS";
    static String codigoAcceso = "";



    Button btnAceptar;
    Button btnCancelar;
    Button btnAle;Button btnAS;Button btnArg;
    Button btnAus;Button btnBel;Button btnBra;
    Button btnCam;Button btnCan;Button btnCS;
    Button btnCR;Button btnCro;Button btnDin;
    Button btnEcu;Button btnEsp;Button btnEU;
    Button btnFra;Button btnGal;Button btnGha;
    Button btnHol;Button btnIng;Button btnIra;
    Button btnJap;Button btnMar;Button btnMex;
    Button btnPol;Button btnPor;Button btnQa;
    Button btnSen;Button btnSer;Button btnSui;
    Button btnTun;Button btnUru;

    EditText etPais;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);

        codigoAcceso = getIntent().getStringExtra("codigo");

        btnAceptar = findViewById(R.id.btnAceptar);
        btnCancelar = findViewById(R.id.btnCancelar);

        btnAle = findViewById(R.id.btnAle);btnAS = findViewById(R.id.btnAS);btnArg = findViewById(R.id.btnArg);
        btnAus = findViewById(R.id.btnAus);btnBel = findViewById(R.id.btnBel);btnBra = findViewById(R.id.btnBra);
        btnCam = findViewById(R.id.btnCam);btnCan = findViewById(R.id.btnCan);btnCS= findViewById(R.id.btnCS);
        btnCR = findViewById(R.id.btnCR);btnCro = findViewById(R.id.btnCro);btnDin = findViewById(R.id.btnDin);
        btnEcu = findViewById(R.id.btnEcu);btnEsp = findViewById(R.id.btnEsp);btnEU = findViewById(R.id.btnEU);
        btnFra = findViewById(R.id.btnFra);btnGal = findViewById(R.id.btnGal);btnGha = findViewById(R.id.btnGha);
        btnHol = findViewById(R.id.btnHol);btnIng = findViewById(R.id.btnIng);btnIra = findViewById(R.id.btnIra);
        btnJap = findViewById(R.id.btnJap);btnMar = findViewById(R.id.btnMar);btnMex = findViewById(R.id.btnMex);
        btnPol = findViewById(R.id.btnPol);btnPor = findViewById(R.id.btnPor);btnQa = findViewById(R.id.btnQa);
        btnSen = findViewById(R.id.btnSen);btnSer = findViewById(R.id.btnSer);btnSui = findViewById(R.id.btnSui);
        btnTun = findViewById(R.id.btnTun);btnUru = findViewById(R.id.btnUru);

        etPais = findViewById(R.id.etSeleccPaisSelec);

        btnAceptar.setOnClickListener(view -> comprobarSelecPais());
        btnCancelar.setOnClickListener(view -> finish());

        btnAle.setOnClickListener(view -> cogerTextButton(btnAle));btnAS.setOnClickListener(view -> cogerTextButton(btnAS));btnArg.setOnClickListener(view -> cogerTextButton(btnArg));
        btnAus.setOnClickListener(view -> cogerTextButton(btnAus));btnBel.setOnClickListener(view -> cogerTextButton(btnBel));btnBra.setOnClickListener(view -> cogerTextButton(btnBra));
        btnCam.setOnClickListener(view -> cogerTextButton(btnCam));btnCan.setOnClickListener(view -> cogerTextButton(btnCan));btnCS.setOnClickListener(view -> cogerTextButton(btnCS));
        btnCR.setOnClickListener(view -> cogerTextButton(btnCR));btnCro.setOnClickListener(view -> cogerTextButton(btnCro));btnDin.setOnClickListener(view -> cogerTextButton(btnDin));
        btnEcu.setOnClickListener(view -> cogerTextButton(btnEcu));btnEsp.setOnClickListener(view -> cogerTextButton(btnEsp));btnEU.setOnClickListener(view -> cogerTextButton(btnEU));
        btnFra.setOnClickListener(view -> cogerTextButton(btnFra));btnGal.setOnClickListener(view -> cogerTextButton(btnGal));btnGha.setOnClickListener(view -> cogerTextButton(btnGha));
        btnHol.setOnClickListener(view -> cogerTextButton(btnHol));btnIng.setOnClickListener(view -> cogerTextButton(btnIng));btnIra.setOnClickListener(view -> cogerTextButton(btnIra));
        btnJap.setOnClickListener(view -> cogerTextButton(btnJap));btnMar.setOnClickListener(view -> cogerTextButton(btnMar));btnMex.setOnClickListener(view -> cogerTextButton(btnMex));
        btnPol.setOnClickListener(view -> cogerTextButton(btnPol));btnPor.setOnClickListener(view -> cogerTextButton(btnPor));btnQa.setOnClickListener(view -> cogerTextButton(btnQa));
        btnSen.setOnClickListener(view -> cogerTextButton(btnSen));btnSer.setOnClickListener(view -> cogerTextButton(btnSer));btnSui.setOnClickListener(view -> cogerTextButton(btnSui));
        btnTun.setOnClickListener(view -> cogerTextButton(btnTun));btnUru.setOnClickListener(view -> cogerTextButton(btnUru));



    }

    private void cogerTextButton(Button btn) {
        String pais ="";
        pais = btn.getText().toString();
        etPais.setText(pais);
    }

    private void comprobarSelecPais() {
        if(etPais.length() != 0){
            String pais  = etPais.getText().toString();
            if (codigoAcceso.equals("R1")) {
                Intent i = new Intent(this,RegistroActivity.class );
                i.putExtra(PAIS,pais);
                setResult(CODIGO_R1,i);
                finish();
            }
            else if(codigoAcceso.equals("R2")){
                Intent i = new Intent(this,RegistroActivity.class );
                i.putExtra(PAIS,pais);
                setResult(CODIGO_R2,i);
                finish();
            }
            else if (codigoAcceso.equals("C1")){
                Intent i = new Intent(this,ConsultaActivity.class );
                i.putExtra(PAIS,pais);
                setResult(CODIGO_C1,i);
                finish();
            }

        }
        else Toast.makeText(this, "Debe introudcir el pais seleccionado", Toast.LENGTH_SHORT).show();
    }
}