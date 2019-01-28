package com.vladaprojects.films.domain;

public class Film {
    private String name;
    private String director;

  //this
    private Film() {
    }

    public Film(String name, String director) {
        this.name = name;
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
