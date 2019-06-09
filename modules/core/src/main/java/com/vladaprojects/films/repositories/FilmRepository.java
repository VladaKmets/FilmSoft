package com.vladaprojects.films.repositories;

import com.vladaprojects.films.domain.Film;

import java.util.Collection;
import java.util.List;

public interface FilmRepository {
    public List<Film> getListOfFilms();

    public void addFilm();

    public void removeFilm();

    public void renameFilm();
}
