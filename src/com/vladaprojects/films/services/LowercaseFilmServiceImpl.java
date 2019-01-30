package com.vladaprojects.films.services;

import com.vladaprojects.films.domain.Film;
import com.vladaprojects.films.repositories.FilmRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//todo add exception handling, "exists" logic
//todo use internal film service (create it and use in the all film service implementations)
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
    public void addFilm(String name, String director, String year) {
        films.add(new Film(name.toLowerCase(), director.toLowerCase(), year.toLowerCase()));
    }

    @Override
    public void renameFilm(int indexOfFilmToRemove, String name) {
        films.get(indexOfFilmToRemove).setName(name.toLowerCase());

    }

    @Override
    public void renameDirector(int indexOfFilmToRemove, String director) {
        films.get(indexOfFilmToRemove).setDirector(director.toLowerCase());
    }

    @Override
    public void changeYear(int indexOfFilmToRemove, String year) {
        films.get(indexOfFilmToRemove).setYear(year.toLowerCase());
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
