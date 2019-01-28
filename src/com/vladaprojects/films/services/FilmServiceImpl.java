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
    public void addFilm(String name, String director) {
        films.add(new Film(name,director));
    }

    @Override
    public void renameFilm(int indexOfFilmToRemove, String name) {
        films.get(indexOfFilmToRemove).setName(name);
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

