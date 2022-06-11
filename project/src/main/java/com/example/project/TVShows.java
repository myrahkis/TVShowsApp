package com.example.project;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TVShows {
    private SimpleStringProperty name;
    private SimpleIntegerProperty year;
    private SimpleStringProperty genre;

    public TVShows(String name, int year, String genre) {
        this.name = new SimpleStringProperty(name);
        this.year = new SimpleIntegerProperty(year);
        this.genre = new SimpleStringProperty(genre);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public int getYear() {
        return year.get();
    }

    public void setYear(int year) {
        this.year = new SimpleIntegerProperty(year);
    }

    public String getGenre() {
        return genre.get();
    }

    public void setGenre(String genre) {
        this.genre = new SimpleStringProperty(genre);
    }


}
