package MovieProject.Repository;
import MovieProject.Model.Director;
import MovieProject.Model.Movie;
import MovieProject.Model.Movies;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class MovieRepository {

    private final List<Movie> movieList;
    Director director = new Director();

    public MovieRepository()  {
        Gson gson = new Gson();
        String file = "Resourse/Movie.json";
        JsonReader jsonReader = null;
        try {
            jsonReader = new JsonReader(new FileReader(file));
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
            System.err.println("Not found such file name: " + file);
        }

        Movies movies = gson.fromJson(jsonReader, Movies.class);
        movieList = movies.getMovies();

    }
    public List<Movie> getMovieList() {
        return movieList;
    }


}
