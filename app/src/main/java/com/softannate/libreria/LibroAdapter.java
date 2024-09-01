package com.softannate.libreria;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class LibroAdapter extends RecyclerView.Adapter<LibroAdapter.ViewHolderLibro> {

    private List<Libro> libros; // Lista de libros que se muestra en el RecyclerView
    private LayoutInflater inflater; // LayoutInflater para inflar los layouts

    // Constructor del adaptador
    public LibroAdapter(List<Libro> libros, LayoutInflater inflater) {
        this.libros = libros;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolderLibro onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflamos el layout para un elemento de la lista
        View view = inflater.inflate(R.layout.item, parent, false);
        return new ViewHolderLibro(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderLibro holder, int position) {
        // Obtengo el libro en la posición actual
        Libro libro = libros.get(position);
        // vinculo los datos del libro con las vistas en el ViewHolder
        holder.titulo.setText(libro.getTitulo());
        holder.autor.setText(libro.getAutor());
        holder.anio.setText(String.valueOf(libro.getAnio()));
        holder.descripcion.setText(libro.getDescripcion());
        holder.genero.setText(libro.getGenero());
        holder.portada.setImageResource(libro.getImagen());
        holder.paginas.setText(String.valueOf(libro.getPaginas()));
    }

    @Override
    public int getItemCount() {
        // devuelvo el número de elementos en la lista
        return libros.size();
    }

    // Método para actualizar la lista de libros
    public void updateLibros(List<Libro> nuevosLibros) {
        libros.clear(); // limpio la lista actual
        libros.addAll(nuevosLibros); // agrego los nuevos libros
    }

    // ViewHolder para los elementos de la lista
    public class ViewHolderLibro extends RecyclerView.ViewHolder {

        TextView titulo;
        TextView autor;
        TextView anio;
        TextView genero;
        TextView descripcion;
        TextView paginas;
        ImageView portada;

        public ViewHolderLibro(@NonNull View itemView) {
            super(itemView);
            // inicializo las vistas
            titulo = itemView.findViewById(R.id.titulo);
            autor = itemView.findViewById(R.id.autor);
            anio = itemView.findViewById(R.id.anio);
            genero = itemView.findViewById(R.id.genero);
            descripcion = itemView.findViewById(R.id.descripcion);
            paginas = itemView.findViewById(R.id.paginas);
            portada = itemView.findViewById(R.id.portada);
        }
    }
}
