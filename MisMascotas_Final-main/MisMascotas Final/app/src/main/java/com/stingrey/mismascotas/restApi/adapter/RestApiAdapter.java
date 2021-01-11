package com.stingrey.mismascotas.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stingrey.mismascotas.restApi.ConstantesRestApi;
import com.stingrey.mismascotas.restApi.EndpointsApi;
import com.stingrey.mismascotas.restApi.deserializador.MascotaDeserializador;
import com.stingrey.mismascotas.restApi.model.MascotaResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {

    public EndpointsApi establecerConexionRestApiInstagram(Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndpointsApi.class);
    }

    public Gson construyeGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new MascotaDeserializador());

        return gsonBuilder.create();
    }


}
