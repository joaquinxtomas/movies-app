package org.example.service;

import org.example.domain.Movie;

import java.awt.print.PrinterGraphics;
import java.io.*;
import java.nio.BufferOverflowException;

public class MovieFileService implements IServiceMovies{

    private final String filename = "movies.txt";

    public MovieFileService() {
        File file = new File(filename);
        try{
            if(file.exists()){
                System.out.println("El archivo ya existe.\n");
            } else{
                PrintWriter exitFile = new PrintWriter(new FileWriter(file));
                exitFile.close();
                System.out.println("Se ha creado el archivo");
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }


    @Override
    public void listMovies() {
        File file = new File(filename);

        try{
            System.out.println("Listado de peliculas: ");
            BufferedReader entry = new BufferedReader(new FileReader(file));

            String line;
            line = entry.readLine();

            while(line != null){
                Movie movie = new Movie(line);
                System.out.println(movie);

                line = entry.readLine();
            }

            entry.close();
        } catch(Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
    }

    @Override
    public void addMovie(Movie movie) {
        boolean isOpen = false;

        File file = new File(filename);
        try{
            isOpen = file.exists();
            PrintWriter exitFile = new PrintWriter(new FileWriter(file, isOpen));

            exitFile.println(movie);
            exitFile.close();
            System.out.println("Se agregó al archivo la pelicula.");

        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void searchMovie(Movie movie) {
        File file = new File(filename);

        try{
            BufferedReader entry = new BufferedReader(new FileReader(file));
            String line;
            line = entry.readLine();

            int index = 1;
            boolean finded = false;

            String searchMovie = movie.getName();
            while(line!= null){
                if(searchMovie != null && searchMovie.equalsIgnoreCase(line)){
                    finded = true;
                    break;
                }

                line = entry.readLine();
                index++;
            }

            if(finded){
                System.out.println("Pelicula: " + line + "encontrada en el indice " + index);
            } else{
                System.out.println("No se encontró la pelicula " + movie.getName());
            }

            entry.close();

        }catch(Exception e){
            System.out.println("Error al buscar pelicula: " + e.getMessage());
        }
    }
}
