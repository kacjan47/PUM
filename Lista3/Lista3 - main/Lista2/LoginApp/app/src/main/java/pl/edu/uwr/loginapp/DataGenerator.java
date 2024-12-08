package pl.edu.uwr.loginapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DataGenerator {

    // Lista dostępnych przedmiotów
    private static final List<String> subjects = Arrays.asList("Matematyka", "PUM", "Fizyka", "Elektronika", "Algorytmy");
    private static final Random random = new Random();

    public static List<ExerciseList> generateRandomData() {
        List<ExerciseList> exerciseLists = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            String subject = subjects.get(random.nextInt(subjects.size())); // Losowy przedmiot
            List<Task> tasks = generateRandomTasks(); // Losowa lista zadań
            float grade = generateRandomGrade(); // Losowa ocena od 3.0 do 5.0

            exerciseLists.add(new ExerciseList(subject, tasks, grade));
        }

        return exerciseLists;
    }

    // Generuje losową liczbę zadań (1-10) z lorem ipsum
    private static List<Task> generateRandomTasks() {
        List<Task> tasks = new ArrayList<>();
        int numberOfTasks = random.nextInt(10) + 1; // Minimalnie 1 zadanie, maksymalnie 10

        for (int i = 1; i <= numberOfTasks; i++) {
            String title = "Zadanie " + i;
            String description = generateLoremIpsum();
            int points = random.nextInt(10) + 1; // Maksymalnie 10 punktów
            tasks.add(new Task(title, description, points));
        }

        return tasks;
    }

    // Generuje lorem ipsum jako opis zadania
    private static String generateLoremIpsum() {
        String[] loremParts = {
                "Lorem ipsum dolor sit amet",
                "consectetur adipiscing elit",
                "sed do eiusmod tempor incididunt ut labore",
                "et dolore magna aliqua",
                "Ut enim ad minim veniam",
                "quis nostrud exercitation ullamco laboris",
                "nisi ut aliquip ex ea commodo consequat"
        };
        int partCount = random.nextInt(3) + 1; // Generujemy od 1 do 3 części
        StringBuilder lorem = new StringBuilder();

        for (int i = 0; i < partCount; i++) {
            lorem.append(loremParts[random.nextInt(loremParts.length)]).append(". ");
        }

        return lorem.toString();
    }

    // Generuje losową ocenę od 3.0 do 5.0 z krokiem 0.5
    private static float generateRandomGrade() {
        return 3.0f + (random.nextInt(5) * 0.5f); // Wynik w zakresie 3.0 - 5.0
    }
}
