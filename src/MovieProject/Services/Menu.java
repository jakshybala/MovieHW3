package MovieProject.Services;

import MovieProject.Model.Movie;
import MovieProject.MyExceptions.NoMovieException;

import java.util.List;
import java.util.Scanner;

public class Menu {

    Operation operation = new Operation();
    SortMovie sortMovie = new SortMovie();
    Scanner enterName = new Scanner(System.in);

    public void firtMenu() {
        operation.allMovie();
    }

    public void secondMenu() {

        try {
            System.out.println("Enter Movie name: ");
            String movieName = enterName.nextLine();
            Movie findedMovie = operation.searchMovieName(movieName);
            System.out.println(findedMovie);

        } catch (
                NoMovieException movieException) {

            System.out.println(movieException.getMessage());
        }

    }
    public void searchByCastMenu() {
        try {
            System.out.println("Enter Actor name: ");
            String actorName = enterName.nextLine();
            List<Movie> findedActor = operation.searchByCast(actorName);
            System.out.println(findedActor);

        } catch (
                NoMovieException movieException) {

            System.out.println(movieException.getMessage());
        }


    }
    public void searchByDirectorName() {
        try {
            System.out.println("Enter Director name: ");
            String directorName = enterName.nextLine();
            Movie findedDirector = operation.seacrByDrirectorName(directorName);
            System.out.println(findedDirector);

        } catch (
                NoMovieException movieException) {

            System.out.println(movieException.getMessage());
        }
    }
    public void searchByYear() {
        try {
            System.out.println("Enter Movie Year: ");
            int year = Integer.parseInt(enterName.nextLine());
            Movie moviesYear = operation.searchByYear(year);
            System.out.println(moviesYear);

        } catch (
                NoMovieException movieException) {
            System.out.println(movieException.getMessage());
        }

    }
    public void searchByActorName() {
        try {
            System.out.println("Enter Actor Name: ");
            String actorName = enterName.nextLine();
            List<Movie> actorNameMovie = operation.searchByActorName(actorName);
            System.out.println(actorNameMovie);

        } catch (
                NoMovieException movieException) {
            System.err.println("No Movie by that actor Name!!!");
        }

    }

    public void sortMenu() {
        while (true) {
            System.out.println("Choose operation: ");
            System.out.println(
                            "1 - > Sort by -------> Name\n" +
                            "2 - > Sort by -------> Year\n" +
                            "3 - > Sort by -------> Director\n" +
                            "4 - > Back to Main Menu\n"
            );
            Scanner enterOperation = new Scanner(System.in);
            int comand = Integer.parseInt(enterOperation.nextLine());
            switch (comand) {
                case 1:
                    sortMovie.sortByMovieName();
                    break;
                case 2:
                    sortMovie.sortByYear();
                    break;
                case 3:
                    sortMovie.sortByDirector();
                    break;
                case 4:
                    Menu menu = new Menu();
            }
        }
    }

    public Menu() {
        while (true) {
            try {
            System.out.println();
            System.out.println("<------------------Welcome----------------->");
            System.out.println("Chose command: ");
            System.out.println(
                            "           1 - > All Movies \n" +
                            "           2 - > Search Movie by name\n" +
                            "           3 - > Sort movie by: \n" +
                            "           4 - > Search by Actor: \n" +
                            "           5 - > Search by Director: \n" +
                            "           6 - > Search by movie`s Year: \n" +
                            "           7 - > Search by Actor name: \n" +
                            "           8 - > Exit \n");
            System.out.println("<----------------Cinematica--------------->");
//            Scanner enterCommand = new Scanner(System.in);
            int commands = Integer.parseInt(enterName.nextLine());

            switch (commands) {
                case 1:
                    firtMenu();
                    break;
                case 2:
                    secondMenu();
                    break;
                case 3:
                    sortMenu();
                    break;
                case 4:
                    searchByCastMenu();
                    break;
                case 5:
                    searchByDirectorName();
                    break;
                case 6:
                    searchByYear();
                    break;
                case 7:
                    searchByActorName();
                    break;

                case 8:
                    System.exit(0);
                default:
                    System.err.println("Please Retype Right command !!!");
                    break;

            }

            }catch (NumberFormatException exception) {
                System.err.println("Try again !!! Enter Right type of Require Data :( \n" +
                        "If you In Menu Choose: from 1 to 9\n" +
                        "Incorrect input: an integer is required: " );
            }
        }
    }
}
