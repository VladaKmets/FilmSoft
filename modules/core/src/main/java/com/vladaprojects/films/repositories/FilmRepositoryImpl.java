package com.vladaprojects.films.repositories;

import com.vladaprojects.films.domain.Film;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FilmRepositoryImpl implements FilmRepository {

    @Override
    public List<Film> getListOfFilms() {
        List<Film> films = new ArrayList<>();

        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("test.txt");
            bufferedReader = new BufferedReader(fileReader);
            String sCurrentLine;
            while ((sCurrentLine = bufferedReader.readLine()) != null) {
                String[] filmData = sCurrentLine.split(";");
                films.add(new Film(filmData[0], filmData[1], filmData[2]));
            }
        } catch (IOException e) {
            System.out.println("Something went wrong. Contact admin.");
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }

            } catch (IOException e) {
                System.out.println("Something went wrong. Contact admin.");
            }
        }

        return films;
    }

    @Override
    public void addFilm() {

    }

    @Override
    public void removeFilm() {

    }

    @Override
    public void renameFilm() {

    }

}


