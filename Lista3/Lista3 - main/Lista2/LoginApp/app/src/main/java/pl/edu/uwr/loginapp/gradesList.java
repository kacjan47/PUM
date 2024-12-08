package pl.edu.uwr.loginapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class gradesList extends Fragment {
    private RecyclerView recyclerView;
    private GradesAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grades_list, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewGrades);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Pobranie danych z DataRepository
        List<ExerciseList> allLists = DataRepository.getInstance().getExerciseLists();

        // Agregacja danych
        Map<String, SubjectStats> subjectStatsMap = calculateSubjectStats(allLists);

        // Przekształcenie mapy w listę
        List<SubjectStats> subjectStatsList = new ArrayList<>(subjectStatsMap.values());

        // Ustawienie adaptera
        adapter = new GradesAdapter(subjectStatsList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    // Funkcja do zliczania ilości list i średnich ocen dla każdego przedmiotu
    private Map<String, SubjectStats> calculateSubjectStats(List<ExerciseList> allLists) {
        Map<String, SubjectStats> statsMap = new HashMap<>();

        for (ExerciseList list : allLists) {
            String subject = list.getSubject();
            float listGrade = list.getGrade(); // Pobranie oceny z listy

            // Jeśli przedmiot nie istnieje w mapie, inicjalizujemy statystyki
            SubjectStats stats = statsMap.getOrDefault(subject, new SubjectStats(subject, 0, 0));
            stats.incrementCount();
            stats.addGrade(listGrade);

            // Zapisujemy zaktualizowane statystyki w mapie
            statsMap.put(subject, stats);
        }

        return statsMap;
    }

    // Klasa do przechowywania statystyk przedmiotu
    public static class SubjectStats {
        private final String subject;
        private int count; // Liczba list zadań
        private float totalGrade; // Suma średnich ocen z list

        public SubjectStats(String subject, int count, float totalGrade) {
            this.subject = subject;
            this.count = count;
            this.totalGrade = totalGrade;
        }

        public void incrementCount() {
            count++;
        }

        public void addGrade(float grade) {
            totalGrade += grade;
        }

        public String getSubject() {
            return subject;
        }

        public int getCount() {
            return count;
        }

        // Obliczanie średniej ocen
        public float calculateAverage() {
            return count == 0 ? 0 : totalGrade / count;
        }

        // Obliczanie zaokrąglonej średniej ocen
        public float calculateRoundedAverage() {
            float average = calculateAverage();
            return Math.round(average * 2) / 2.0f; // Zaokrąglenie do najbliższego 0,5
        }
    }

}
