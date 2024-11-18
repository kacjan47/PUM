package pl.edu.uwr.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        int score = getIntent().getIntExtra("score", 0);

        int finalScore = score * 10;

        TextView scoreTextView = findViewById(R.id.scoreTextView);
        scoreTextView.setText("Zdobyłeś " + finalScore + " punktów!");

        Button finishButton = findViewById(R.id.finishButton);
        finishButton.setOnClickListener(v -> {
            finishAffinity();
        });
    }
}
