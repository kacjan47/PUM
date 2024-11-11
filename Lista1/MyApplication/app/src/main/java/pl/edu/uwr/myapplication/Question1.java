package pl.edu.uwr.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class Question1 extends AppCompatActivity {

    private int score = 0;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private List<Question> questions;
    private int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question1);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        radioGroup = findViewById(R.id.radioGroup);
        Button nextButton = findViewById(R.id.nextButton);

        questions = QuestionData.getQuestions();

        setQuestionAndAnswers();

        nextButton.setOnClickListener(v -> {
            int selectedId = radioGroup.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId);

            if (selectedId == radioGroup.getChildAt(questions.get(currentQuestionIndex).getCorrectAnswerIndex()).getId()) {
                score = 1;
            } else {
                score = 0;
            }
            Log.d("QuizApp", "Aktualny wynik: " + score);
            Intent intent = new Intent(Question1.this, Question2.class);
            intent.putExtra("score", score);
            startActivity(intent);
        });
    }

    private void setQuestionAndAnswers() {
        Question currentQuestion = questions.get(currentQuestionIndex);
        TextView questionTextView = findViewById(R.id.questionTextView);
        questionTextView.setText(currentQuestion.getQuestionText());

        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            RadioButton radioButton = (RadioButton) radioGroup.getChildAt(i);
            radioButton.setText(currentQuestion.getAnswers()[i]);
        }
    }
}
