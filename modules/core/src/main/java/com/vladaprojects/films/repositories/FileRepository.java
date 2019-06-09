package com.vladaprojects.films.repositories;

import com.vladaprojects.films.domain.Film;

import java.util.Collection;

public interface FileRepository {
     void saveFile(Collection<Film> collection);
}
