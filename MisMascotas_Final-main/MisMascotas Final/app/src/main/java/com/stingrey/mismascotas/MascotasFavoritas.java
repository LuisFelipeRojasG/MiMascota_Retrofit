package com.stingrey.mismascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toolbar;

import com.stingrey.mismascotas.adaptador.FavoritaAdaptador;
import com.stingrey.mismascotas.adaptador.ViewPageAdapter;
import com.stingrey.mismascotas.fragments.FavoritasViewFragment;
import com.stingrey.mismascotas.pojo.PMascotas;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {

    private RecyclerView listaMascotas1;
    private ArrayList<PMascotas> mascotaFavoritas;
    private ViewPager viewPager;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        androidx.appcompat.widget.Toolbar actionBar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(actionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewPagerFavoritas);

        setViewPaper(viewPager);

    }

    public void setViewPaper(ViewPager viewPaper) {
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager());
        viewPageAdapter.agregarFragment(new FavoritasViewFragment(), "Favoritas");
        viewPaper.setAdapter(viewPageAdapter);

    }

    public boolean onCreateOptionsMenu (Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_opciones, menu);

        return true;
    }

    private void setSupportActionBar(Toolbar miActionBar1) {

        FavoritaAdaptador adaptador1 = new FavoritaAdaptador(mascotaFavoritas);
        listaMascotas1.setAdapter(adaptador1);

    }



}