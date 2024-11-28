package org.example.service;

import org.example.domain.Movie;

import java.awt.print.PrinterGraphics;
import java.io.*;

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


    }

    @Override
    public void searchMovie(Movie movie) {

    }
}
