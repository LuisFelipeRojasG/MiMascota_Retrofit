package com.stingrey.mismascotas.fragments;

import com.stingrey.mismascotas.adaptador.PerfilAdaptador;
import com.stingrey.mismascotas.pojo.PMascotas;

import java.util.ArrayList;

public interface IPerfilViewFragment {

    public void generarGridLayout();

    public PerfilAdaptador crearAdaptador(ArrayList<PMascotas> mascotas);

    public void inicializarAdaptadorRV(PerfilAdaptador adaptador);
}
