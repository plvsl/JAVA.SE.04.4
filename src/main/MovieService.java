package main;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

class MovieService {
    private static List<Movie> movies = new LinkedList<>();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Movie mv1 = new Movie("Titanic", "Leonardo Dicaprio", "Karina Pupkina");
        Movie mv2 = new Movie("Vanilla sky", "Vasya Vasilyev", "Oly Fishkina", "Valeriy Meladze");
        addMovie(mv1);
        addMovie(mv2);
        removeMovie(1);
        editMoviesNameAndActors(0, "Titanic", "Bread Hlebovich", "Mila Yovovich");
        saveToFile();
        showAllMoviesAndActors();
        loadFromFile();
    }

    private static void saveToFile() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("temp.out"))) {
            oos.writeObject(movies);
            oos.flush();
        }
    }
    
    private static List<Movie> loadFromFile() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("temp.out");
        ObjectInputStream oin = new ObjectInputStream(fis);
        return (List) oin.readObject();
    }

    private static boolean addMovie(Movie movie) {
        return movies.add(movie);
    }

    private static Movie removeMovie(int index) {
        return movies.remove(index);
    }

    private static Movie getMovie(int index) {
        return movies.get(index);
    }

    private static void editMoviesName(int index, String name) {
        getMovie(index).setMovieName(name);
    }

    private static void editMoviesActors(int index, String... actors) {
        getMovie(index).clearActors();
        for (String actor : actors) {
            getMovie(index).addActor(actor);
        }
    }

    private static void editMoviesNameAndActors(int index, String movieName, String... actors) {
        editMoviesName(index, movieName);
        editMoviesActors(index, actors);
    }

    private static void showAllMoviesAndActors() {
        for (Movie movie : movies) {
            System.out.println(movie.getMovieName());
            for (String actor : movie.getActors()) {
                System.out.println(actor);
            }
        }
    }
}