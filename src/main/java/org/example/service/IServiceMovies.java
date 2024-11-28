package org.example.service;

import org.example.domain.Movie;

public interface IServiceMovies {
    public void listMovies();

    public void addMovie(Movie movie);

    public void searchMovie(Movie movie);
}
