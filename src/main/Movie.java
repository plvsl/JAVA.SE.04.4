package main;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Movie implements Serializable {
    String movieName;
    List<String> actors = new LinkedList();

    public Movie(String movieName, String... actors) {
        this.movieName = movieName;
        for (int i = 0; i < actors.length; i++) {
            this.actors.add(actors[i]);
        }
    }
}
