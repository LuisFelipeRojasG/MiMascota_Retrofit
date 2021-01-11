package com.stingrey.mismascotas.restApi.model;

import com.stingrey.mismascotas.pojo.PMascotas;

import java.util.ArrayList;

public class MascotaResponse {

    ArrayList<PMascotas> pMascotas;

    public ArrayList<PMascotas> getpMascotas() {


        return pMascotas;
    }

    public void setpMascotas(ArrayList<PMascotas> pMascotas) {
        this.pMascotas = pMascotas;
    }

}
