package pl.edu.uwr.loginapp;

import java.io.Serializable;

public class Task implements Serializable {
    private String title;
    private String description;
    private int points;

    public Task(String title, String description, int points) {
        this.title = title;
        this.description = description;
        this.points = points;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPoints() {
        return points;
    }
}
