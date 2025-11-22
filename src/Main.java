import model.Answer;
import model.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question(
                "What is the capital of France?",
                List.of(
                        new Answer("Paris"),
                        new Answer("London"),
                        new Answer("Berlin"),
                        new Answer("Madrid")
                ),
                0
        ));

        questions.add(new Question(
                "Which number is even?",
                List.of(
                        new Answer("3"),
                        new Answer("7"),
                        new Answer("10"),
                        new Answer("9")
                ),
                2
        ));

        questions.add(new Question(
                "Which language is commonly used for Android apps?",
                List.of(
                        new Answer("Java"),
                        new Answer("HTML"),
                        new Answer("CSS"),
                        new Answer("SQL")
                ),
                0
        ));

        questions.add(new Question(
                "Which one is an ocean?",
                List.of(
                        new Answer("Sahara"),
                        new Answer("Pacific"),
                        new Answer("Alps"),
                        new Answer("Amazon")
                ),
                1
        ));

        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + q.getQuestionText());

            List<Answer> answers = q.getAnswers();
            for (int j = 0; j < answers.size(); j++) {
                System.out.println((j + 1) + ") " + answers.get(j).getText());
            }

            System.out.print("Your answer (1-" + answers.size() + "): ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine()) - 1;
            } catch (NumberFormatException e) {
                choice = -1;
            }

            if (choice >= 0 && choice < answers.size()) {
                if (q.isCorrect(choice)) {
                    System.out.println("Correct!\n");
                    score++;
                } else {
                    System.out.println("Wrong.\n");
                }
            } else {
                System.out.println("Invalid answer.\n");
            }
        }

        System.out.println("Quiz finished. You scored " + score + " out of " + questions.size() + ".");
        scanner.close();
    }
}
