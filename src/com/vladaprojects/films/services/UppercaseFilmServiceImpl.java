package com.vladaprojects.films.services;

import com.vladaprojects.films.domain.Film;
import com.vladaprojects.films.repositories.FilmRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UppercaseFilmServiceImpl implements FilmService {
    private FilmRepository filmRepository;
    private List<Film> films;

    public UppercaseFilmServiceImpl(FilmRepository filmRepository, List<Film> films) {
        this.filmRepository = filmRepository;
        this.films = new ArrayList<>();
        for (Film film : films) {
            film.setName(film.getName().toUpperCase());
            this.films.add(film);
        }
    }

    @Override
    public List<Film> getListOfFilms() {
        return films;
    }

    @Override
    public void addFilm(String name, String director, String year) {
        films.add(new Film(name.toUpperCase(), director.toUpperCase(), year.toUpperCase()));
    }

    @Override
    public void renameFilm(int indexOfFilmToRemove, String name) {
        films.get(indexOfFilmToRemove).setName(name.toUpperCase());
    }

    @Override
    public void renameDirector(int indexOfFilmToRemove, String director) {
        films.get(indexOfFilmToRemove).setDirector(director.toUpperCase());
    }

    @Override
    public void changeYear(int indexOfFilmToRemove, String year) {
        films.get(indexOfFilmToRemove).setYear(year.toUpperCase());
    }

    @Override
    public void saveFile(Collection<Film> collection) {
        filmRepository.saveFile(collection);
    }

    @Override
    public void remove(int i) {
        films.remove(i);
    }

    @Override
    public boolean exists(int numberOfFilm) {
        return false;
    }
}
