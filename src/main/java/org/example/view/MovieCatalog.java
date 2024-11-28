package org.example.view;

import org.example.domain.Movie;
import org.example.service.IServiceMovies;
import org.example.service.MovieFileService;
import org.example.service.ServiceMoviesList;

import java.util.Scanner;

public class MovieCatalog {
    public static void main(String[] args) {
        boolean end = false;
        Scanner console = new Scanner(System.in);

        IServiceMovies serviceMovies = new MovieFileService();

        while(!end){
            try{
                menu();
                end = options(console, serviceMovies);
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println();
        }
    }

    private static void menu(){
        System.out.println("""
                *** Catalogo de peliculas ***
                1. Agregar pelicula
                2. Listar peliculas
                3. Buscar pelicula
                4. Salir
                
                Elige una opcion: 
                """);
    }

    private static boolean options(Scanner console, IServiceMovies serviceMovies){

        Integer option = Integer.parseInt(console.nextLine());
        boolean end = false;

        switch(option){
            case 1 -> {
                System.out.println("Introduce el nombre de la pelicula: ");
                String name = console.nextLine();
                serviceMovies.addMovie(new Movie(name));
            }
            case 2 -> serviceMovies.listMovies();
            case 3 -> {
                System.out.println("Introduce la pelicula a buscar: ");
                String search = console.nextLine();
                serviceMovies.searchMovie(new Movie(search));
            }
            case 4 -> {
                System.out.println("Hasta la proxima.");
                end = true;
            }
            default -> System.out.println("Opcion no valida. " + option);
        }

        return end;

    }
}