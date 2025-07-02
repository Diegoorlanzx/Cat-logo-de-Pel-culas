package presentacion;

import dominio.Pelicula;
import servicio.IServicioPeliculas;
import servicio.ServicioPeliculasArchivo;
import servicio.ServicioPeliculasLista;

import java.util.Scanner;

public class CatalogoPeliculasApp {

    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);
        //IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasArchivo();
        while (!salir) {
            try {
                mostrarMenu();
                salir = ejecutarOpciones(consola, servicioPeliculas);
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
            System.out.println("\n");
        }
    }

    private static void mostrarMenu() {
        System.out.println("""
                *** Catálogo de Películas ***
                1. Agregar Película
                2. Listar Películas
                3. Buscar Película
                4. Eliminar
                5. Salir
                """);
    }

    // Método pendiente de implementar
    private static boolean ejecutarOpciones(Scanner consola, IServicioPeliculas servicioPeliculas) {
        // Implementación aquí
        var opcion = Integer.parseInt(consola.nextLine());
       var salir = false;
       switch (opcion){
           case 1 -> {
               System.out.println("Introduce el nombre de la pelicula");
               var nombrepelicula = consola.nextLine();
               servicioPeliculas.agregarPelicula(new Pelicula(nombrepelicula));
;           }
           case 2 -> {
               servicioPeliculas.listarPeliculas();
           }
           case 3 -> {
               System.out.println("Introduce el nombre de la pelicula a buscar");
               var buscarPelicula = consola.nextLine();
               servicioPeliculas.buscarPeliculas(new Pelicula(buscarPelicula));
           }
           case 4 -> {
               System.out.println("Introduce el nombre de la película a eliminar:");
               var nombreEliminar = consola.nextLine();
               servicioPeliculas.eliminarPelicula(new Pelicula(nombreEliminar));
           }

           case 5 -> {
               System.out.println("Hasta pronto");
               salir = true;
           }
           default -> System.out.println("Opcion no reconocida : " + opcion);
       }
       return salir;
    }
}

