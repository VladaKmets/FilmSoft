package com.vladaprojects.films.services;

import com.vladaprojects.films.domain.Film;
import com.vladaprojects.films.repositories.FileRepository;

import java.util.Collection;

public class FileServiceImpl implements FileService{
    private FileRepository fileRepository;

    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }


    @Override
    public void saveFile(Collection<Film> collection) {
        fileRepository.saveFile(collection);
    }
}
