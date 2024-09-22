package com.softannate.libreria;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.softannate.libreria.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        vm = new ViewModelProvider(this).get(MainActivityViewModel.class);

        binding.buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String libroIngresado = binding.libro.getText().toString().trim();
                vm.buscarLibro(libroIngresado);
                // Mueve la navegación aquí para que suceda después de la búsqueda
                Intent intent = new Intent(MainActivity.this, Activitylibro.class);
                intent.putExtra("libro", libroIngresado);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        binding.libro.setText("");
    }
}
