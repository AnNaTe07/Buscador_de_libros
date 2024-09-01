package com.softannate.libreria;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;


public class MainActivityViewModel extends AndroidViewModel {

    private final MutableLiveData<ArrayList<Libro>> mLibro = new MutableLiveData<>();
    private final ArrayList<Libro> libros = new ArrayList<>();

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        cargarLibros(); // Carga los libros en el constructor
    }

    public LiveData<ArrayList<Libro>> getMLibro() {
        return mLibro;
    }

    // Método para buscar libros
    public void buscarLibro(String query) {
        ArrayList<Libro> librosFiltrados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getTitulo().toLowerCase().contains(query.toLowerCase())) {
                librosFiltrados.add(libro);
            }
        }
        mLibro.setValue(librosFiltrados);
    }


    public void cargarLibros() {
        libros.add(new Libro("Nexus", "Harari, Yuval Noah", "608 páginas", 2024, "Humanidades", R.drawable.nexus, "Una breve historia de las redes de información desde la Edad de Piedra hasta la IA.\n" +
                "El esperado nuevo libro de Yuval Noah Harari, uno de los pensadores más innovadores, interesantes y clarividentes de la actualidad, y autor de Sapiens, el fenómeno literario global que ha cautivado a millones de lectores."));
        libros.add(new Libro("Globalismo", "Agustin Laje", "592 páginas", 2024, "Derecho y ciencias sociales", R.drawable.globalismo, "En Globalismo: Ingeniería social y control total en el siglo XXI; el autor best seller Agustín Laje desafía las narrativas convencionales y proporciona a los lectores una comprensión más profunda de los nuevos mecanismos de dominación global designados para controlar a los seres humanos. El poder es una bestia que va mudando sus formas y sus mecanismos a lo largo del tiempo. Cada época registra modalidades aplastantes del poder de distinta índole. En el siglo XVIII; por ejemplo; al poder que aplastaba se le llamó ¿despotismo¿. En el siglo XIX se alertó sobre el peligro de la ¿tiranía de la mayoría¿; hacia adentro; y el ¿imperialismo¿ hacia afuera. En el siglo XX; la desmesura del poder tomó el nombre de ¿totalitarismo¿; y llegó a despertar la más oscura imaginación de los escritores de distopías; tales como George Orwell; Aldous Leonard Huxley o Ray Douglas Bradbury. Hoy; nuestro siglo XXI enfrenta una nueva modalidad aplastante del poder con nombre propio: Globalismo.  "));
        libros.add(new Libro("La Felicidad, más allá de la ilusión", "Gabriel Rolón", "392 páginas", 2023, "Psicologia", R.drawable.lafelicidad, "Como imposible y como quimera; como fin y también como imperativo; la idea de la felicidad nos interpela más que nunca en los tiempos que corren. '¿Cómo ser felices?'; esa sentencia que nos sobrevuela como mandato del mundo moderno se impuso para encandilarnos y hacernos perder de vista aquella que debería ser la pregunta nodal: '¿Qué es la felicidad?'.En su nuevo libro; Gabriel Rolón nos propone desandar el camino. Desarticular lugares comunes y preconceptos para poner en evidencia qué se esconde más allá de esa ilusión que se vende como panacea y no es más que una trampa. Entre el Psicoanálisis y el arte; entre la filosofía y la literatura; despliega entonces su hoja de ruta; un mapa de lecturas que van de la mitología clásica a Byung-Chul Han; pasando por Freud; Lacan; Borges; Nietzsche; Schopenhauer; Einstein; Alejandro Dolina; Ana Frank; Bertrand Russell y Comte-Sponville; entre muchas otras.Una vez más; como en sus trabajos anteriores y fiel a ese estilo que lo llevó a ser uno de los autores más leídos de las últimas décadas; Rolón nos invita a pensar a contrapelo de las modas ligeras."));
        libros.add(new Libro("Milei, una historia del presente", "Ernesto Tenemaum", "440 páginas", 2024, "Derecho y ciencias sociales", R.drawable.milei, "Durante más de un año; uno de los periodistas más respetados de la Ar-gentina se dedicó a reconstruir exhaustivamente el recorrido que transformó en una referencia política mundial a un desconocido llamado Javier Milei. En ese proceso; se encontró con confesiones públicas sobre conductas íntimas; relatos de hechos traumáticos de la infancia; discusiones apasionan-tes sobre política y economía; trifulcas violentísimas; perros que se harían muy famosos; una capacidad de liderazgo inesperada; misticismo; frustraciones y una receta para transformar al país y al mundo entero.En Milei. Una historia del presente; Ernesto Tenembaum realiza un retrato minucioso; revelador y sumamente inquietante del nuevo líder político de la Argentina y de la sociedad que se deslumbró con él. 'Este es un libro electrizante; profundo y; a la vez; didáctico. Un ejercicio honesto que no oculta la perplejidad de su autor; ni su preocupación por la manera en que el ascenso de Milei pone en cuestión el futuro de la democracia. Un esfuerzo colosal por entender y hacer entender'. MARÍA O'DONNELL"));
        libros.add(new Libro("En Agosto nos vemos", "Gabriel Garcia Marquez", "144 páginas", 2024, "Ficción y literatura", R.drawable.enagosto, "Cada mes de agosto Ana Magdalena Bach toma el transbordador hasta la isla donde está enterrada su madre para visitar la tumba en la que yace. Esas visitas acaban suponiendo una irresistible invitación a convertirse en una persona distinta durante una noche al año. Escrita en el inconfundible y fascinante estilo de García Márquez; En agosto nos vemos es un canto a la vida; a la resistencia del goce pese al paso del tiempo y al deseo femenino. Un regalo inesperado para los innumerables lectores del Nobel colombiano."));
        libros.add(new Libro("Intensamente 2, nuevas emociones", "", "96 páginas", 2024, "Infantil y juvenil", R.drawable.intensamente2, "¡El libro de la película! Una edición completa que cuenta la historia como la verás en el cine.\n" +
                "A sus trece años; Riley sigue siendo una niña alegre; pero es innegable que su vida está cambiando mucho. Mientras tanto; en el Cuartel General de su mente; Alegría y las demás\n" +
                "Emociones Centrales reciben una gran sorpresa:\n" +
                "¡cuatro Emociones nuevas llegan con sus propios planes para Riley!"));
        // Inicializar la lista filtrada con todos los libros
        mLibro.setValue(new ArrayList<>(libros));
    }
    }



