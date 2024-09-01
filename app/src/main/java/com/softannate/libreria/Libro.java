package com.softannate.libreria;

import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Libro  implements Serializable {
    private String titulo;
    private String autor;
    private String paginas;
    private int anio;
    private String genero;
    private int imagen;
    private String descripcion;

    public Libro(String titulo, String autor, String paginas, int anio, String genero, int imagen, String descripcion) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.anio = anio;
        this.genero = genero;
        this.imagen = imagen;
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
