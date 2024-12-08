package pl.edu.uwr.loginapp;

import java.util.ArrayList;
import java.util.List;

public class DataRepository {
    private static DataRepository instance; // Singleton
    private final List<ExerciseList> exerciseLists; // Lista przechowująca wygenerowane dane

    // Prywatny konstruktor - tylko jedna instancja klasy
    private DataRepository() {
        // Generowanie danych przy uruchomieniu
        exerciseLists = new ArrayList<>(DataGenerator.generateRandomData());
    }

    // Pobieranie instancji singletona
    public static DataRepository getInstance() {
        if (instance == null) {
            instance = new DataRepository();
        }
        return instance;
    }

    // Pobieranie wygenerowanych list
    public List<ExerciseList> getExerciseLists() {
        return exerciseLists;
    }
}
