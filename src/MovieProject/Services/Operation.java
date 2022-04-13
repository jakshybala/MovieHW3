package MovieProject.Services;
import MovieProject.Model.Cast;
import MovieProject.Model.Movie;
import MovieProject.MyExceptions.NoMovieException;
import MovieProject.Repository.MovieRepository;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;


public class Operation {

    private final MovieRepository movieRepository = new MovieRepository();

    public void allMovie() {
        System.out.println(movieRepository.getMovieList());

    }

    public Movie searchMovieName(String movieName) {
        return movieRepository.getMovieList().stream().filter(movie -> movie.getName().toLowerCase()
                .contains(movieName.toLowerCase())).findFirst().orElseThrow(() ->
                new NoMovieException("Movie by that name " + movieName + " not founded"));
    }

    public List<Movie> searchByCast(String castName) {
        return movieRepository.getMovieList().stream()
                .filter(movie -> movie.getCast().stream()
                        .anyMatch(cast -> cast.getFullName().toLowerCase().contains(castName.toLowerCase()))).toList();


//                .findFirst().orElseThrow(() -> new NoMovieException("Actor by that name " + castName + " not founded"));
//
//        for (Movie movie : movieRepository.getMovieList()) {
//            List<Cast> cast = movie.getCast();
//            for (Cast c : cast) {
//                if (c.getFullName().equalsIgnoreCase(castName)) {
//                    return movie;
//                }
//            }
//        }
//
//        return null;
    }
    public Movie seacrByDrirectorName(String directorName) {
        return movieRepository.getMovieList().stream().filter(movie -> movie.getDirector()
                .getFullName().toLowerCase().contains(directorName.toLowerCase())).findFirst().orElseThrow(()
                -> new NoMovieException("No movie by: " + directorName + " that Director in List :( "));
    }

    public Movie searchByYear (int searchYear) {
         return movieRepository.getMovieList().stream().filter(movie -> movie.getYear() == searchYear)
                 .findFirst().orElseThrow(() -> new NoMovieException("No Movie in: " + searchYear + " year"));
    }
    public List<Movie> searchByActorName(String actorName) {
        return movieRepository.getMovieList().stream().filter(movie -> movie.getCast().stream()
                .anyMatch(cast -> cast.getFullName().toLowerCase().contains(actorName.toLowerCase()))).toList();
    }

}
