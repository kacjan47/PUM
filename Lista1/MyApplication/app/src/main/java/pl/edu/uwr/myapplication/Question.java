package pl.edu.uwr.myapplication;

public class Question {
    private String questionText;
    private String[] answers;  // Tablica odpowiedzi
    private int correctAnswerIndex;  // Indeks poprawnej odpowiedzi

    public Question(String questionText, String[] answers, int correctAnswerIndex) {
        this.questionText = questionText;
        this.answers = answers;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getAnswers() {
        return answers;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}
