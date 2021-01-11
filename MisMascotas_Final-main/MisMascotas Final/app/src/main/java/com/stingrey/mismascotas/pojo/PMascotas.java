package com.stingrey.mismascotas.pojo;

public class PMascotas {

    private String id;
    private String nombreCompleto;
    private String urlfoto;
    private int likes;

    public PMascotas(String foto, String nombre, int likes){

        this.urlfoto   = foto;
        this.nombreCompleto = nombre;
        this.likes = likes;
    }
    //Segundo constructor
    public PMascotas(String foto){ this.urlfoto   = foto; }

    public PMascotas() {

    }

    public String getnombreCompleto() { return nombreCompleto; }

    public void setnombreCompleto(String nombre) { this.nombreCompleto = nombre; }

    public String geturlfoto() { return urlfoto; }

    public void seturlfoto(String foto) { this.urlfoto = foto; }

    public int getLikes() { return likes; }

    public void setLikes(int likes) { this.likes = likes; }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

}
