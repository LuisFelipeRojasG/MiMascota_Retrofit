package com.stingrey.mismascotas.presentador;

import android.content.Context;

import com.stingrey.mismascotas.db.ConstructorMascotas;
import com.stingrey.mismascotas.fragments.IGaleriaViewFragment;
import com.stingrey.mismascotas.pojo.PMascotas;

import java.util.ArrayList;

public class GaleriaViewFragmentPresenter implements IGaleriaViewFragmentPresenter {

    private IGaleriaViewFragment iGaleriaViewFragment;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<PMascotas> mascotas;

    public GaleriaViewFragmentPresenter(IGaleriaViewFragment iGaleriaViewFragment, Context context) {

        this.iGaleriaViewFragment = iGaleriaViewFragment;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iGaleriaViewFragment.inicializarAdaptadorRV(iGaleriaViewFragment.crearAdaptador(mascotas));
    }
}
