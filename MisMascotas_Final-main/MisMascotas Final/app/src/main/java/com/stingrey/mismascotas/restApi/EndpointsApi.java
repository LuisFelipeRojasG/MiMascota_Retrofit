package com.stingrey.mismascotas.restApi;

import com.stingrey.mismascotas.restApi.model.MascotaResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndpointsApi {

    @GET(ConstantesRestApi.URL_KEY_GET_MEDIA_USER)
    Call<MascotaResponse>getRecentMedia();

}
