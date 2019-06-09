package com.vladaprojects.films.services;

import com.vladaprojects.films.domain.Film;
import com.vladaprojects.films.services.exception.FilmNotFoundException;

import java.util.Collection;
import java.util.List;

public interface FilmService {

    List<Film> getListOfFilms();

    void addFilm(String name, String director, String year);

    void renameFilm(int indexOfFilmToRemove, String name) throws FilmNotFoundException;

    void renameDirector(int indexOfFilmToRemove, String director) throws FilmNotFoundException;

    void changeYear(int indexOfFilmToRemove, String year) throws FilmNotFoundException;

    void remove(int i) throws FilmNotFoundException;

    boolean exists(int numberOfFilm);

}
