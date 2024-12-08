package pl.edu.uwr.loginapp;

import java.io.Serializable;
import java.util.List;

public class ExerciseList implements Serializable {
    private String subject; // Nazwa przedmiotu
    private List<Task> tasks; // Lista zadań
    private float grade; // Ocena listy

    public ExerciseList(String subject, List<Task> tasks, float grade) {
        this.subject = subject;
        this.tasks = tasks;
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
}
