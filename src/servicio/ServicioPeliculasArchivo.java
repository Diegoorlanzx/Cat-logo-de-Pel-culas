package servicio;

import dominio.Pelicula;

import java.io.*;
import java.util.ArrayList;

public class ServicioPeliculasArchivo implements IServicioPeliculas {
    @Override
    public void eliminarPelicula(Pelicula pelicula) {
        var archivo = new File(NOMBRE_ARCHIVO);
        var nombreAEliminar = pelicula.getNombre();
        var peliculasFiltradas = new ArrayList<String>();
        boolean eliminada = false;

        try (var lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                if (linea.equalsIgnoreCase(nombreAEliminar)) {
                    eliminada = true;
                    continue; // No la agregamos a la nueva lista
                }
                peliculasFiltradas.add(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        try (var escritor = new PrintWriter(new FileWriter(archivo))) {
            for (String nombre : peliculasFiltradas) {
                escritor.println(nombre);
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
            return;
        }

        if (eliminada) {
            System.out.println("Película eliminada: " + nombreAEliminar);
        } else {
            System.out.println("Película no encontrada: " + nombreAEliminar);
        }
    }

    private final String NOMBRE_ARCHIVO = "peliculas.txt";

    public ServicioPeliculasArchivo() {
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            if (archivo.exists()) {
                System.out.println("El archivo ya existe");
            } else {
                try (var salida = new PrintWriter(new FileWriter(archivo))) {
                    System.out.println("Se ha creado el archivo");
                }
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear el archivo: " + e.getMessage());
        }
    }

    @Override
    public void listarPeliculas() {
        var archivo = new File(NOMBRE_ARCHIVO);
        try (var entrada = new BufferedReader(new FileReader(archivo))) {
            System.out.println("Listado de Películas:");
            String linea;
            while ((linea = entrada.readLine()) != null) {
                var pelicula = new Pelicula(linea);
                System.out.println(pelicula);
            }
        } catch (IOException ex) {
            System.out.println("Error al leer el archivo: " + ex.getMessage());
        }
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        try (var salida = new PrintWriter(new FileWriter(NOMBRE_ARCHIVO, true))) {
            salida.println(pelicula.getNombre());
            System.out.println("Se agregó al archivo: " + pelicula.getNombre());
        } catch (IOException e) {
            System.out.println("Ocurrió un error al agregar la película: " + e.getMessage());
        }
    }

    @Override
    public void buscarPeliculas(Pelicula pelicula) {
        var archivo = new File(NOMBRE_ARCHIVO);
        try (var entrada = new BufferedReader(new FileReader(archivo))) {
            String lineaTexto;
            int indice = 1;
            boolean encontrada = false;
            var peliculaBuscar = pelicula.getNombre();

            while ((lineaTexto = entrada.readLine()) != null) {
                if (peliculaBuscar != null && peliculaBuscar.equalsIgnoreCase(lineaTexto)) {
                    System.out.println("Película: " + lineaTexto + " encontrada - línea: " + indice);
                    encontrada = true;
                    break;
                }
                indice++;
            }

            if (!encontrada) {
                System.out.println("La película no fue encontrada.");
            }

        } catch (IOException e) {
            System.out.println("Error al buscar la película: " + e.getMessage());
        }
    }

}
