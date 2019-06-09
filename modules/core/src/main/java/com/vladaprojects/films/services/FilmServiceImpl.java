package com.vladaprojects.films.services;

import com.vladaprojects.films.domain.Film;
import com.vladaprojects.films.repositories.FilmRepository;
import com.vladaprojects.films.services.exception.FilmNotFoundException;

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

    @Override
    public void addFilm(String name, String director, String year) {
        films.add(new Film(name, director, year));
    }

    @Override
    public void renameFilm(int indexOfFilmToEdit, String name) throws FilmNotFoundException {
        doesFilmExist(indexOfFilmToEdit);
        films.get(indexOfFilmToEdit).setName(name);
    }

    @Override
    public void renameDirector(int indexOfFilmToEdit, String director) throws FilmNotFoundException{
        doesFilmExist(indexOfFilmToEdit);
        films.get(indexOfFilmToEdit).setDirector(director);
    }

    @Override
    public void changeYear(int indexOfFilmToEdit, String year) throws FilmNotFoundException{
        doesFilmExist(indexOfFilmToEdit);
        films.get(indexOfFilmToEdit).setYear(year);
    }



    @Override
    public void remove(int numberOfFilmToRemove) throws FilmNotFoundException {
        doesFilmExist(numberOfFilmToRemove);
        films.remove(numberOfFilmToRemove);
    }

    @Override
    public boolean exists(int numberOfFilm) {
        return !isWrongFilmNumber(numberOfFilm);
    }

    private void doesFilmExist(int numberOfFilmToRemove) throws FilmNotFoundException {
        if (isWrongFilmNumber(numberOfFilmToRemove)) {
            throw new FilmNotFoundException(
                    String.format("Film with number %d does not exist. There are %d available films",
                            numberOfFilmToRemove + 1, films.size()));
        }
    }

    private boolean isWrongFilmNumber(int number) {
        return number < 0 || number >= films.size();
    }

    private List<Film> findFilms() {
        return filmRepository.getListOfFilms();
    }
}

