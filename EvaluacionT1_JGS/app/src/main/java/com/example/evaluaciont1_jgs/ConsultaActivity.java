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

public class ConsultaActivity extends AppCompatActivity {

    ActivityResultLauncher<Intent> startActivityForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == SeleccionActivity.CODIGO_C1) {
                        etPais.setText(result.getData().getStringExtra(SeleccionActivity.PAIS));
                        btnSelec.setText(R.string.limpiarConsulta);
                    }
                }
            }
    );

    EditText etPais;
    Button btnSelec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        etPais = findViewById(R.id.etIntroducePais);
        btnSelec = findViewById(R.id.btnSeleccionar);

        btnSelec.setOnClickListener(view -> {

                Intent i = new Intent(ConsultaActivity.this, SeleccionActivity.class);
                i.putExtra("codigo", "C1");
                startActivityForResult.launch(i);

        });
    }
}