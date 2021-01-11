package com.stingrey.mismascotas.menuOpciones;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.stingrey.mismascotas.R;

import javax.mail.Session;

public class Activity_Config_Cuenta extends AppCompatActivity {

    // Se crean las variables
    private EditText etNombreUsuario;
    private Button bGuardar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar_cuenta);

        androidx.appcompat.widget.Toolbar contactoBar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.configCuentaBar);
        setSupportActionBar(contactoBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Se inicializan las variables
        etNombreUsuario = findViewById(R.id.tfeNombreUsuario);
        bGuardar = findViewById(R.id.btnGuardar);

        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }
        });

    }

}
