package com.stingrey.mismascotas.presentador;

import android.content.Context;

import com.stingrey.mismascotas.db.ConstructorMascotas;
import com.stingrey.mismascotas.fragments.IFavoritasViewFragment;
import com.stingrey.mismascotas.pojo.PMascotas;

import java.util.ArrayList;

public class FavoritasViewFragmentPresenter implements IFavoritasViewFragmentPresenter {

    private IFavoritasViewFragment iFavoritasViewFragment;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<PMascotas> mascotas;

    public FavoritasViewFragmentPresenter(IFavoritasViewFragment iFavoritasViewFragment, Context context) {
        this.iFavoritasViewFragment = iFavoritasViewFragment;
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
        iFavoritasViewFragment.inicializarAdaptadorRV(iFavoritasViewFragment.crearAdaptador(mascotas));
    }
}
