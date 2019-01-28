package com.vladaprojects.films;

import com.vladaprojects.films.domain.Film;
import com.vladaprojects.films.repositories.FilmRepository;
import com.vladaprojects.films.repositories.FilmRepositoryImpl;
import com.vladaprojects.films.services.FilmService;
import com.vladaprojects.films.services.FilmServiceImpl;
import com.vladaprojects.films.services.LowercaseFilmServiceImpl;
import com.vladaprojects.films.services.UppercaseFilmServiceImpl;

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
            System.out.println("4 - rename the existing film");
            System.out.println("5 - uppercase all the films' names");
            System.out.println("6 - lowercase all the films' names");
            System.out.println("7 - quit the session");
            System.out.println("Choose an option");
            int myInt = 5;
            try {
                myInt = Integer.valueOf(keyboard.nextLine());
            } catch (NumberFormatException exception) {
                System.out.println("Sorry!There was a problem:(");
            }
            switch (myInt) {
                case 1:
                    //Do the same in the other operationsok
                    for (Film film: filmService.getListOfFilms()) {
                        System.out.println(film.getName());
                    }
                    break;
                case 2:
                    System.out.println("You chose option 2: add a film");
                    System.out.println("Please, enter the name of a film");
                    System.out.println("Please, enter the name of a director");
                    String name = keyboard.nextLine();
                    String director = keyboard.nextLine();
                    filmService.addFilm(name,director);
                    break;
                case 3:
                    System.out.println("You chose option 3: remove a film");
                    System.out.println("Please, enter the position of a film to remove");
                    int indexOfFilmToRemove = Integer.valueOf(keyboard.nextLine());
                    filmService.remove(indexOfFilmToRemove - 1);
                    break;
                case 4:
                    System.out.println("You chose option 4: rename the existing film");
                    System.out.println("Please, enter the position of a film to rename");
                    indexOfFilmToRemove = Integer.valueOf(keyboard.nextLine());
                    filmService.remove(indexOfFilmToRemove - 1);
                    System.out.println("Please, enter the name of a new film");
                    name = keyboard.nextLine();
                    filmService.renameFilm(indexOfFilmToRemove, name);
                    break;
                case 5:
                    filmService = new UppercaseFilmServiceImpl(filmRepository, filmService.getListOfFilms());
                    break;
                case 6:
                    filmService = new LowercaseFilmServiceImpl(filmRepository,filmService.getListOfFilms());
                    break;
                case 7:
                    System.out.println("You chose option 5: quit the session");
                    keyboard.close();
                    filmService.saveFile(filmService.getListOfFilms());
                    System.exit(1);
            }
        }

    }


}

