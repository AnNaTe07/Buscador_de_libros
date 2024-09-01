package com.softannate.libreria;

import android.annotation.SuppressLint;
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

    private ActivityLibroBinding binding; // Declaro el binding para enlazar datos
    private MainActivityViewModel vm; // Declaro el view model
    private String libroNombre; // Variable para almacenar el nombre del libro
    private LibroAdapter adaptador; // Adaptador para el RecyclerView
    private ArrayList<Libro> libros; // Lista para almacenar los libros

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libro);

        // inflo el layout y configuro el binding
        binding = ActivityLibroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // obtengo el nombre del libro de los extras del Intent
        libroNombre = getIntent().getStringExtra("libro");

        // inicializo la lista de libros
        libros = new ArrayList<>();

        // Configuro el RecyclerView
        setupRecyclerView();

        // Obtengo el ViewModel
        vm = new ViewModelProvider(this).get(MainActivityViewModel.class);

        // realizo la búsqueda
            vm.buscarLibro(libroNombre);

        // Obtengo el ViewModel y observo los cambios en la lista de libros
        vm.getMLibro().observe(this, nuevosLibros -> {
                libros.clear();
                libros.addAll(nuevosLibros);
        });
    }

    private void setupRecyclerView() {
        binding.lista.setLayoutManager(new LinearLayoutManager(this));
        adaptador = new LibroAdapter(libros, getLayoutInflater()); // Inicializo el adaptador con la lista de libros
        binding.lista.setAdapter(adaptador);
    }
}