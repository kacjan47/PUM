package pl.edu.uwr.loginapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.ViewHolder> {

    private final List<ExerciseList> taskLists;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(ExerciseList item);
    }

    public TaskListAdapter(List<ExerciseList> taskLists, OnItemClickListener listener) {
        this.taskLists = taskLists;
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView subjectText, gradeText, taskCountText;

        public ViewHolder(View itemView) {
            super(itemView);
            subjectText = itemView.findViewById(R.id.subjectText);
            gradeText = itemView.findViewById(R.id.gradeText);
            taskCountText = itemView.findViewById(R.id.taskCountText);
        }

        public void bind(ExerciseList item, OnItemClickListener listener) {
            itemView.setOnClickListener(v -> listener.onItemClick(item));
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ExerciseList item = taskLists.get(position);
        holder.subjectText.setText(item.getSubject());
        holder.gradeText.setText("Ocena: " + String.format("%.1f", item.getGrade())); // Pobieranie oceny z listy
        holder.taskCountText.setText("Liczba zadań: " + item.getTasks().size()); // Liczba zadań w liście
        holder.bind(item, listener);
    }

    @Override
    public int getItemCount() {
        return taskLists.size();
    }
}
