package main;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Movie implements Serializable {
    private String movieName;
    private List<String> actors = new LinkedList();

    public Movie(String movieName, String... actors) {
        this.movieName = movieName;
        for (int i = 0; i < actors.length; i++) {
            this.actors.add(actors[i]);
        }
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void clearActors() {
        actors.clear();
    }

    public void addActor(String actor) {
        actors.add(actor);
    }

    public List<String> getActors() {
        return actors;
    }
}
