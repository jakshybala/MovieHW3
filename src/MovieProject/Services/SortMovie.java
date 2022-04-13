package MovieProject.Services;
import MovieProject.Model.Movie;
import MovieProject.Repository.MovieRepository;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortMovie {

    private final MovieRepository movieRepository = new MovieRepository();
    Scanner enterSortType = new Scanner(System.in);


    public void sortByMovieName() {
        System.out.println(
                "1 - > ASC\n" +
                        "2 - > DESC\n" +
                        "3 - > Back to Main Menu"
        );
        try {
            int typeSort = Integer.parseInt(enterSortType.nextLine());
            if (typeSort == 1) {
                movieRepository.getMovieList().stream().sorted(Comparator.comparing(Movie::getName)).forEach(System.out::println);
            } else if (typeSort == 2) {
                movieRepository.getMovieList().stream().sorted(Comparator.comparing(Movie::getName).reversed()).forEach(System.out::println);
            } else if (typeSort == 3) {
                Menu menu = new Menu();
            }

        } catch (NumberFormatException exception) {
            System.err.println("Try again !!! Choose only: 1 , 2 , 3\n" +
                    "           Incorrect input: an integer is required " + enterSortType.nextLine());

        }
    }

    public void sortByYear() {

        System.out.println(
                "1 - > ASC\n" +
                        "2 - > DESC\n" +
                        "3 - > Back to Main Menu"
        );
        try {
            int typeSort = Integer.parseInt(enterSortType.nextLine());
            if (typeSort == 1) {
                movieRepository.getMovieList().stream().sorted(Comparator.comparing(Movie::getYear)).forEach(System.out::println);
            } else if (typeSort == 2) {
                movieRepository.getMovieList().stream().sorted(Comparator.comparing(Movie::getYear).reversed()).forEach(System.out::println);
            } else if (typeSort == 3) {
                Menu menu = new Menu();
            }

        } catch (NumberFormatException exception) {
            System.err.println("Try again !!! Choose only: 1 , 2 , 3\n" +
                    "           Incorrect input: an integer is required " + enterSortType.nextLine());


        }
    }

    public void sortByDirector() {
        System.out.println(
                "1 - > ASC\n" +
                        "2 - > DESC\n" +
                        "3 - > Back to Main Menu"
        );
        try {
            int typeSort = Integer.parseInt(enterSortType.nextLine());
            if (typeSort == 1) {
                movieRepository.getMovieList().stream()
                        .sorted(Comparator.comparing(movie -> movie.getDirector().getFullName()))
                        .forEach(movie -> System.out.println(movie.getDirector().getFullName()
                                + " : " + movie.getName() + " " + movie.getYear()));
            } else if (typeSort == 2) {

                movieRepository.getMovieList().stream()
                       .sorted((movie1, movie2) -> movie2.getDirector().getFullName().compareTo(movie1.getDirector().getFullName()) )
                        .forEach(movie -> System.out.println(movie.getDirector().getFullName()  + " : " + movie.getName() + " " + movie.getYear()) );
//                 Map<Director, List<Movie>> listMap = movieRepository.getMovieList().stream()
//                         .collect(Collectors.groupingBy(Movie::getDirector));
//
//                 listMap.forEach(((director, movies) -> {
//                     System.out.println(director.getFullName());
//
//                     movies.stream().sorted(Comparator.comparing(Director -> director.getFullName()).reversed()).forEach(System.out::println);
//                 }
//                         ));

            }

        } catch (NumberFormatException exception) {
            System.err.println("Try again !!! Choose only: 1 , 2 , 3\n" +
                    "           Incorrect input: an integer is required " + enterSortType.nextLine());


        }

    }
}
