package model;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class QuizSerializer {
    private static final Gson gson = new Gson();

    public static void saveQuiz(Quiz quiz, String fileName) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(quiz, writer);
        }
    }

    public static Quiz loadQuiz(String fileName) throws IOException {
        try (FileReader reader = new FileReader(fileName)) {
            return gson.fromJson(reader, Quiz.class);
        }
    }
}
