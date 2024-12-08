package pl.edu.uwr.loginapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class GradesAdapter extends RecyclerView.Adapter<GradesAdapter.ViewHolder> {

    private final List<gradesList.SubjectStats> data;

    public GradesAdapter(List<gradesList.SubjectStats> data) {
        this.data = data;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView subjectText, averageText, listCountText;

        public ViewHolder(View itemView) {
            super(itemView);
            subjectText = itemView.findViewById(R.id.subjectText);
            averageText = itemView.findViewById(R.id.averageText);
            listCountText = itemView.findViewById(R.id.listCountText);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grades_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        gradesList.SubjectStats item = data.get(position);
        holder.subjectText.setText(item.getSubject());
        holder.averageText.setText("Średnia: " + String.format("%.1f", item.calculateRoundedAverage())); // Zaokrąglona średnia
        holder.listCountText.setText("Liczba list: " + item.getCount());
    }


    @Override
    public int getItemCount() {
        return data.size();
    }
}
