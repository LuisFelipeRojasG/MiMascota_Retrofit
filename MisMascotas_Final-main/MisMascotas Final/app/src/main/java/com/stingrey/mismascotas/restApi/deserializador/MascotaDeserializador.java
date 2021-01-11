package com.stingrey.mismascotas.restApi.deserializador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.stingrey.mismascotas.pojo.PMascotas;
import com.stingrey.mismascotas.restApi.JsonKeys;
import com.stingrey.mismascotas.restApi.model.MascotaResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MascotaDeserializador implements JsonDeserializer<MascotaResponse> {
    @Override
    public MascotaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Gson gson = new Gson();
        MascotaResponse mascotaResponse = gson.fromJson(json, MascotaResponse.class);
        JsonArray mascotaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        mascotaResponse.setpMascotas(deserializarMascotaDeJson(mascotaResponseData));
        return mascotaResponse;
    }

    //Metodo para desealizar el objeto (mascotaResponseData)
    private ArrayList<PMascotas> deserializarMascotaDeJson(JsonArray mascotaResponseData) {
        ArrayList<PMascotas> pMascotas = new ArrayList<>();
        for (int i = 0; i < mascotaResponseData.size(); i++) {
            JsonObject mascotaResponseDataOject = mascotaResponseData.get(i).getAsJsonObject();

            String id                = mascotaResponseDataOject.get(JsonKeys.IMAGE_ID).getAsString();
            String urlFoto           = mascotaResponseDataOject.get(JsonKeys.MEDIA_URL).getAsString();
            int likes                = mascotaResponseDataOject.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt();

            //JsonObject imagenJson           = mascotaResponseDataOject.getAsJsonObject(JsonKeys.MEDIA_IMAGES);
            //JsonObject stdResolutionJson    = imagenJson.getAsJsonObject(JsonKeys.MEDIA_STANDARD_RESOLUTION);
            //JsonObject likesJson = mascotaResponseDataOject.getAsJsonObject(JsonKeys.MEDIA_LIKES);


            PMascotas pMascotasActual = new PMascotas();
            pMascotasActual.setId(id);
            //pMascotasActual.setnombreCompleto(nombreCompleto);
            pMascotasActual.seturlfoto(urlFoto);
            pMascotasActual.setLikes(likes);

            pMascotas.add(pMascotasActual);

        }

        return pMascotas;
    }

}
