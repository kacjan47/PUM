package pl.edu.uwr.myapplication;

import java.util.ArrayList;
import java.util.List;

public class QuestionData {
    public static List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();

        // Pytanie 1
        questions.add(new Question(
                "Jaka jest stolica Australii?",
                new String[]{"Canberra", "Sydney", "Melbourne", "Brisbane"},
                0 // Indeks poprawnej odpowiedzi (Canberra)
        ));

        // Pytanie 2
        questions.add(new Question(
                "Jakie jest największe miasto w Australii?",
                new String[]{"Sydney", "Melbourne", "Brisbane", "Perth"},
                0 // Indeks poprawnej odpowiedzi (Sydney)
        ));

        // Pytanie 3
        questions.add(new Question(
                "Który kraj jest największym producentem kawy na świecie?",
                new String[]{"Brazylia", "Kolumbia", "Wietnam", "Etiopia"},
                0 // Indeks poprawnej odpowiedzi (Brazylia)
        ));

        questions.add(new Question(
                "Który ocean jest największy na świecie?",
                new String[]{"Ocean Atlantycki", "Ocean Arktyczny", "Ocean Indyjski", "Ocean Spokojny"},
                3 // Indeks poprawnej odpowiedzi (Ocean Spokojny)
        ));

        questions.add(new Question(
                "Które państwo ma najwięcej ludności?",
                new String[]{"Indie", "Chiny", "Stany Zjednoczone", "Rosja"},
                1 // Indeks poprawnej odpowiedzi (Chiny)
        ));

        questions.add(new Question(
                "Kto wynalazł żarówkę elektryczną?",
                new String[]{"Nikola Tesla", "Thomas Edison", "Alexander Graham Bell", "Michael Faraday"},
                1 // Indeks poprawnej odpowiedzi (Thomas Edison)
        ));

        questions.add(new Question(
                "W którym roku Polska odzyskała niepodległość?",
                new String[]{"1918", "1920", "1939", "1945"},
                0 // Indeks poprawnej odpowiedzi (1918)
        ));

        questions.add(new Question(
                "Jakie jest najwyższe zwierzę na świecie?",
                new String[]{"Słoń", "Żyrafa", "Wieloryb", "Lew"},
                1 // Indeks poprawnej odpowiedzi (Żyrafa)
        ));

        questions.add(new Question(
                "Która planeta jest najbliżej Słońca?",
                new String[]{"Wenus", "Ziemia", "Merkury", "Mars"},
                2 // Indeks poprawnej odpowiedzi (Merkury)
        ));

        questions.add(new Question(
                "Które miasto jest stolicą Japonii?",
                new String[]{"Osaka", "Kioto", "Tokio", "Hiroszima"},
                2 // Indeks poprawnej odpowiedzi (Tokio)
        ));
        return questions;
    }
}

