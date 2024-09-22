package com.softannate.libreria;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softannate.libreria.databinding.ActivityLibroBinding;

import java.util.ArrayList;
import java.util.List;

public class Activitylibro extends AppCompatActivity {
    private ActivityLibroBinding binding;
    private LibroAdapter adaptador;
    private ArrayList<Libro> libros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLibroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        libros = new ArrayList<>();
        setupRecyclerView();

        String libroNombre = getIntent().getStringExtra("libro");
        MainActivityViewModel vm = new ViewModelProvider(this).get(MainActivityViewModel.class);
        vm.buscarLibro(libroNombre);

        vm.getMLibro().observe(this, nuevosLibros -> {
            libros.clear();
            libros.addAll(nuevosLibros);
            adaptador.notifyDataSetChanged();
        });
    }

    private void setupRecyclerView() {
        binding.lista.setLayoutManager(new LinearLayoutManager(this));
        adaptador = new LibroAdapter(libros, getLayoutInflater());
        binding.lista.setAdapter(adaptador);
    }
}
