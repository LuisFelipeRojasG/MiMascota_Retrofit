package com.stingrey.mismascotas;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetalleMascota extends AppCompatActivity {

    private static final String KEY_EXTRA_URL = "url";
    private static final String KEY_EXTRA_LIKES = "like";
    private ImageView ivImagenDetalleMascota;
    private TextView tvLikesPerfil;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_mascota);

        Bundle extras = getIntent().getExtras();
        String url = extras.getString(KEY_EXTRA_URL);
        int likes = extras.getInt(KEY_EXTRA_LIKES);

        ivImagenDetalleMascota = (ImageView) findViewById(R.id.ivImagenDetalleMascota);
        tvLikesPerfil = (TextView) findViewById(R.id.tvLikesPerfil);

    }

}
