package com.vladaprojects.films.services;

import com.vladaprojects.films.domain.Film;
import com.vladaprojects.films.repositories.FilmRepository;
import com.vladaprojects.films.repositories.FilmRepositoryImpl;

import java.util.Collection;
import java.util.List;

public class FilmServiceImpl implements FilmService {

    private FilmRepository filmRepository;
    private List<Film> films;

    private FilmServiceImpl() {
    }

    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
        films = findFilms();
    }


    @Override
    public List<Film> getListOfFilms() {
        return films;
    }

    //this you will do by yourself
    @Override
    public void addFilm(String name, String director, String year) {
        films.add(new Film(name,director,year));
    }

    @Override
    public void renameFilm(int indexOfFilmToRemove, String name) {
        films.get(indexOfFilmToRemove).setName(name);
    }

    @Override
    public void renameDirector(int indexOfFilmToRemove, String director) {
        films.get(indexOfFilmToRemove).setDirector(director);
    }

    @Override
    public void changeYear(int indexOfFilmToRemove, String year) {
        films.get(indexOfFilmToRemove).setYear(year);
    }

    @Override
    public void saveFile(Collection<Film> collection) {
        filmRepository.saveFile(collection);
    }

    @Override
    public void remove(int i) {
        films.remove(i);
    }

    private List<Film> findFilms(){
        return filmRepository.getListOfFilms();
    }
}

