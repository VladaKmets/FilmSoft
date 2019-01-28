package com.vladaprojects.films.services;

import com.vladaprojects.films.domain.Film;

import java.util.Collection;
import java.util.List;

public interface FilmService {
    public List<Film> getListOfFilms();

    public void addFilm(String name, String director);

    public void renameFilm(int indexOfFilmToRemove, String name);
     public void saveFile(Collection<Film> collection);

   public void remove(int i);

}
