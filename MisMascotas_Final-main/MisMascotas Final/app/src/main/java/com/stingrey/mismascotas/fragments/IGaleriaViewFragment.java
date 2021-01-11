package com.stingrey.mismascotas.fragments;

import com.stingrey.mismascotas.adaptador.GaleriaAdaptor;
import com.stingrey.mismascotas.pojo.PMascotas;

import java.util.ArrayList;

public interface IGaleriaViewFragment {

    public void generarGridLayout();

    public GaleriaAdaptor crearAdaptador(ArrayList<PMascotas> mascotas);

    public void inicializarAdaptadorRV(GaleriaAdaptor adaptador);

}
