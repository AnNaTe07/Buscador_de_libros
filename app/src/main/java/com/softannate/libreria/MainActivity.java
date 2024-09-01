package com.softannate.libreria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.softannate.libreria.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding; // Variable para enlazar las vistas
    private MainActivityViewModel vm; // Variable para el ViewModel

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Llamo al constructor de la superclase (AppCompatActivity)

        binding = ActivityMainBinding.inflate(getLayoutInflater()); // Inflo el diseño usando el binding
        setContentView(binding.getRoot()); // Seteo el contenido de la vista del activity usando el root del binding

        vm = new ViewModelProvider(this).get(MainActivityViewModel.class); // Creo la instancia del ViewModel

        // configuro el onClickListener para el botón de buscar
        binding.buscar.setOnClickListener(view -> {
            String libroIngresado = binding.libro.getText().toString().trim(); // obtengo el texto ingresado por el usuario
            if (libroIngresado.isEmpty()) {
                // Si el campo de texto está vacío, muestro un mensaje
                Toast.makeText(MainActivity.this, "Por favor ingrese libro a buscar", Toast.LENGTH_SHORT).show();
            } else {
                // Si se ingresó texto, llamo al método buscar del ViewModel con el libro ingresado
                vm.buscarLibro(libroIngresado);

                // observer de los resultados filtrados
                vm.getMLibro().observe(this, libros -> {
                    if (libros != null && !libros.isEmpty()) {
                        // navego a la nueva actividad si hay resultados
                        Intent intent = new Intent(MainActivity.this, Activitylibro.class);
                        intent.putExtra("libro", libroIngresado);
                        startActivity(intent);
                    } else {
                        // muestro un mensaje si no se encuentran resultados
                        Toast.makeText(MainActivity.this, "Libro no encontrado", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume(); // llamo al método en la superclase para reanudar la actividad
        binding.libro.setText(""); // limpio el campo de texto cuando la actividad se reanuda
    }
}