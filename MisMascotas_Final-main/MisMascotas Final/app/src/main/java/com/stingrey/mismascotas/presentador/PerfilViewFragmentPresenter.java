package com.stingrey.mismascotas.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.stingrey.mismascotas.db.ConstructorMascotas;
import com.stingrey.mismascotas.fragments.IPerfilViewFragment;
import com.stingrey.mismascotas.pojo.PMascotas;
import com.stingrey.mismascotas.restApi.EndpointsApi;
import com.stingrey.mismascotas.restApi.adapter.RestApiAdapter;
import com.stingrey.mismascotas.restApi.model.MascotaResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilViewFragmentPresenter implements IPerfilViewFragmentPresenter {

    private IPerfilViewFragment iPerfilViewFragment;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<PMascotas> mascotas;

    public PerfilViewFragmentPresenter(IPerfilViewFragment iPerfilViewFragment, Context context) {

        this.iPerfilViewFragment = iPerfilViewFragment;
        this.context = context;
        //obtenerMascotasBaseDatos();
        obtenerMediosRecientes();
    }

    @Override
    public void obtenerMediosRecientes() {

        RestApiAdapter restApiAdapter = new RestApiAdapter(); //Se conecta al servidor y hace la consulta
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent(); //Se construye el modelo desealizador

        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        Call<MascotaResponse> mascotaResponseCall = endpointsApi.getRecentMedia();

        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {

                if(response.isSuccessful()){
                    Toast.makeText(context, "Si se conecto", Toast.LENGTH_LONG).show();
                    MascotaResponse mascotaResponse = response.body();
                    mascotas = mascotaResponse.getpMascotas();
                    mostrarMascotasRV();
                }

            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "¡Algo pasó con la conexión! Intenta de Nuevo", Toast.LENGTH_LONG).show();
                Log.e("Fallo la conexión", t.getMessage());
            }
        });

    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iPerfilViewFragment.inicializarAdaptadorRV(iPerfilViewFragment.crearAdaptador(mascotas));
    }

}
