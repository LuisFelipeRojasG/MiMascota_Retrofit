package com.stingrey.mismascotas;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ConfigCuenta extends AppCompatActivity {

    private Context context;
    private Button guardar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar_cuenta);

        guardar = (Button) findViewById(R.id.btnGuardar);

    }

    public void irMainActividad (){
        Intent intento = new Intent(this, DetalleMascota.class);
        startActivity(intento);


    }

}
