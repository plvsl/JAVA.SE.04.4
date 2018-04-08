package main;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

class Main {
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
        FileOutputStream fos = new FileOutputStream("temp.out");
        try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(movies);
            oos.flush();
        }
    }

    private static void loadFromFile() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("temp.out");
        ObjectInputStream oin = new ObjectInputStream(fis);
        movies = (List)oin.readObject();
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
        getMovie(index).movieName = name;
    }

    private static void editMoviesActors(int index, String... actors) {
        getMovie(index).actors.clear();
        for (String actor : actors) {
            getMovie(index).actors.add(actor);
        }
    }

    private static void editMoviesNameAndActors(int index, String movieName, String... actors) {
        editMoviesName(index, movieName);
        editMoviesActors(index, actors);
    }

    private static void showAllMoviesAndActors() {
        for (Movie movie : movies) {
            System.out.println(movie.movieName);
            for (String actor : movie.actors) {
                System.out.println(actor);
            }
        }
    }
}