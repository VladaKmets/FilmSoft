package com.vladaprojects.films.services;

import com.vladaprojects.films.domain.Film;
import com.vladaprojects.films.repositories.FilmRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LowercaseFilmServiceImpl implements FilmService {
    private FilmRepository filmRepository;
    private List<Film> films;

    public LowercaseFilmServiceImpl(FilmRepository filmRepository, List<Film> listOfFilms) {
        this.filmRepository = filmRepository;
        this.films = new ArrayList<>();
        for (Film film : listOfFilms) {
            film.setName(film.getName().toLowerCase());
            this.films.add(film);
        }
    }

    @Override
    public List<Film> getListOfFilms() {
        return films;
    }

    @Override
    public void addFilm(String name, String director) {
        films.add(new Film(name.toLowerCase(),director.toLowerCase()));
    }

    @Override
    public void renameFilm(int indexOfFilmToRemove, String name) {
        films.get(indexOfFilmToRemove).setName(name.toLowerCase());

    }

    @Override
    public void saveFile(Collection<String> collection) {
        filmRepository.saveFile(collection);
    }

    @Override
    public void remove(int i) {
        films.remove(i);
    }
}
