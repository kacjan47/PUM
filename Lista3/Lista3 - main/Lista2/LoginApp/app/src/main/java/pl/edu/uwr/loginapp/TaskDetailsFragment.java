package pl.edu.uwr.loginapp;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class TaskDetailsFragment extends Fragment {

    private RecyclerView recyclerView;
    private TaskDetailsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task_details, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewDetails);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Pobierz listę zadań z argumentów
        Bundle args = getArguments();
        if (args != null) {
            ArrayList<Task> tasks = (ArrayList<Task>) args.getSerializable("tasks");
            if (tasks != null) {
                adapter = new TaskDetailsAdapter(tasks);
                recyclerView.setAdapter(adapter);
            }
        }

        return view;
    }
}
