package com.example.project;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TVShows {
    private SimpleStringProperty name;
    private SimpleStringProperty year;
    private SimpleStringProperty genre;

    public TVShows(String name, String  year, String genre) {
        this.name = new SimpleStringProperty(name);
        this.year = new SimpleStringProperty(year);
        this.genre = new SimpleStringProperty(genre);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public String getYear() {
        return year.get();
    }

    public void setYear(String year) {
        this.year = new SimpleStringProperty(year);
    }

    public String getGenre() {
        return genre.get();
    }

    public void setGenre(String genre) {
        this.genre = new SimpleStringProperty(genre);
    }


}
