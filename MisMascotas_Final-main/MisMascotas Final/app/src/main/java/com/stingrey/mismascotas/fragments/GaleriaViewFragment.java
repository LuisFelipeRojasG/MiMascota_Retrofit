package com.stingrey.mismascotas.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stingrey.mismascotas.pojo.PMascotas;
import com.stingrey.mismascotas.R;
import com.stingrey.mismascotas.adaptador.GaleriaAdaptor;
import com.stingrey.mismascotas.presentador.IGaleriaViewFragmentPresenter;
import com.stingrey.mismascotas.presentador.GaleriaViewFragmentPresenter;


import java.util.ArrayList;

public class GaleriaViewFragment extends Fragment implements IGaleriaViewFragment {

    private ArrayList<PMascotas> mascota;
    private RecyclerView listaMascotas;
    private IGaleriaViewFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_galeria, container, false);

        //Se usara despues de organizar los Fragmnets
        listaMascotas = (RecyclerView) view.findViewById(R.id.rvGaleriaMascota);
        presenter = new GaleriaViewFragmentPresenter(this, getContext());
        generarGridLayout();
        return view;
    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager llm = new GridLayoutManager(getActivity(), 3);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public GaleriaAdaptor crearAdaptador(ArrayList<PMascotas> mascotas) {
        this.mascota = mascotas;
        GaleriaAdaptor adaptador = new GaleriaAdaptor(mascota);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(GaleriaAdaptor adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}