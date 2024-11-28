package org.example.service;

import org.example.domain.Movie;

import java.util.ArrayList;
import java.util.List;

public class ServiceMoviesList implements IServiceMovies{

    private final List<Movie> moviesList;

    public ServiceMoviesList() {
        this.moviesList = new ArrayList<>();
    }

    @Override
    public void listMovies() {
        System.out.println("Listado de peliculas...");
        moviesList.forEach(System.out::println);
    }

    @Override
    public void addMovie(Movie movie) {
        moviesList.add(movie);
        System.out.println("Se agregó la película correctamente.");
    }

    @Override
    public void searchMovie(Movie movie) {
        var index = moviesList.indexOf(movie);

        if(index == -1){
            System.out.println("La pelicula no fue encontrada.\n");
        } else {
            Movie movieFinded = moviesList.get(index);
            System.out.println(movieFinded);
        }

    }

    public static void main(String[] args) {
        var movie1 = new Movie("Batman");
        var movie2 = new Movie("Superman");

        IServiceMovies serviceMovies = new ServiceMoviesList();

        serviceMovies.addMovie(movie1);
        serviceMovies.addMovie(movie2);

        serviceMovies.listMovies();

        serviceMovies.searchMovie(movie2);

    }
}
