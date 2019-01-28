package com.vladaprojects.cats.repositories;

import java.util.List;

public interface CatsRepository {
    public List<String> getListOfCats();
    public void addCat(String name);
    public void removeCat(int i);
    public void renameCat(int i, String name);


}
