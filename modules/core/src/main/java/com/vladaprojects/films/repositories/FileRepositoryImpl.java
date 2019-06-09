package com.vladaprojects.films.repositories;

import com.vladaprojects.films.domain.Film;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

public class FileRepositoryImpl implements FileRepository {
    @Override
    public void saveFile(Collection<Film> collection) {
        try (PrintWriter out = new PrintWriter(new File("test.txt"))) {
            for (Film film : collection) {
                out.write(film.getName() + ";" + film.getDirector() + ";" + film.getYear()+"\n");
            }
        } catch (IOException e) {
            System.out.println("Something went wrong. Contact admin.");
        }
    }
}
