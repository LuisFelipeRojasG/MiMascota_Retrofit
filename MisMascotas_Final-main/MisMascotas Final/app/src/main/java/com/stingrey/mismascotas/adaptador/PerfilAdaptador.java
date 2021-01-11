package com.stingrey.mismascotas.adaptador;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.stingrey.mismascotas.DetalleMascota;
import com.stingrey.mismascotas.pojo.PMascotas;
import com.stingrey.mismascotas.R;

import java.util.ArrayList;

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.MascotaViewHolder>{
    
    private ArrayList<PMascotas> mascotas;
    private Activity activity;

    public PerfilAdaptador(ArrayList<PMascotas> mascotas){

        this.mascotas = mascotas;
    }

   //Inflar el layout y lo pasará al viewHolder para que obtenga los views
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_mascotas, parent, false);
        return new MascotaViewHolder(v);
    }

    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {

        PMascotas miMascota = mascotas.get(position);

        //mascotaViewHolder.ivImagenMascota.s(miMascota.geturlfoto().toString());
        //mascotaViewHolder.tvNombrePerro.setText(miMascota.getNombre());
        mascotaViewHolder.tvNumeroHueso.setText(String.valueOf(miMascota.getLikes()));

        Picasso.get()
                .load(miMascota.geturlfoto())
                .into(mascotaViewHolder.ivImagenMascota);

        mascotaViewHolder.ivImagenMascota.setOnClickListener((v) -> {

            Intent intent = new Intent(activity, DetalleMascota.class);
            intent.putExtra("url", miMascota.geturlfoto());
            intent.putExtra("likes", miMascota.getLikes());
            activity.startActivity(intent);

        });



        /*mascotaViewHolder.ivHuesoBlanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Te gusta " + miMascota.getNombre(),
                        Toast.LENGTH_SHORT).show();

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(v.getContext());
                constructorMascotas.darLikeMascota(miMascota);

                mascotaViewHolder.tvNumeroHueso.setText(String.valueOf(constructorMascotas.obtenerLikesMascotas(miMascota)));
            }
        });*/

    }

    //Cantidad de elementos que contiene la lista
    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivImagenMascota;
        //private TextView tvNombrePerro;
        //private ImageView ivHuesoBlanco;
        private TextView tvNumeroHueso;

        public MascotaViewHolder(@NonNull View itemView) {
                super(itemView);

                ivImagenMascota   = (ImageView) itemView.findViewById(R.id.ivImagenMascotaCV);
                //tvNombrePerro     = (TextView) itemView.findViewById(R.id.tvNombrePerroCV);
                //ivHuesoBlanco     = (ImageView) itemView.findViewById(R.id.ivHuesoBlancoCV);
                tvNumeroHueso     = (TextView) itemView.findViewById(R.id.tvNumeroHuesoCV);

        }

    }

}
