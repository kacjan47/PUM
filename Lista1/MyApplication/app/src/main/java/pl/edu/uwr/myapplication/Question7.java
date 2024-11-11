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

public class Question7 extends AppCompatActivity {

    private int score;
    private RadioGroup radioGroup;
    private List<Question> questions;
    private Question currentQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question7);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        score = getIntent().getIntExtra("score", 0);

        questions = QuestionData.getQuestions();
        currentQuestion = questions.get(6);

        setQuestionAndAnswers();

        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(v -> {
            int selectedId = radioGroup.getCheckedRadioButtonId();
            RadioButton selectedRadioButton = findViewById(selectedId);

            if (selectedId == radioGroup.getChildAt(currentQuestion.getCorrectAnswerIndex()).getId()) {
                score += 1;
            }
            Log.d("QuizApp", "Aktualny wynik: " + score);

            Intent intent = new Intent(Question7.this, Question8.class);
            intent.putExtra("score", score);
            startActivity(intent);
        });
    }

    private void setQuestionAndAnswers() {
        TextView questionTextView = findViewById(R.id.questionText);
        questionTextView.setText(currentQuestion.getQuestionText());

        radioGroup = findViewById(R.id.radioGroup);
        String[] answers = currentQuestion.getAnswers();

        ((RadioButton) radioGroup.getChildAt(0)).setText(answers[0]);
        ((RadioButton) radioGroup.getChildAt(1)).setText(answers[1]);
        ((RadioButton) radioGroup.getChildAt(2)).setText(answers[2]);
        ((RadioButton) radioGroup.getChildAt(3)).setText(answers[3]);
    }
}
