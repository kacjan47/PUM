package pl.edu.uwr.quizappkotlin

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun QuizScreen() {
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var selectedAnswer by remember { mutableStateOf(-1) }
    var score by remember { mutableStateOf(0) }
    var isQuizFinished by remember { mutableStateOf(false) }

    // Przypisanie pytania lub null, jeśli quiz jest zakończony
    val currentQuestion = if (!isQuizFinished) questionList[currentQuestionIndex] else null
    val totalQuestions = questionList.size

    // Wyświetlanie ekranu podsumowania
    if (isQuizFinished) {
        ResultScreen(score, totalQuestions)
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Nagłówek pytania
            Text(
                text = "Pytanie ${currentQuestionIndex + 1}/$totalQuestions",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Pasek postępu
            LinearProgressIndicator(
                progress = (currentQuestionIndex + 1).toFloat() / totalQuestions,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            // Bezpieczny dostęp do treści pytania
            currentQuestion?.let { question ->
                Card(
                    elevation = CardDefaults.cardElevation(4.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Text(
                        text = question.question,
                        modifier = Modifier.padding(16.dp)
                    )
                }

                // Opcje odpowiedzi
                LazyColumn {
                    items(question.options.size) { index ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { selectedAnswer = index }
                                .padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = selectedAnswer == index,
                                onClick = { selectedAnswer = index }
                            )
                            Text(
                                text = question.options[index],
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            // Przycisk "Następne"
            Button(
                onClick = {
                    if (currentQuestion != null && selectedAnswer == currentQuestion.correctAnswer) {
                        score++
                    }
                    if (currentQuestionIndex < totalQuestions - 1) {
                        currentQuestionIndex++
                        selectedAnswer = -1
                    } else {
                        isQuizFinished = true
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text("Następne")
            }
        }
    }
}

@Composable
fun ResultScreen(score: Int, totalQuestions: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Gratulacje",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Card(
            elevation = CardDefaults.cardElevation(4.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp)
            ) {
                Text(
                    text = "Zdobyłeś ${score * 10} pkt",
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
    }
}
