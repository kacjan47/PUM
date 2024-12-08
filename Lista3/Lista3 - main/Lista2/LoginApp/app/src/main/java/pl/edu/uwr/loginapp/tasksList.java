package pl.edu.uwr.loginapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class tasksList extends Fragment {
    private RecyclerView recyclerView;
    private TaskListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasks_list, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Pobranie danych z DataRepository
        List<ExerciseList> data = DataRepository.getInstance().getExerciseLists();

        // Adapter
        adapter = new TaskListAdapter(data, item -> {
            // Przejście do szczegółowego widoku
            Bundle bundle = new Bundle();
            bundle.putSerializable("tasks", new ArrayList<>(item.getTasks())); // Przekazanie listy zadań
            NavController navController = NavHostFragment.findNavController(this);
            navController.navigate(R.id.action_tasksList_to_taskDetailsFragment, bundle);
        });
        recyclerView.setAdapter(adapter);

        return view;
    }
}
