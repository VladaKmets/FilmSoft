package com.vladaprojects.cats.service;

import java.util.List;

public interface CatsService {
    public List<String> getListOfCats();
    public void addCat(String name);
    public void removeCat(int i);
    public void renameCat(int i, String name);

}
