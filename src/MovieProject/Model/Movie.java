package MovieProject.Model;

import java.util.List;

public class Movie {
    private String name;
    private int year;
    private String description;
    private Director director;
    private List<Cast> cast;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Cast> getCast() {
        return cast;
    }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }

    public boolean containsCastByName(String castName) {
        for (Cast cast : this.getCast()) {
            if (cast.getFullName().equalsIgnoreCase(castName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Movie name is: " + getName() + "\n" +
                "Created in: " + getYear() + "\n" +
                "Descrition: " + getDescription() + "\n" +
                "Director is: " + getDirector() + "\n" +
                "Casts: " + getCast() + "\n" +
                "___________\n";
    }
}
