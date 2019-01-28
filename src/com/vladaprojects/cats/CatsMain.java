package com.vladaprojects.cats;

import com.vladaprojects.cats.repositories.CatsRepository;
import com.vladaprojects.cats.repositories.CatsRepositoryImpl;
import com.vladaprojects.cats.service.CatsService;
import com.vladaprojects.cats.service.CatsServiceImpl;

import java.util.Scanner;

public class CatsMain {
    public static void main(String[] args) {
        CatsRepository catsRepository = new CatsRepositoryImpl();
        CatsService catsService = new CatsServiceImpl(catsRepository);

        Scanner keyboard = new Scanner(System.in);
        while (true) {
            System.out.println("Available options:");
            System.out.println("1 - the list of cats");
            System.out.println("2 - add a cat");
            System.out.println("3 - remove a cat");
            System.out.println("4 - rename the existing cat");
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
                    System.out.println(catsService.getListOfCats());
                    break;
                case 2:
                    System.out.println("You chose option 2: add a cat");
                    System.out.println("Please, enter cat's name");
                    String name = keyboard.nextLine();
                    catsService.addCat(name);
                    break;
                case 3:
                    System.out.println("You chose option 3: remove a cat");
                    System.out.println("Please, enter the position of a cat to remove");
                    int indexOfFilmToRemove = Integer.valueOf(keyboard.nextLine());
                    catsService.removeCat(indexOfFilmToRemove - 1);
                    break;
                case 4:
                    System.out.println("You chose option 4: rename the existing cat");
                    System.out.println("Please, enter the position of a cat to rename");
                    indexOfFilmToRemove = Integer.valueOf(keyboard.nextLine());
                    catsService.removeCat(indexOfFilmToRemove - 1);
                    System.out.println("Please, enter a new name of a cat");
                    name = keyboard.nextLine();
                    catsService.renameCat(indexOfFilmToRemove, name);
                    break;
                case 5:
                    System.out.println("You chose option 5: quit the session");
                    keyboard.close();
                    catsService.saveFile(catsService.getListOfCats());
                    System.exit(1);
            }
        }

    }


}

