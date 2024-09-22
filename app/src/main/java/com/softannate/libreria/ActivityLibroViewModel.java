package com.softannate.libreria;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ActivityLibroViewModel extends AndroidViewModel {
    private final MutableLiveData<Libro> libro = new MutableLiveData<>();

    public ActivityLibroViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Libro> getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro.setValue(libro);
    }
}
