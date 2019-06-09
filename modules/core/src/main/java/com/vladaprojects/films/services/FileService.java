package com.vladaprojects.films.services;

import com.vladaprojects.films.domain.Film;

import java.util.Collection;

public interface FileService {

     void saveFile(Collection<Film> collection);
}
