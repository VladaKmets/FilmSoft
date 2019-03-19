package com.vladaprojects.films.domain;

public class Film {
    private String name;
    private String director;
    private String year;

    private Film() {
    }

    public Film(String name, String director, String year) {
        this.name = name;
        this.director = director;
        this.year = year;

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
