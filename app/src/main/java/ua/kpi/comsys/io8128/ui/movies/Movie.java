package ua.kpi.comsys.io8128.ui.movies;

public class Movie {
    public final String title;
    public final String year;
    public final String imdbID;
    public final String type;
    public final String poster;

    public Movie(String title, String year, String imdbID, String type, String poster) {
        this.title = title;
        this.year = year;
        this.imdbID = imdbID;
        this.type = type;
        this.poster = poster;
    }
}
