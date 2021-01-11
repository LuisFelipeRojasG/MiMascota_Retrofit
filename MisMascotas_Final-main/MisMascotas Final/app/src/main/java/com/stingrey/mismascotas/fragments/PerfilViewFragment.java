package com.stingrey.mismascotas.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.stingrey.mismascotas.pojo.PMascotas;
import com.stingrey.mismascotas.R;
import com.stingrey.mismascotas.adaptador.PerfilAdaptador;
import com.stingrey.mismascotas.presentador.IPerfilViewFragmentPresenter;
import com.stingrey.mismascotas.presentador.PerfilViewFragmentPresenter;

import java.util.ArrayList;

public class PerfilViewFragment extends Fragment implements IPerfilViewFragment {

    private ArrayList<PMascotas> mascota;
    private RecyclerView listaMascotas;
    private IPerfilViewFragmentPresenter presenter;
    private PerfilAdaptador adaptador;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        mascota = new ArrayList<PMascotas>();
        listaMascotas = (RecyclerView) view.findViewById(R.id.rvPerfilMascota);
        presenter = new PerfilViewFragmentPresenter(this, getContext());
        generarGridLayout();
        return view;

    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager llm = new GridLayoutManager(getActivity(), 2);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public PerfilAdaptador crearAdaptador(ArrayList<PMascotas> mascotas) {

        this.mascota = mascotas;
        adaptador = new PerfilAdaptador(mascota);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(PerfilAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }

}
