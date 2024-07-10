package com.alura.desafio.principal;

import com.alura.desafio.model.Cancion;
import com.alura.desafio.model.Cantante;
import com.alura.desafio.repository.CantanteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private CantanteRepository repositorio;
    private Cancion cancion;

    public Principal(CantanteRepository repository) {
        this.repositorio = repository;
    }

    Scanner teclado = new Scanner(System.in);
    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Registrar datos del cantante 
                    2 - Registrar datos de canciones
                    3 - Buscar canciones por cantantes
                                  
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    crearCantante();
                    break;
                case 2:
                    crearCancion();
                    break;
                case 3:
                    mostrarCancionPorCantantes();
                    break;

                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }

    private void crearCantante(){
        System.out.println("Ingresa nombre del cantante");
        var nombre = teclado.nextLine();
        Cantante cantante = new Cantante(nombre);
        repositorio.save(cantante);
        System.out.println(cantante.getNombre());
    }
    private void crearCancion(){
        System.out.println("¿Cual es el nombre de la cancion?");
        var nombre = teclado.nextLine();
        System.out.println("¿Cual es el genero musical?");
        System.out.println("""
                Hay los siguientes generos
                "Baladas"
                "Perreo"
                "Soft"
                "Bailable"
                "Vallenato"
                """);
        var genero = teclado.nextLine();
        List<Cancion> canciones = new ArrayList<>();
        canciones.add(new Cancion(nombre, genero));
        System.out.println("¿Cual es el autor musical?");
        var nombreCantante = teclado.nextLine();
        Cantante busquedaCantante = repositorio.findByNombreContainingIgnoreCase(nombreCantante);
        System.out.println(busquedaCantante.getNombre());
        busquedaCantante.setCanciones(canciones);
        repositorio.save(busquedaCantante);

    }

    public void mostrarCancionPorCantantes(){
        System.out.println("Cantante de preferencia");
        var nombreCantante = teclado.nextLine();
        Cantante busquedaCantante = repositorio.findByNombreContainingIgnoreCase(nombreCantante);
        List<Cancion> listaDeCanciones = repositorio.CancionesPorCantante(busquedaCantante);
        listaDeCanciones.forEach(t-> System.out.println("Nombre Cancion: "+ t.getNombre() + "Cantada por:" + t.getCantante().getNombre()));

    }


}
