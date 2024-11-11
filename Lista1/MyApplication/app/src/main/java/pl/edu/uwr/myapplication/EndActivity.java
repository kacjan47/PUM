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

        // Pobierz wynik z poprzedniej aktywności
        int score = getIntent().getIntExtra("score", 0);

        // Pomnóż punkty przez 10
        int finalScore = score * 10;

        // Znajdź TextView i ustaw wynik
        TextView scoreTextView = findViewById(R.id.scoreTextView);
        scoreTextView.setText("Zdobyłeś " + finalScore + " punktów!");

        // Obsługuje kliknięcie przycisku "Zakończ"
        Button finishButton = findViewById(R.id.finishButton);
        finishButton.setOnClickListener(v -> {
            finishAffinity();  // Zamyka aplikację
        });
    }
}
