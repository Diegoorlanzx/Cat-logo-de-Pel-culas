package dominio;

import java.util.Objects;

public class Pelicula {
    private  String nombre;
    public Pelicula(){}

    public Pelicula(String nombre){
        this.nombre= nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pelicula pelicula = (Pelicula) o;
        return Objects.equals(nombre, pelicula.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }

    @Override
    public String toString() {
        return nombre;
    }

    public static void main(String[] args) {
       // var pelicula1 = new Pelicula("batman");
        //var pelicula2 = new Pelicula("superman");
        //System.out.println(pelicula1 );
        //System.out.println(pelicula2);
    }
}
