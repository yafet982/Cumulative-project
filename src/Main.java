import model.Answer;
import model.IAnswer;
import model.IQuestion;
import model.Question;
import model.Quiz;
import model.QuizSerializer;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IAnswer a1 = new Answer("Paris", true);
        IAnswer a2 = new Answer("London", false);
        IAnswer a3 = new Answer("Berlin", false);

        IQuestion q1 = new Question(
                "What is the capital of France?",
                List.of(a1, a2, a3)
        );

        IAnswer a4 = new Answer("4", true);
        IAnswer a5 = new Answer("3", false);
        IAnswer a6 = new Answer("5", false);

        IQuestion q2 = new Question(
                "What is 2 + 2?",
                List.of(a4, a5, a6)
        );

        Quiz quiz = new Quiz("Sample Quiz", List.of((Question) q1, (Question) q2));

        try {
            QuizSerializer.saveQuiz(quiz, "quiz.json");
        } catch (IOException e) {
            System.out.println("Failed to save JSON file.");
        }

        Quiz loadedQuiz = null;
        try {
            loadedQuiz = QuizSerializer.loadQuiz("quiz.json");
        } catch (IOException e) {
            System.out.println("Failed to load JSON file.");
        }

        if (loadedQuiz != null) {
            System.out.println("Loaded quiz: " + loadedQuiz.getTitle());

            Scanner scanner = new Scanner(System.in);
            int score = 0;

            for (IQuestion question : loadedQuiz.getQuestions()) {
                System.out.println(question.getQuestionText());
                List<IAnswer> answers = question.getAnswers();

                for (int i = 0; i < answers.size(); i++) {
                    System.out.println((i + 1) + ". " + answers.get(i).getText());
                }

                System.out.print("Choose your answer (1-" + answers.size() + "): ");
                int userChoice = scanner.nextInt();
                int index = userChoice - 1;

                if (((Question) question).isCorrectAnswer(index)) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong!");
                }

                System.out.println();
            }

            System.out.println("Your score: " + score + " out of " + loadedQuiz.getQuestions().size());
        }
    }
}
