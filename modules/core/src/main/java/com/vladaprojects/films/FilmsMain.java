package com.vladaprojects.films;

import com.vladaprojects.films.domain.Film;
import com.vladaprojects.films.repositories.FilmRepository;
import com.vladaprojects.films.repositories.FilmRepositoryImpl;
import com.vladaprojects.films.services.FilmService;
import com.vladaprojects.films.services.FilmServiceImpl;
import com.vladaprojects.films.services.LowercaseFilmServiceImpl;
import com.vladaprojects.films.services.UppercaseFilmServiceImpl;
import com.vladaprojects.films.services.exception.FilmNotFoundException;

import java.util.*;

public class FilmsMain {
    public static void main(String[] args) {
        FilmRepository filmRepository = new FilmRepositoryImpl();
        FilmService filmService = new FilmServiceImpl(filmRepository);

        Scanner keyboard = new Scanner(System.in);
        while (true) {
            System.out.println("Available options:");
            System.out.println("1 - the list of all films available");
            System.out.println("2 - add a film");
            System.out.println("3 - remove a film");
            System.out.println("4 - edit the existing film");
            System.out.println("5 - uppercase all the films' names");
            System.out.println("6 - lowercase all the films' names");
            System.out.println("7 - quit the session");
            System.out.println("Choose an option");
            int menuKey = 5;
            try {
                menuKey = Integer.valueOf(keyboard.nextLine());
            } catch (NumberFormatException exception) {
                System.out.println("Sorry!There was a problem:(");
            }
            switch (menuKey) {
                case 1:
                    for (Film film : filmService.getListOfFilms()) {
                        System.out.println(film.getName() + ";" + film.getDirector() + ";" + film.getYear());
                    }
                    break;
                case 2:
                    System.out.println("You chose option 2: add a film");
                    System.out.println("Please, enter the name of a film");
                    String name = keyboard.nextLine();
                    System.out.println("Please, enter the name of a director");
                    String director = keyboard.nextLine();
                    System.out.println("Please, enter the year of a film");
                    String year = keyboard.nextLine();
                    filmService.addFilm(name, director, year);
                    break;
                case 3:
                    System.out.println("You chose option 3: remove a film");
                    System.out.println("Please, enter the position of a film to remove");
                    int indexOfFilmToRemove = Integer.valueOf(keyboard.nextLine());

                    try {
                        filmService.remove(indexOfFilmToRemove - 1);
                    } catch (FilmNotFoundException e) {
                        System.out.println("You've entered the wrong number");
                    }
                    break;
                case 4:
                    System.out.println("You chose option 4: edit the existing film");
                    System.out.println("Please, enter the position of a film to rename");
                    indexOfFilmToRemove = Integer.valueOf(keyboard.nextLine());
                    if(!filmService.exists(indexOfFilmToRemove)) {
                        System.out.println("You've entered the number out of range. Try again");
                    }else {
                        System.out.println("Please, choose what is going to be changed:");
                        System.out.println("1 - the name of a film");
                        System.out.println("2 - the director");
                        System.out.println("3 - the year");
                        int editFilmKey = 0;
                        try {
                            editFilmKey = Integer.valueOf(keyboard.nextLine());
                        } catch (NumberFormatException exception) {
                            System.out.println("Sorry!There was a problem:(");
                        }
                        switch (editFilmKey) {
                            case 1:
                                System.out.println("You chose option 1: change the name of existing film");
                                name = keyboard.nextLine();
                                try {
                                    filmService.renameFilm(indexOfFilmToRemove, name);
                                } catch (FilmNotFoundException e) {
                                    System.out.println("You've entered the wrong number of film");
                                }
                                break;
                            case 2:
                                System.out.println("You chose option 2: change the director");
                                director = keyboard.nextLine();
                                try {
                                    filmService.renameDirector(indexOfFilmToRemove, director);
                                } catch (FilmNotFoundException e) {
                                    System.out.println("You've entered the wrong number of film");
                                }
                                break;
                            case 3:
                                System.out.println("You chose option 3: change the year");
                                year = keyboard.nextLine();
                                try {
                                    filmService.changeYear(indexOfFilmToRemove, year);
                                } catch (FilmNotFoundException e) {
                                    System.out.println("You've entered the wrong number of film");
                                }
                                break;
                            default:
                                System.out.println("You've entered the number out of range. Try again");
                                break;
                        }
                    }
                    break;
                case 5:
                    filmService = new UppercaseFilmServiceImpl(filmRepository, filmService.getListOfFilms());
                    break;
                case 6:
                    filmService = new LowercaseFilmServiceImpl(filmRepository, filmService.getListOfFilms());
                    break;
                case 7:
                    System.out.println("You chose option 5: quit the session");
                    keyboard.close();
                    filmService.saveFile(filmService.getListOfFilms());
                    System.exit(1);
                    break;
                default:
                    System.out.println("You've entered the number out of range. Try again");
                    break;
            }
        }

    }


}

