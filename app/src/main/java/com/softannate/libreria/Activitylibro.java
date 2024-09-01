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
    private MainActivityViewModel vm;
    private String libroNombre;
    private LibroAdapter adaptador;
    private ArrayList<Libro> libros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libro);

        binding = ActivityLibroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        libroNombre = getIntent().getStringExtra("libro");
        libros = new ArrayList<>();

        // Configura el RecyclerView
        setupRecyclerView();

        // Obtiene el ViewModel y observa los cambios en la lista de libros
        vm = new ViewModelProvider(this).get(MainActivityViewModel.class);

        vm.getMLibro().observe(this, nuevosLibros -> {
            if (nuevosLibros != null && !nuevosLibros.isEmpty()) {
                libros.clear();
                libros.addAll(nuevosLibros);

                // Maneja el caso en que no se encuentra ningún libro
                if (libros.isEmpty()) {
                    Toast.makeText(Activitylibro.this, "Libro no encontrado", Toast.LENGTH_SHORT).show();
                } else {
                    adaptador.notifyDataSetChanged(); // Actualiza el adaptador con el libro encontrado
                }
            }
        });

        // Realiza la búsqueda del libro cuando la actividad se crea
            vm.buscarLibro(libroNombre);
    }

    private void setupRecyclerView() {
        binding.lista.setLayoutManager(new LinearLayoutManager(this));
        adaptador = new LibroAdapter(libros, getLayoutInflater());
        binding.lista.setAdapter(adaptador);
    }
}
