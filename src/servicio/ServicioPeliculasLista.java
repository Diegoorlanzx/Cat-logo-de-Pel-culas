package servicio;

import dominio.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ServicioPeliculasLista implements IServicioPeliculas{
    private final List<Pelicula> peliculas;

    public  ServicioPeliculasLista(){
        this.peliculas = new ArrayList<>();
    }

    @Override
    public void listarPeliculas() {
        System.out.println("Listado De Peliculas... ");
        peliculas.forEach(System.out::println);

    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Se agrego la pelicula : " + pelicula);

    }

    @Override
    public void buscarPeliculas(Pelicula pelicula) {
        // regresar indice de la pelicuila encontrada
        var indice = peliculas.indexOf(pelicula);
        if (indice == -1)
            System.out.println("No se encontro la pelicula " + pelicula);
        else
            System.out.println("Pelicula encontrada en el indice :" + indice);

    }

    public static void main(String[] args) {
       // var pelicula1 = new Pelicula("batman");
        //var pelicula2 = new Pelicula("superman");
       // IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();

       // servicioPeliculas.agregarPelicula(pelicula1);
       // servicioPeliculas.agregarPelicula(pelicula2);

        //servicioPeliculas.buscarPeliculas(pelicula1);

    }

    @Override
    public void eliminarPelicula(Pelicula pelicula) {

    }
}
